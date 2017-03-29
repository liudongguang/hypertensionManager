package com.sdey.impl.mapper;

import com.sdey.api.po.Patients;
import com.sdey.api.vo.DisSearch;
import com.sdey.api.vo.ext.DisPatients;
import com.sdey.api.vo.ext.FenpeiWorkPlus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PatientsMapper extends Mapper<Patients> {
    /**
     * 根据条件获取病人列表，若不是超级管理则查询分配任务有关的病人
     * @param search
     * @return
     */
    List<DisPatients> selectDisPatients(DisSearch search);

    /**
     * 根据日期获取记录
     * @param fenpeiDate
     * @return
     */
    List<Integer> selectUidsByDate(String fenpeiDate);

    /**
     * 获取记录，包含出院科室，病人id
     * @param fenpeiDate
     * @return
     */
    List<FenpeiWorkPlus> selectUidsByDatePlus(String fenpeiDate);

    /**
     * 获取科室列表
     * @return
     */
    List<String> getListKsName();
}