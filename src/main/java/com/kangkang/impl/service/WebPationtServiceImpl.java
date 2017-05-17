package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class WebPationtServiceImpl implements WebPationtService {

    @Autowired
    private TUsersMapper usersMapper;
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
}
