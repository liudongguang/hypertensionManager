package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.HytbDeviceLandlogMapper;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by liudo on 2017/3/30.
 */
@Service
public class KangKangDataServiceImpl implements KangKangDataService {
    @Autowired
    private AcceptkkdataMapper acceptkkdataMapper;

    @Autowired
    private TUsersMapper usersMapper;
    @Autowired
    private RongYunServie rongYunServie;

    @Autowired
    private HytbDeviceLandlogMapper deviceLandlogDao;
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryMapper;


    @Override
    public int saveKangkangData(Acceptkkdata accData) {
        //1.查询是否绑定了用户，绑定了就设置绑定的用户id
        Integer userId = usersMapper.selectUidByAcceptkkdata(accData);
        if (userId != null) {
            accData.setUserid(userId);
        }
        accData.setSource(SysConstant.ACCEPT_DATA_TYPE_KK);//康康类型
        return acceptkkdataMapper.insertSelective(accData);
    }

    @Override
    public PageInfo<Acceptkkdata> hypertensionListByUser(PageParam pageParam) {
        PageInfo<Acceptkkdata> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> acceptkkdataMapper.selectAllForHypertensionList());
        return pageInfo;
    }

    @Override
    public Integer getUserByPhoneNumber(String mobile) {
        return usersMapper.getUserByPhoneNumber(mobile);
    }

    @Override
    public Integer getUserByPhoneNumberForRegist(String mobile) {
        return usersMapper.getUserByPhoneNumberForRegist(mobile);
    }

    private TUsersExt handlerRegist( Integer userid ,String phone, AppParamVo param, RongYunJsonRsInfo ryrsObj) {
        TUsersExt user = new TUsersExt();
        user.setUsername(phone);
        if (ryrsObj != null) {
            user.setRegistphone(ryrsObj.getUserId());
            user.setRytoken(ryrsObj.getToken());
        }
        user.setRongid(phone);
        user.setPassword(param.getPassword());
        if (param.getHeadimageurl() == null) {
            user.setHeadimageurl(SysConstant.DEFAULT_HEADIMG);
        } else {
            user.setHeadimageurl(param.getHeadimageurl());
        }
        if (param.getState() == 1) {
            user.setName(phone);
            //  user.setPassword(param.getPassword());
        } else if (param.getState() == 2) {//不设置密码
            user.setName(param.getName());
            if (param.getSex() != null) {
                if (param.getSex().equals("1")) {
                    user.setSex("男");
                } else {
                    user.setSex("女");
                }
            }
            user.setOpenid(param.getOpenid());
            user.setCity(param.getCity());
            user.setProvince(param.getProvince());
        }

        if (userid != null) {
            user.setUid(userid);
            user.setName(null);
            user.setHeadimageurl(null);
            user.setSex(null);
            usersMapper.updateByPrimaryKeySelective(user);
        } else {
            user.setCreatetime(new Date());
            usersMapper.insertSelective(user);
        }
        user.setPassword(null);
        return user;
    }

    @Override
    public TUsersExt registerUser(AppParamVo param) throws AesException {
        String phone = param.getMobile();
        Integer userid = getUserByPhoneNumber(phone);
        if (userid == null) {
            final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
            if (200 == ryrsObj.getCode()) {
                return handlerRegist(userid,phone,param,ryrsObj);
            }
        } else {
            //不注册融云
            return handlerRegist(userid,phone,param,null);
        }

        return null;
    }

    @Override
    public TUsersExt login(AppParamVo param) {
        return usersMapper.selectUserByMobileAndPass(param);
    }

    @Override
    public int resetPwd(AppParamVo param) {
        return usersMapper.resetPwd(param);
    }

    @Override
    public String relevanceDevice(TUsers user) {
        ////////若在库存，添加绑定记录并且符合条件
        HytbDeviceRepertory device = deviceRepertoryMapper.getDeviceBySN(user.getSn());
        if (device != null) {
            if (SysConstant.DeviceRepertory_DESTROY_YES == device.getDestroy().intValue()) {
                return "销毁设备不能使用！";
            }
            if (device.getLandlogid() != null) {
                return "使用中！";
            }
            ////////
            HytbDeviceLandlog landlog = new HytbDeviceLandlog();//租借记录
            landlog.setBeizhu("扫码绑定");
            landlog.setCreatetime(new Date());
            landlog.setDeviceid(device.getUid());
            landlog.setDevicesn(user.getSn());
            landlog.setReturnstate(SysConstant.DEVICE_LAND_CHUJIE);//设置借出状态
            landlog.setPatientid(user.getUid());
            deviceLandlogDao.insertSelective(landlog);  //保存租借记录
            HytbDeviceRepertory repertory = new HytbDeviceRepertory();
            repertory.setUid(device.getUid());
            repertory.setLandlogid(landlog.getUid());
            deviceRepertoryMapper.saveLandIDForBind(repertory);//把当前绑定记录关联到设备上
        }
        if (usersMapper.relevanceDevice(user) == 0) {
            return "绑定失败！";
        }
        return null;
    }

    @Override
    public TUsers isBindedBySN(TUsers user) {
        return usersMapper.isBindedBySN(user);
    }

    @Override
    public int unBindedDevice(TUsers user) {
        return usersMapper.unBindedDevice(user);
    }

    @Override
    public TUsers isBindedByUid(TUsers user) {
        return usersMapper.isBindedByUid(user);
    }

    @Override
    public Integer getUserByOpenIDForRegistWX(String openid) {
        return usersMapper.getUserByOpenIDForRegistWX(openid);
    }
}
