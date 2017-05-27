package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.StatisticsService;
import com.kangkang.api.util.HighChartUtils;
import com.kangkang.api.vo.AppstatisticsParam;
import com.kangkang.api.vo.highchat.HighchartsConfig;
import com.kangkang.api.vo.highchat.Series;
import com.kangkang.api.vo.statistics.IndexRs;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.ldg.api.util.DateUtil;
import com.ldg.api.vo.DayAndWeek;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/5/25.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private AcceptkkdataMapper acckkDao;

    /**
     * 获取一天区间数据
     * @param param
     * @return
     */
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
    private final  Boolean isHaveDataByDays(AppstatisticsParam param,int days) {
        if(param.getSearchDate()==null){
            return null;
        }
        Date[] bwdate = DateUtil.getBeforeDATEBetween(param.getSearchDate(),days );
        param.setStart(bwdate[0]);
        param.setEnd(bwdate[1]);
        int count=acckkDao.dataCountByDays(param);
        if(count>0){
            return true;
        }
        return false;
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

    @Override
    public HighchartsConfig displayDayChat(AppstatisticsParam param) {
        IndexRs indexrs=getKKDataByPatientidAndSearchDate(param);//获取日期当天的数据
        if(indexrs!=null&&indexrs.getMeasureData()!=null&&indexrs.getMeasureData().size()!=0){
            StringBuilder title=new StringBuilder();
            title.append(DateFormatUtils.format(param.getSearchDate(), DateUtil.yyyy_MM_dd)).append(" 日血压图");
            HighchartsConfig hcfg= HighChartUtils.createBasicChat(title.toString(),"血压/心率值");
            List<String> xAxisCategories=new ArrayList<>();//横轴
            List<Integer> shousuoL=new ArrayList<>();
            List<Integer> shuzhangL=new ArrayList<>();
            List<Integer> xinlvL=new ArrayList<>();
            indexrs.getMeasureData().forEach(item->{
                int shousuo=item.getSystolicpressure();//收缩压
                int shuzhang=item.getDiastolicpressure();//舒张压
                int xinlv=item.getPulse();//心率
                Date measureTime=item.getKktime();//测量时间
                String strmeasureTime= DateFormatUtils.format(measureTime,DateUtil.HH_mm_ss);
                xAxisCategories.add(strmeasureTime);
                shousuoL.add(shousuo);
                shuzhangL.add(shuzhang);
                xinlvL.add(xinlv);
            });
            hcfg.getxAxis().setCategories(xAxisCategories);
            Series shousuoSeries=new Series();
            shousuoSeries.setName("收缩压");
            shousuoSeries.setType("spline");
            shousuoSeries.setData(shousuoL);

            Series shuzhangSeries=new Series();
            shuzhangSeries.setName("舒张压");
            shuzhangSeries.setType("spline");
            shuzhangSeries.setData(shuzhangL);

            Series xinlvSeries=new Series();
            xinlvSeries.setName("心率");
            xinlvSeries.setType("column");
            xinlvSeries.setData(xinlvL);
            List<Series> series=hcfg.getSeries();
            series.add(xinlvSeries);//先添加的在下面
            series.add(shousuoSeries);
            series.add(shuzhangSeries);
            return hcfg;
        }else{
            return HighchartsConfig.getNullcig();
        }
    }

    @Override
    public HighchartsConfig displayWeekChat(AppstatisticsParam param) {
        //1.查看区间有没有数据
        if(isHaveDataByDays(param,SysConstant.Statistics_DAYS_WEEK)){
        //2.根据当前日期获取前七天的日期
           List<DayAndWeek> weekDays=DateUtil.getDaysByDateAndNeedDays(param.getSearchDate(),SysConstant.Statistics_DAYS_WEEK);

        }
        return null;
    }
}
