package com.kangkang.impl.service;

import com.kangkang.api.service.WebManagerService;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.api.vo.WebParamVo;
import com.kangkang.impl.mapper.TUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuDongguang on 2017/4/21.
 */
@Service
public class WebManagerServiceImpl implements WebManagerService {
    @Autowired
    private TUsersMapper usersMapper;
    @Override
    public Integer getUserByUserName(String username) {
        return usersMapper.getUserByUserName(username);
    }

    @Override
    public TUsersExt loginForWeb(WebParamVo param) {
        return usersMapper.loginForWeb(param);
    }
}
