package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.HytbDeviceLandlogMapper;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.DateUtil;
import com.ldg.api.util.MD5Util;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class WebPationtServiceImpl implements WebPationtService {

    @Autowired
    private TUsersMapper usersMapper;
    @Autowired
    private RongYunServie rongYunServie;
    @Autowired
    private HytbDeviceLandlogMapper deviceLandlogDao;
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryMapper;

    @Override
    public PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam) {
        PageInfo<TUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> usersMapper.selectAllForPatientListList());
        return pageInfo;
    }

    @Override
    public String checkValidate(SavePatientParam checkParam) {
        Integer uid = usersMapper.selectUidByPhone(checkParam);
        if (uid != null) {
            return "手机号已存在！";
        }
        return null;
    }

    private int bindDevice(TUsers user, SavePatientParam param) {
        HytbDeviceLandlog landlog = new HytbDeviceLandlog();//租借记录
        landlog.setBeizhu(param.getBeizhu());
        landlog.setCreatetime(new Date());
        landlog.setDeviceid(param.getShebeiUID());
        landlog.setDevicesn(param.getShebeiSN());
        landlog.setReturnstate(SysConstant.DEVICE_LAND_CHUJIE);//设置借出状态
        landlog.setPatientid(user.getUid());
        landlog.setZjstart(param.getZjstart());
        landlog.setZjend(param.getZjend());
        deviceLandlogDao.insertSelective(landlog);  //保存租借记录
        HytbDeviceRepertory repertory = new HytbDeviceRepertory();
        repertory.setUid(param.getShebeiUID());
        repertory.setLandlogid(landlog.getUid());
        return deviceRepertoryMapper.saveLandIDForBind(repertory);//把当前绑定记录关联到设备上
    }

    @Override
    public int savePatient(SavePatientParam param) throws AesException {
        if (param.getUid() != null) {
            TUsers user = new TUsers();
            user.setUid(param.getUid());
            user.setName(param.getName());
            user.setRegistphone(param.getRegistphone());
            user.setSex(param.getSex());
            //////////与当前设备不是同一个则自动取消绑定，绑定这个。否则不变
            //获取当前绑定设备记录
            HytbDeviceLandlog currentlandlog = deviceLandlogDao.getCurrentBindLog(user.getUid());
            if (currentlandlog != null) {
                if (!currentlandlog.getDeviceid().equals(param.getShebeiUID())) {
                    //解除，绑定
                    currentlandlog.setReturnstate(SysConstant.DEVICE_LAND_REPLACE);//替换状态
                    int unbindNum = deviceLandlogDao.updateBindDeviceState(currentlandlog);
                    bindDevice(user, param);
                    user.setSn(param.getShebeiSN());
                }
            } else {
                //直接绑定
                user.setSn(param.getShebeiSN());
                bindDevice(user, param);
            }
            usersMapper.updateByPrimaryKeySelective(user);
        } else {
            String phone = param.getRegistphone();
            final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
            TUsers user = new TUsers();
            if (200 == ryrsObj.getCode()) {
                user.setUsername(phone);
                user.setName(param.getName());
                user.setRegistphone(ryrsObj.getUserId());
                user.setCreatetime(new Date());
                user.setPassword(MD5Util.string2MD5(phone));
                user.setRytoken(ryrsObj.getToken());
                user.setRongid(phone);
                user.setSn(param.getShebeiSN());////用户绑定设备
                user.setSex(param.getSex());
                user.setBirthday(param.getBirthday());
                Integer age = DateUtil.getyearsCha(param.getBirthday(), new Date());
                user.setAge(age);
                usersMapper.insertSelective(user);//保存用户
                ///////设备绑定状态修改
                if (param.getShebeiUID() != null) {
                    bindDevice(user, param);
                }
            }
        }
        return 0;
    }

    @Override
    public SavePatientParam patientBindDeviceByUid(Integer patientid) {
        SavePatientParam user = usersMapper.selectPatientForBind(patientid);
        return user;
    }


}
