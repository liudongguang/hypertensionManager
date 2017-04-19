package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.util.SysPropertiesUtil;
import com.kangkang.api.util.rongyun.RongYunSHA1;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SetPwdVo;
import com.kangkang.constant.PropertiestConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.HttpClientUtil;
import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liudo on 2017/3/30.
 */
@Service
public class KangKangDataServiceImpl implements KangKangDataService {
    @Autowired
    private AcceptkkdataMapper acceptkkdataMapper;

    @Autowired
    private TUsersMapper usersMapper;

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
    public Integer getUserByPhoneNumber(GetVerificationCodeParam param) {
        return usersMapper.getUserByPhoneNumber(param);
    }

    @Override
    public TUsers registerUser(SetPwdVo param) throws AesException {
        String phone=param.getMobile();
        String RongYunHeadImgURL = SysPropertiesUtil.getRongYunValByKey(PropertiestConstant.RONGYUN_HEADIMGURL);
        String RongYunGetToken = SysPropertiesUtil.getRongYunValByKey(PropertiestConstant.RONGYUN_GETTOKEN);
        ////
        String appSecret = SysPropertiesUtil.getRongYunInfo().getAppSecret();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = RandomStringUtils.randomNumeric(5);
        String signature = RongYunSHA1.getRongYunSHA1(appSecret, nonce, timestamp);
        /////////
        HttpClientUtil htc = HttpClientUtil.getInstance();
        Map<String, String> htcHeader = new HashMap<>();
        htcHeader.put("App-Key", SysPropertiesUtil.getRongYunInfo().getAppAppKey());
        htcHeader.put("Nonce", nonce);
        htcHeader.put("Timestamp", timestamp);
        htcHeader.put("Signature", signature);
        ////
        Map<String, String> htcParam = new HashMap<>();
        htcParam.put("userId",phone);
        htcParam.put("name", phone);
        htcParam.put("portraitUri", RongYunHeadImgURL);
        String ts = htc.sendHttpPost(RongYunGetToken, htcHeader, htcParam);
        RongYunJsonRsInfo ryrsObj= JsonUtil.getObjectByJSON(ts,RongYunJsonRsInfo.class);
        TUsers user=new TUsers();
        if(200==ryrsObj.getCode()){
            user.setUsername(phone);
            user.setName(phone);
            user.setRegistphone(ryrsObj.getUserId());
            user.setCreatetime(new Date());
            user.setPassword(param.getPassword());
            user.setRytoken(ryrsObj.getToken());
            usersMapper.insertSelective(user);
            user.setPassword(null);
        }
        return user;
    }
}
