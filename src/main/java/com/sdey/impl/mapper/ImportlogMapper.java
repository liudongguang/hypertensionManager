package com.sdey.impl.mapper;

import com.sdey.api.po.Importlog;
import com.sdey.api.vo.ext.GroupImportlogForFenPei;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ImportlogMapper extends Mapper<Importlog> {
    Integer selectByDate(String date);
    List<GroupImportlogForFenPei> getKeFenPeiList();

     int updateFenpeiWorkState(String fenpeiDate);

    List<Importlog> selectAllByYear(String thisYear);
}