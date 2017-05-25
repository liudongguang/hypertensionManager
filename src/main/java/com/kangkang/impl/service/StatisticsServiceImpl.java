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

    @Override
    public IndexRs getLastDateMeasureData(AppstatisticsParam param) {
        //1.获取测量的最后一天的信息
        PageInfo<Date> pageInfo = PageHelper.startPage(1, 1, false).doSelectPageInfo(() -> acckkDao.getgetLastDateByPatientID(param));
        if (pageInfo.getTotal() != 0) {
            Date lastDate = pageInfo.getList().get(0);
            Date[] bwdate = DateUtil.getDATEBetween(lastDate);
            param.setStart(bwdate[0]);
            param.setEnd(bwdate[1]);
            List<Acceptkkdata> rslist = acckkDao.getMeasureDateByBetDate(param);
            if (rslist.size() != 0) {
                IndexRs rs = new IndexRs();
                rs.setLastDate(lastDate);
                rs.setMeasureData(rslist);
                return rs;
            }
        }
        return null;
    }

    @Override
    public IndexRs getTodayDateMeasureData(AppstatisticsParam param) {
        Date today = new Date();
        IndexRs rs = new IndexRs();
        rs.setLastDate(today);
        Date[] bwdate = DateUtil.getDATEBetween(today);
        param.setStart(bwdate[0]);
        param.setEnd(bwdate[1]);
        List<Acceptkkdata> rslist = acckkDao.getMeasureDateByBetDate(param);
        if (rslist.size() != 0) {
            rs.setMeasureData(rslist);
        }
        return rs;
    }
}
