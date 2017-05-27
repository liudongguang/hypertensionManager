package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
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

    @Override
    public int saveKangkangData(Acceptkkdata accData) {
        //1.查询是否绑定了用户，绑定了就设置绑定的用户id
        Integer userId = usersMapper.selectUidByAcceptkkdata(accData);
        if (userId != null) {
            accData.setUserid(userId);
        }
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

    @Override
    public TUsersExt registerUser(AppParamVo param) throws AesException {
        //如果手机号已存在，则进行更新
        Integer uid = getUserByPhoneNumber(param.getMobile());
        TUsersExt user = new TUsersExt();
        String phone = param.getMobile();
        if (uid != null) {
            user.setUid(uid);
            user.setPassword(param.getPassword());
            usersMapper.updateByPrimaryKeySelective(user);
        } else {
            final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
            if (200 == ryrsObj.getCode()) {
                user.setUsername(phone);
                user.setRegistphone(ryrsObj.getUserId());
                user.setCreatetime(new Date());
                user.setRytoken(ryrsObj.getToken());
                user.setRongid(phone);
                if (param.getHeadimageurl() == null) {
                    user.setHeadimageurl(SysConstant.DEFAULT_HEADIMG);
                } else {
                    user.setHeadimageurl(param.getHeadimageurl());
                }
                if (param.getState() == 1) {
                    user.setName(phone);
                    user.setPassword(param.getPassword());
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
                usersMapper.insertSelective(user);
                user.setPassword(null);
            }
        }
        return user;
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
    public int relevanceDevice(TUsers user) {
        return usersMapper.relevanceDevice(user);
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


}
