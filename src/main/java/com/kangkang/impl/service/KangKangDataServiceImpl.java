package com.kangkang.impl.service;

import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer userId=usersMapper.selectUidByAcceptkkdata(accData);
        if(userId!=null){
            accData.setUid(userId);
        }
        return acceptkkdataMapper.insertSelective(accData);
    }
}
