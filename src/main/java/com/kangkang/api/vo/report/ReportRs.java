package com.kangkang.api.vo.report;

import com.kangkang.api.po.Acceptkkdata;

import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/6/8.
 */
public class ReportRs {
    private String name;//姓名
    private String sex;//性别
    private List<Acceptkkdata> acceptDataList;//日期范围内的数据
    private Date logStartTime;//记录开始时间
    private Date logEndTime;//记录结束时间
    private String shicha;//时差
    private Integer logSize;//记录次数
    private Integer maxSystolic;//最大收缩压
    private Integer minSystolic;//最小收缩压
    private Date maxSystolicTime;//最大收缩压时间
    private Date minSystolicTime;//最小收缩压时间
    private Integer avgSystolic;//收缩压的平均值
    private Double shousuobianyi;//收缩变异系数
    private Double shousuofuhe;//血压负荷收缩压
    /****/
    private Integer maxDiastolic;//最大舒张压
    private Integer minDiastolic;//最小舒张压
    private Date maxDiastolicTime;//最大舒张压时间
    private Date minDiastolicTime;//最小舒张压时间
    private Integer avgDiastolic;//舒张压的平均值
    private Double shuzhangbianyi;//舒张变异系数
    private Double shuzhangfuhe;//血压负荷舒张压
    /***/
    private Integer maxHrrest;//最大心率
    private Integer minHrrest;//最小心率
    private Integer avgHrrest;//心率平均值
    private Integer avgMaiyacha;//脉压差
    /**日统计start*/
    private Integer daymaxSystolic;//最大收缩压
    private Integer dayminSystolic;//最小收缩压
    private Date daymaxSystolicTime;//最大收缩压时间
    private Date dayminSystolicTime;//最小收缩压时间
    private Integer dayavgSystolic;//收缩压的平均值
    private Double dayshousuobianyi;//收缩变异系数
    private Double dayshousuofuhe;//血压负荷收缩压
    /****/
    private Integer daymaxDiastolic;//最大舒张压
    private Integer dayminDiastolic;//最小舒张压
    private Date daymaxDiastolicTime;//最大舒张压时间
    private Date dayminDiastolicTime;//最小舒张压时间
    private Integer dayavgDiastolic;//舒张压的平均值
    private Double dayshuzhangbianyi;//舒张变异系数
    private Double dayshuzhangfuhe;//血压负荷舒张压
    /***/
    private Integer daymaxHrrest;//最大心率
    private Integer dayminHrrest;//最小心率
    private Integer dayavgHrrest;//心率平均值
    private Integer dayavgMaiyacha;//脉压差
    /**日统计end*/
    /**晚上统计start*/
    private Integer nightmaxSystolic;//最大收缩压
    private Integer nightminSystolic;//最小收缩压
    private Date nightmaxSystolicTime;//最大收缩压时间
    private Date nightminSystolicTime;//最小收缩压时间
    private Integer nightavgSystolic;//收缩压的平均值
    private Double nightshousuobianyi;//收缩变异系数
    private Double nightshousuofuhe;//血压负荷收缩压
    /****/
    private Integer nightmaxDiastolic;//最大舒张压
    private Integer nightminDiastolic;//最小舒张压
    private Date nightmaxDiastolicTime;//最大舒张压时间
    private Date nightminDiastolicTime;//最小舒张压时间
    private Integer nightavgDiastolic;//舒张压的平均值
    private Double nightshuzhangbianyi;//舒张变异系数
    private Double nightshuzhangfuhe;//血压负荷舒张压

    /***/
    private Integer nightmaxHrrest;//最大心率
    private Integer nightminHrrest;//最小心率
    private Integer nightavgHrrest;//心率平均值
    private Integer nightavgMaiyacha;//脉压差
    /**晚上统计end*/
   private Double yeshousuoxjl;//夜间血压收缩压下降率
   private Double yeshuzhangxjl;//夜间血压舒张压下降率


    public Double getYeshousuoxjl() {
        return yeshousuoxjl;
    }

    public void setYeshousuoxjl(Double yeshousuoxjl) {
        this.yeshousuoxjl = yeshousuoxjl;
    }

    public Double getYeshuzhangxjl() {
        return yeshuzhangxjl;
    }

