package com.sdey.impl.mapper;

import com.sdey.api.po.Manager;
import com.sdey.api.vo.UpdatePassParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ManagerMapper extends Mapper<Manager> {
    Manager login(Manager loginUser);

    List<Manager> getManagerList();

    Integer checkManagerUserName(String username);

    Integer selectManagerIDByUidAndPass(UpdatePassParam param);

    int updatePasswordByUid(UpdatePassParam param);
}