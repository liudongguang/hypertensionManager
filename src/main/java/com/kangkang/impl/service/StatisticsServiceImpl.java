package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.StatisticsService;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.statistics.IndexRs;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.ldg.api.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/25.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private AcceptkkdataMapper acckkDao;

    private final  IndexRs getMeasureDateByBetDate(AppstatisticsParam param) {
        if(param.getSearchDate()==null){
            return null;
        }
        IndexRs rs = new IndexRs();
        rs.setLastDate(param.getSearchDate());
        Date[] bwdate = DateUtil.getDATEBetween(param.getSearchDate());
        param.setStart(bwdate[0]);
        param.setEnd(bwdate[1]);
        List<Acceptkkdata> rslist = acckkDao.getMeasureDateByBetDate(param);
        if (rslist.size() != 0) {
            rs.setMeasureData(rslist);
        }
        return rs;
    }

    @Override
    public IndexRs getLastDateMeasureData(AppstatisticsParam param) {
        //1.获取测量的最后一天的信息
        PageInfo<Date> pageInfo = PageHelper.startPage(1, 1, false).doSelectPageInfo(() -> acckkDao.getgetLastDateByPatientID(param));
        if (pageInfo.getList().size()!=0) {
            Date lastDate = pageInfo.getList().get(0);
            param.setSearchDate(lastDate);
            return getMeasureDateByBetDate(param);
        }
        return null;
    }

    @Override
    public IndexRs getTodayDateMeasureData(AppstatisticsParam param) {
        param.setSearchDate(new Date());
        return getMeasureDateByBetDate(param);
    }

    @Override
    public IndexRs getKKDataByPatientidAndSearchDate(AppstatisticsParam param) {
        return getMeasureDateByBetDate(param);
    }
}