    public void setYeshuzhangxjl(Double yeshuzhangxjl) {
        this.yeshuzhangxjl = yeshuzhangxjl;
    }

    public Double getShousuobianyi() {
        return shousuobianyi;
    }

    public void setShousuobianyi(Double shousuobianyi) {
        this.shousuobianyi = shousuobianyi;
    }

    public Double getShuzhangbianyi() {
        return shuzhangbianyi;
    }

    public void setShuzhangbianyi(Double shuzhangbianyi) {
        this.shuzhangbianyi = shuzhangbianyi;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Acceptkkdata> getAcceptDataList() {
        return acceptDataList;
    }

    public void setAcceptDataList(List<Acceptkkdata> acceptDataList) {
        this.acceptDataList = acceptDataList;
    }

    public Date getLogStartTime() {
        return logStartTime;
    }

    public void setLogStartTime(Date logStartTime) {
        this.logStartTime = logStartTime;
    }

    public Date getLogEndTime() {
        return logEndTime;
    }

    public void setLogEndTime(Date logEndTime) {
        this.logEndTime = logEndTime;
    }

    public String getShicha() {
        return shicha;
    }

    public void setShicha(String shicha) {
        this.shicha = shicha;
    }

    public Integer getLogSize() {
        return logSize;
    }

    public void setLogSize(Integer logSize) {
        this.logSize = logSize;
    }

    public Integer getMaxSystolic() {
        return maxSystolic;
    }

    public void setMaxSystolic(Integer maxSystolic) {
        this.maxSystolic = maxSystolic;
    }

    public Integer getAvgMaiyacha() {
        return avgMaiyacha;
    }

    public void setAvgMaiyacha(Integer avgMaiyacha) {
        this.avgMaiyacha = avgMaiyacha;
    }

    public Integer getDayavgMaiyacha() {
        return dayavgMaiyacha;
    }

    public void setDayavgMaiyacha(Integer dayavgMaiyacha) {
        this.dayavgMaiyacha = dayavgMaiyacha;
    }

    public Integer getNightavgMaiyacha() {
        return nightavgMaiyacha;
    }

    public void setNightavgMaiyacha(Integer nightavgMaiyacha) {
        this.nightavgMaiyacha = nightavgMaiyacha;
    }

    public Integer getMinSystolic() {
        return minSystolic;
    }

    public void setMinSystolic(Integer minSystolic) {
        this.minSystolic = minSystolic;
    }

    public Date getMaxSystolicTime() {
        return maxSystolicTime;
    }

    public void setMaxSystolicTime(Date maxSystolicTime) {
        this.maxSystolicTime = maxSystolicTime;
    }

    public Date getMinSystolicTime() {
        return minSystolicTime;
    }

    public void setMinSystolicTime(Date minSystolicTime) {
        this.minSystolicTime = minSystolicTime;
    }

    public Integer getAvgSystolic() {
        return avgSystolic;
    }

    public void setAvgSystolic(Integer avgSystolic) {
        this.avgSystolic = avgSystolic;
    }

    public Integer getMaxDiastolic() {
        return maxDiastolic;
    }

    public void setMaxDiastolic(Integer maxDiastolic) {
        this.maxDiastolic = maxDiastolic;
    }

    public Integer getMinDiastolic() {
        return minDiastolic;
    }

    public void setMinDiastolic(Integer minDiastolic) {
        this.minDiastolic = minDiastolic;
    }

    public Date getMaxDiastolicTime() {
        return maxDiastolicTime;
    }

    public void setMaxDiastolicTime(Date maxDiastolicTime) {
        this.maxDiastolicTime = maxDiastolicTime;
    }

    public Date getMinDiastolicTime() {
        return minDiastolicTime;
    }

    public Double getNightshousuobianyi() {
        return nightshousuobianyi;
    }

    public void setNightshousuobianyi(Double nightshousuobianyi) {
        this.nightshousuobianyi = nightshousuobianyi;
    }

    public Double getNightshuzhangbianyi() {
        return nightshuzhangbianyi;
    }

    public void setNightshuzhangbianyi(Double nightshuzhangbianyi) {
        this.nightshuzhangbianyi = nightshuzhangbianyi;
    }

    public void setMinDiastolicTime(Date minDiastolicTime) {
        this.minDiastolicTime = minDiastolicTime;
    }

    public Double getDayshousuobianyi() {
        return dayshousuobianyi;
    }

    public void setDayshousuobianyi(Double dayshousuobianyi) {
        this.dayshousuobianyi = dayshousuobianyi;
    }

    public Double getDayshuzhangbianyi() {
        return dayshuzhangbianyi;
    }

    public void setDayshuzhangbianyi(Double dayshuzhangbianyi) {
        this.dayshuzhangbianyi = dayshuzhangbianyi;
    }

    public Integer getAvgDiastolic() {
        return avgDiastolic;
    }

    public void setAvgDiastolic(Integer avgDiastolic) {
        this.avgDiastolic = avgDiastolic;
    }

    public Integer getMaxHrrest() {
        return maxHrrest;
    }

    public void setMaxHrrest(Integer maxHrrest) {
        this.maxHrrest = maxHrrest;
    }

    public Integer getMinHrrest() {
        return minHrrest;
    }

    public void setMinHrrest(Integer minHrrest) {
        this.minHrrest = minHrrest;
    }

    public Integer getAvgHrrest() {
        return avgHrrest;
    }

    public void setAvgHrrest(Integer avgHrrest) {
        this.avgHrrest = avgHrrest;
    }

    public Integer getDaymaxSystolic() {
        return daymaxSystolic;
    }

    public void setDaymaxSystolic(Integer daymaxSystolic) {
        this.daymaxSystolic = daymaxSystolic;
    }

    public Integer getDayminSystolic() {
        return dayminSystolic;
    }

    public void setDayminSystolic(Integer dayminSystolic) {
        this.dayminSystolic = dayminSystolic;
    }

    public Date getDaymaxSystolicTime() {
        return daymaxSystolicTime;
    }

    public void setDaymaxSystolicTime(Date daymaxSystolicTime) {
        this.daymaxSystolicTime = daymaxSystolicTime;
    }

    public Date getDayminSystolicTime() {
        return dayminSystolicTime;
    }

    public void setDayminSystolicTime(Date dayminSystolicTime) {
        this.dayminSystolicTime = dayminSystolicTime;
    }

    public Integer getDayavgSystolic() {
        return dayavgSystolic;
    }

    public void setDayavgSystolic(Integer dayavgSystolic) {
        this.dayavgSystolic = dayavgSystolic;
    }

    public Integer getDaymaxDiastolic() {
        return daymaxDiastolic;
    }

    public void setDaymaxDiastolic(Integer daymaxDiastolic) {
        this.daymaxDiastolic = daymaxDiastolic;
    }

    public Integer getDayminDiastolic() {
        return dayminDiastolic;
    }

    public void setDayminDiastolic(Integer dayminDiastolic) {
        this.dayminDiastolic = dayminDiastolic;
    }

    public Date getDaymaxDiastolicTime() {
        return daymaxDiastolicTime;
    }

    public void setDaymaxDiastolicTime(Date daymaxDiastolicTime) {
        this.daymaxDiastolicTime = daymaxDiastolicTime;
    }

    public Date getDayminDiastolicTime() {
        return dayminDiastolicTime;
    }

    public void setDayminDiastolicTime(Date dayminDiastolicTime) {
        this.dayminDiastolicTime = dayminDiastolicTime;
    }

    public Integer getDayavgDiastolic() {
        return dayavgDiastolic;
    }

    public void setDayavgDiastolic(Integer dayavgDiastolic) {
        this.dayavgDiastolic = dayavgDiastolic;
    }

    public Integer getDaymaxHrrest() {
        return daymaxHrrest;
    }

    public void setDaymaxHrrest(Integer daymaxHrrest) {
        this.daymaxHrrest = daymaxHrrest;
    }

    public Integer getDayminHrrest() {
        return dayminHrrest;
    }

    public void setDayminHrrest(Integer dayminHrrest) {
        this.dayminHrrest = dayminHrrest;
    }

    public Integer getDayavgHrrest() {
        return dayavgHrrest;
    }

    public void setDayavgHrrest(Integer dayavgHrrest) {
        this.dayavgHrrest = dayavgHrrest;
    }

    public Integer getNightmaxSystolic() {
        return nightmaxSystolic;
    }

    public void setNightmaxSystolic(Integer nightmaxSystolic) {
        this.nightmaxSystolic = nightmaxSystolic;
    }

    public Integer getNightminSystolic() {
        return nightminSystolic;
    }

    public void setNightminSystolic(Integer nightminSystolic) {
        this.nightminSystolic = nightminSystolic;
    }

    public Date getNightmaxSystolicTime() {
        return nightmaxSystolicTime;
    }

    public void setNightmaxSystolicTime(Date nightmaxSystolicTime) {
        this.nightmaxSystolicTime = nightmaxSystolicTime;
    }

    public Date getNightminSystolicTime() {
        return nightminSystolicTime;
    }

    public void setNightminSystolicTime(Date nightminSystolicTime) {
        this.nightminSystolicTime = nightminSystolicTime;
    }

    public Integer getNightavgSystolic() {
        return nightavgSystolic;
    }

    public void setNightavgSystolic(Integer nightavgSystolic) {
        this.nightavgSystolic = nightavgSystolic;
    }

    public Integer getNightmaxDiastolic() {
        return nightmaxDiastolic;
    }

    public void setNightmaxDiastolic(Integer nightmaxDiastolic) {
        this.nightmaxDiastolic = nightmaxDiastolic;
    }

    public Integer getNightminDiastolic() {
        return nightminDiastolic;
    }

    public void setNightminDiastolic(Integer nightminDiastolic) {
        this.nightminDiastolic = nightminDiastolic;
    }

    public Date getNightmaxDiastolicTime() {
        return nightmaxDiastolicTime;
    }

    public void setNightmaxDiastolicTime(Date nightmaxDiastolicTime) {
        this.nightmaxDiastolicTime = nightmaxDiastolicTime;
    }

    public Date getNightminDiastolicTime() {
        return nightminDiastolicTime;
    }

    public void setNightminDiastolicTime(Date nightminDiastolicTime) {
        this.nightminDiastolicTime = nightminDiastolicTime;
    }

    public Integer getNightavgDiastolic() {
        return nightavgDiastolic;
    }

    public void setNightavgDiastolic(Integer nightavgDiastolic) {
        this.nightavgDiastolic = nightavgDiastolic;
    }

    public Integer getNightmaxHrrest() {
        return nightmaxHrrest;
    }

    public void setNightmaxHrrest(Integer nightmaxHrrest) {
        this.nightmaxHrrest = nightmaxHrrest;
    }

    public Integer getNightminHrrest() {
        return nightminHrrest;
    }

    public void setNightminHrrest(Integer nightminHrrest) {
        this.nightminHrrest = nightminHrrest;
    }

    public Integer getNightavgHrrest() {
        return nightavgHrrest;
    }

    public void setNightavgHrrest(Integer nightavgHrrest) {
        this.nightavgHrrest = nightavgHrrest;
    }

    public Double getShousuofuhe() {
        return shousuofuhe;
    }

    public void setShousuofuhe(Double shousuofuhe) {
        this.shousuofuhe = shousuofuhe;
    }

    public Double getShuzhangfuhe() {
        return shuzhangfuhe;
    }

    public void setShuzhangfuhe(Double shuzhangfuhe) {
        this.shuzhangfuhe = shuzhangfuhe;
    }

    public Double getDayshousuofuhe() {
        return dayshousuofuhe;
    }

    public void setDayshousuofuhe(Double dayshousuofuhe) {
        this.dayshousuofuhe = dayshousuofuhe;
    }

    public Double getDayshuzhangfuhe() {
        return dayshuzhangfuhe;
    }

    public void setDayshuzhangfuhe(Double dayshuzhangfuhe) {
        this.dayshuzhangfuhe = dayshuzhangfuhe;
    }

    public Double getNightshousuofuhe() {
        return nightshousuofuhe;
    }

    public void setNightshousuofuhe(Double nightshousuofuhe) {
        this.nightshousuofuhe = nightshousuofuhe;
    }

    public Double getNightshuzhangfuhe() {
        return nightshuzhangfuhe;
    }

    public void setNightshuzhangfuhe(Double nightshuzhangfuhe) {
        this.nightshuzhangfuhe = nightshuzhangfuhe;
    }
}
