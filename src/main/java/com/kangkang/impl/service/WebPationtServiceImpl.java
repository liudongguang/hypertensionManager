package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.impl.mapper.TUsersMapper;
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
    @Override
    public PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam) {
        PageInfo<TUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> usersMapper.selectAllForPatientListList());
        return pageInfo;
    }

    @Override
    public String checkValidate(SavePatientParam checkParam) {
        Integer uid=usersMapper.selectUidByPhone(checkParam);
        if(uid!=null){
            return "手机号已存在！";
        }
        return null;
    }

    @Override
    public int savePatient(SavePatientParam param) throws AesException {
        String phone=param.getRegistphone();
        final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
        TUsersExt user=new TUsersExt();
        if(200==ryrsObj.getCode()){
            user.setUsername(phone);
            user.setName(param.getName());
            user.setRegistphone(ryrsObj.getUserId());
            user.setCreatetime(new Date());
            user.setPassword(phone);
            user.setRytoken(ryrsObj.getToken());
            user.setRongid(phone);
            usersMapper.insertSelective(user);
            ///////绑定设备
            if(param.getShebeiUID()!=null){

            }
        }
        return 0;
    }
}
