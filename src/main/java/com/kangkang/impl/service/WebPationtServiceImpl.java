package com.kangkang.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.HytbDeviceLandlog;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.RongYunServie;
import com.kangkang.api.service.WebPationtService;
import com.kangkang.api.util.HighChartUtils;
import com.kangkang.api.util.PeonySystemTool;
import com.kangkang.api.util.ReportCalculate;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SavePatientParam;
import com.kangkang.api.vo.highchat.*;
import com.kangkang.api.vo.report.ReportParam;
import com.kangkang.api.vo.report.ReportRs;
import com.kangkang.constant.SysConstant;
import com.kangkang.impl.mapper.AcceptkkdataMapper;
import com.kangkang.impl.mapper.HytbDeviceLandlogMapper;
import com.kangkang.impl.mapper.HytbDeviceRepertoryMapper;
import com.kangkang.impl.mapper.TUsersMapper;
import com.ldg.api.util.DateUtil;
import com.ldg.api.util.LdgNumberFormat;
import com.ldg.api.util.MD5Util;
import com.ldg.api.vo.PageParam;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Service
public class WebPationtServiceImpl implements WebPationtService {

    @Autowired
    private TUsersMapper usersMapper;
    @Autowired
    private RongYunServie rongYunServie;
    @Autowired
    private HytbDeviceLandlogMapper deviceLandlogDao;
    @Autowired
    private HytbDeviceRepertoryMapper deviceRepertoryMapper;
    @Autowired
    private AcceptkkdataMapper acceptkkdataMapper;

    @Override
    public PageInfo<TUsers> getPatientListPageInfo(PageParam pageParam,TUsers user) {
        PageInfo<TUsers> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> usersMapper.selectAllForPatientListList(user));
        return pageInfo;
    }

    @Override
    public String checkValidate(SavePatientParam checkParam) {
        Integer uid = usersMapper.selectUidByPhone(checkParam);
        if (uid != null) {
            return "手机号已存在！";
        }
        return null;
    }

    private int bindDevice(TUsers user, SavePatientParam param) {
        HytbDeviceLandlog landlog = new HytbDeviceLandlog();//租借记录
        landlog.setBeizhu(param.getBeizhu());
        landlog.setCreatetime(new Date());
        landlog.setDeviceid(param.getShebeiUID());
        landlog.setDevicesn(param.getShebeiSN());
        landlog.setReturnstate(SysConstant.DEVICE_LAND_CHUJIE);//设置借出状态
        landlog.setPatientid(user.getUid());
        landlog.setZjstart(param.getZjstart());
        landlog.setZjend(param.getZjend());
        deviceLandlogDao.insertSelective(landlog);  //保存租借记录
        HytbDeviceRepertory repertory = new HytbDeviceRepertory();
        repertory.setUid(param.getShebeiUID());
        repertory.setLandlogid(landlog.getUid());
        return deviceRepertoryMapper.saveLandIDForBind(repertory);//把当前绑定记录关联到设备上
    }

    @Override
    public int savePatient(SavePatientParam param) throws AesException {
        if (param.getUid() != null) {
            TUsers user = new TUsers();
            user.setUid(param.getUid());
            user.setName(param.getName());
            user.setRegistphone(param.getRegistphone());
            user.setSex(param.getSex());
            //////////与当前设备不是同一个则自动取消绑定，绑定这个。否则不变
            //获取当前绑定设备记录
            HytbDeviceLandlog currentlandlog = deviceLandlogDao.getCurrentBindLog(user.getUid());
            if (currentlandlog != null) {
                if (!currentlandlog.getDeviceid().equals(param.getShebeiUID())) {
                    //解除，绑定
                    currentlandlog.setReturnstate(SysConstant.DEVICE_LAND_REPLACE);//替换状态
                    int unbindNum = deviceLandlogDao.updateBindDeviceState(currentlandlog);
                    bindDevice(user, param);
                    user.setSn(param.getShebeiSN());
                }
            } else {
                //直接绑定
                if (param.getShebeiSN() != null) {//有sn编码的时候
                    user.setSn(param.getShebeiSN());
                    bindDevice(user, param);
                }
            }
            usersMapper.updateByPrimaryKeySelective(user);
        } else {
            String phone = param.getRegistphone();
            final RongYunJsonRsInfo ryrsObj = rongYunServie.ryRegist(phone, phone);
            TUsers user = new TUsers();
            if (200 == ryrsObj.getCode()) {
                user.setUsername(phone);
                user.setName(param.getName());
                user.setRegistphone(ryrsObj.getUserId());
                user.setCreatetime(new Date());
                user.setPassword(MD5Util.string2MD5(PeonySystemTool.getPassByPhone(phone)));
                user.setRytoken(ryrsObj.getToken());
                user.setRongid(phone);
                user.setSn(param.getShebeiSN());////用户绑定设备
                user.setSex(param.getSex());
                user.setBirthday(param.getBirthday());
                Integer age = DateUtil.getyearsCha(param.getBirthday(), new Date());
                user.setAge(age);
                usersMapper.insertSelective(user);//保存用户
                ///////设备绑定状态修改
                if (param.getShebeiUID() != null) {
                    bindDevice(user, param);
                }
            }
        }
        return 0;
    }

    @Override
    public SavePatientParam patientBindDeviceByUid(Integer patientid) {
        SavePatientParam user = usersMapper.selectPatientForBind(patientid);
        return user;
    }

    @Override
    public ReportRs getReport(ReportParam param) throws Exception {
        ////
        Predicate<Acceptkkdata> p135 = item -> {
            int Systolicpressure = item.getSystolicpressure();
            if (Systolicpressure >= 135) {
                return true;
            }
            return false;
        };
        Predicate<Acceptkkdata> p85 = item -> {
            int Systolicpressure = item.getSystolicpressure();
            if (Systolicpressure >= 85) {
                return true;
            }
            return false;
        };
        ////
        ReportRs rs = new ReportRs();
        param.setPatientuid(42);
        Date d = DateUtils.parseDate("20170602-07:22:30", "yyyyMMdd-hh:mm:ss");
        param.setReportDate(d);
        List<Acceptkkdata> dataList = acceptkkdataMapper.getRoportDataByPatientID(param);
        rs.setAcceptDataList(dataList);
        rs.setName(param.getName());
        rs.setSex(param.getSex());
        if (dataList != null && dataList.size() != 0) {
            Date start = dataList.get(0).getKktime();
            Date end = dataList.get(dataList.size() - 1).getKktime();
            rs.setLogStartTime(start);
            rs.setLogEndTime(end);
            rs.setShicha(DateUtil.getDatePoor(end, start));
            rs.setLogSize(dataList.size());
        }
        /***********************收缩压******************************/
        //最大收缩压
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max -> {
            rs.setMaxSystolic(max.getSystolicpressure());
            rs.setMaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min -> {
            rs.setMinSystolic(min.getSystolicpressure());
            rs.setMinSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double avgSystolic = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setAvgSystolic(LdgNumberFormat.formatDoubleToInt_floor(avgSystolic));
        //计算变异系数
        List<Integer> systolicpressureListData = dataList.stream().map(item -> item.getSystolicpressure()).collect(Collectors.toList());
        Double shousuobianyi = ReportCalculate.calculateBianYiXishu(systolicpressureListData, rs.getAvgSystolic());
        rs.setShousuobianyi(shousuobianyi);
        //血压负荷收缩压  大于135的次数除以总次数
        int Systolicpressure135 = dataList.stream().filter(p135).collect(Collectors.toList()).size();
        rs.setShousuofuhe(Systolicpressure135 * 1.0 / rs.getLogSize());
        /***********************舒张压******************************/
        //最大舒张压
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max -> {
            rs.setMaxDiastolic(max.getDiastolicpressure());
            rs.setMaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min -> {
            rs.setMinDiastolic(min.getDiastolicpressure());
            rs.setMinDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double avgDiastolic = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setAvgDiastolic(LdgNumberFormat.formatDoubleToInt_floor(avgDiastolic));
        //计算编译系数
        List<Integer> diastolicpressureListData = dataList.stream().map(item -> item.getDiastolicpressure()).collect(Collectors.toList());
        Double shuzhangbianyi = ReportCalculate.calculateBianYiXishu(diastolicpressureListData, rs.getAvgDiastolic());
        rs.setShuzhangbianyi(shuzhangbianyi);
        //血压负荷舒张压  大于85的次数除以总次数
        int Diastolicpressure85 = dataList.stream().filter(p85).collect(Collectors.toList()).size();
        rs.setShuzhangfuhe(Diastolicpressure85 * 1.0 / rs.getLogSize());
        /***********************心率******************************/
        //最大心率
        dataList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max -> {
            rs.setMaxHrrest(max.getPulse());
        });
        //最小心率
        dataList.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min -> {
            rs.setMinHrrest(min.getPulse());
        });
        //平均心率
        Double avgHrrest = dataList.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setAvgHrrest(LdgNumberFormat.formatDoubleToInt_floor(avgHrrest));
        //平均脉压差
        Double avgMaiyacha = dataList.stream().map(item -> item.getSystolicpressure() - item.getDiastolicpressure()).collect(Collectors.averagingInt(Integer::intValue));
        rs.setAvgMaiyacha(LdgNumberFormat.formatDoubleToInt_floor(avgMaiyacha));

        /**分日夜*/
        Date startdate = param.getStart();
        Date date22 = DateUtil.getDateHour22(startdate);//当天的晚上十点
        Date date6 = DateUtil.getDateHour6(startdate);//第二天的凌晨6点
        final Map<Boolean, List<Acceptkkdata>> riyeMap = dataList.stream().collect(Collectors.partitioningBy(item -> {
            //System.out.println(DateFormatUtils.format(item.getKktime(),"yyyy-MM-dd HH:mm:ss")+"    "+DateFormatUtils.format(date22,"yyyy-MM-dd HH:mm:ss"));
            if (item.getKktime().after(date22) && item.getKktime().before(date6)) {
                return false;
            }
            return true;
        }));
        List<Acceptkkdata> yelist = riyeMap.get(false);//晚上的统计 22点到早上6点
        List<Acceptkkdata> rilist = riyeMap.get(true);//早上六点到晚上22点
        /***日统计start**/
        /***********************日收缩 压******************************/
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max -> {
            rs.setDaymaxSystolic(max.getSystolicpressure());
            rs.setDaymaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min -> {
            rs.setDayminSystolic(min.getSystolicpressure());
            rs.setDayminSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double dayAvgSystolic = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setDayavgSystolic(LdgNumberFormat.formatDoubleToInt_floor(dayAvgSystolic));
        //计算编译系数
        List<Integer> daysystolicpressureListData = rilist.stream().map(item -> item.getSystolicpressure()).collect(Collectors.toList());
        Double dayshousuobianyi = ReportCalculate.calculateBianYiXishu(daysystolicpressureListData, rs.getDayavgSystolic());
        rs.setDayshousuobianyi(dayshousuobianyi);
        //血压负荷收缩压  大于135的次数除以总次数
        int daySystolicpressure135 = rilist.stream().filter(p135).collect(Collectors.toList()).size();
        rs.setDayshousuofuhe(daySystolicpressure135 * 1.0 / rs.getLogSize());
        /***********************日舒张压******************************/
        //最大舒张压
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max -> {
            rs.setDaymaxDiastolic(max.getDiastolicpressure());
            rs.setDaymaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min -> {
            rs.setDayminDiastolic(min.getDiastolicpressure());
            rs.setDayminDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double DayavgDiastolic = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setDayavgDiastolic(LdgNumberFormat.formatDoubleToInt_floor(DayavgDiastolic));
        //计算编译系数
        List<Integer> daydiastolicpressureListData = rilist.stream().map(item -> item.getDiastolicpressure()).collect(Collectors.toList());
        Double dayshuzhangbianyi = ReportCalculate.calculateBianYiXishu(daydiastolicpressureListData, rs.getDayavgDiastolic());
        rs.setDayshuzhangbianyi(dayshuzhangbianyi);
        //血压负荷舒张压  大于85的次数除以总次数
        int DayDiastolicpressure85 = rilist.stream().filter(p85).collect(Collectors.toList()).size();
        rs.setDayshuzhangfuhe(DayDiastolicpressure85 * 1.0 / rs.getLogSize());
        /***********************日心率******************************/
        //最大心率
        rilist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max -> {
            rs.setDaymaxHrrest(max.getPulse());
        });
        //最小心率
        rilist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min -> {
            rs.setDayminHrrest(min.getPulse());
        });
        //平均心率
        Double DayavgHrrest = rilist.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setDayavgHrrest(LdgNumberFormat.formatDoubleToInt_floor(DayavgHrrest));
        //平均脉压差
        Double dayavgMaiyacha = rilist.stream().map(item -> item.getSystolicpressure() - item.getDiastolicpressure()).collect(Collectors.averagingInt(Integer::intValue));
        rs.setDayavgMaiyacha(LdgNumberFormat.formatDoubleToInt_floor(dayavgMaiyacha));
        /***日统计end*/
        /***晚上统计start**/
        /***********************晚上收缩 压******************************/
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(max -> {
            rs.setNightmaxSystolic(max.getSystolicpressure());
            rs.setNightmaxSystolicTime(max.getKktime());
        });
        //最小收缩压
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getSystolicpressure))).ifPresent(min -> {
            rs.setNightminSystolic(min.getSystolicpressure());
            rs.setNightminSystolicTime(min.getKktime());
        });
        //平均收缩压
        Double nightAvgSystolic = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getSystolicpressure));
        rs.setNightavgSystolic(LdgNumberFormat.formatDoubleToInt_floor(nightAvgSystolic));
        //计算编译系数
        List<Integer> nigthsystolicpressureListData = yelist.stream().map(item -> item.getSystolicpressure()).collect(Collectors.toList());
        Double nigthshousuobianyi = ReportCalculate.calculateBianYiXishu(nigthsystolicpressureListData, rs.getNightavgSystolic());
        rs.setNightshousuobianyi(nigthshousuobianyi);
        //血压负荷收缩压  大于135的次数除以总次数
        int nigthSystolicpressure135 = yelist.stream().filter(p135).collect(Collectors.toList()).size();
        rs.setNightshousuofuhe(nigthSystolicpressure135 * 1.0 / rs.getLogSize());
        /***********************晚上舒张压******************************/
        //最大舒张压
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(max -> {
            rs.setNightmaxDiastolic(max.getDiastolicpressure());
            rs.setNightmaxDiastolicTime(max.getKktime());
        });
        //最小舒张压
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getDiastolicpressure))).ifPresent(min -> {
            rs.setNightminDiastolic(min.getDiastolicpressure());
            rs.setNightminDiastolicTime(min.getKktime());
        });
        //平均舒张压
        Double NightavgDiastolic = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getDiastolicpressure));
        rs.setNightavgDiastolic(LdgNumberFormat.formatDoubleToInt_floor(NightavgDiastolic));
        //计算编译系数
        List<Integer> nightdiastolicpressureListData = yelist.stream().map(item -> item.getDiastolicpressure()).collect(Collectors.toList());
        Double nightshuzhangbianyi = ReportCalculate.calculateBianYiXishu(nightdiastolicpressureListData, rs.getNightavgDiastolic());
        rs.setNightshuzhangbianyi(nightshuzhangbianyi);
        //血压负荷舒张压  大于85的次数除以总次数
        int NightDiastolicpressure85 = yelist.stream().filter(p85).collect(Collectors.toList()).size();
        rs.setNightshuzhangfuhe(NightDiastolicpressure85 * 1.0 / rs.getLogSize());
        /***********************晚上心率******************************/
        //最大心率
        yelist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(max -> {
            rs.setNightmaxHrrest(max.getPulse());
        });
        //最小心率
        yelist.stream().collect(Collectors.minBy(Comparator.comparingInt(Acceptkkdata::getPulse))).ifPresent(min -> {
            rs.setNightminHrrest(min.getPulse());
        });
        //平均心率
        Double NightavgHrrest = yelist.stream().collect(Collectors.averagingInt(Acceptkkdata::getPulse));
        rs.setNightavgHrrest(LdgNumberFormat.formatDoubleToInt_floor(NightavgHrrest));
        //平均脉压差
        Double nightavgMaiyacha = yelist.stream().map(item -> item.getSystolicpressure() - item.getDiastolicpressure()).collect(Collectors.averagingInt(Integer::intValue));
        rs.setNightavgMaiyacha(LdgNumberFormat.formatDoubleToInt_floor(nightavgMaiyacha));
        /***晚上统计end*/
        ///////夜间血压下降率
        double yeshousuoxjl = (dayAvgSystolic - nightAvgSystolic) / dayAvgSystolic;
        double yeshuzhangxjl = (DayavgDiastolic - NightavgDiastolic) / dayAvgSystolic;
        rs.setYeshousuoxjl(yeshousuoxjl);
        rs.setYeshuzhangxjl(yeshuzhangxjl);
        return rs;
    }

    @Override
    public HighchartsConfig_arr displayDay24Chat(ReportParam param) throws Exception {
        param.setPatientuid(42);
        Date d = DateUtils.parseDate("20170602-07:22:30", "yyyyMMdd-hh:mm:ss");
        param.setReportDate(d);
        List<Acceptkkdata> dataList = acceptkkdataMapper.getRoportDataByPatientID(param);
        if (dataList != null && dataList.size() != 0) {
            StringBuilder title = new StringBuilder();
            title.append(DateFormatUtils.format(param.getReportDate(), DateUtil.yyyy_MM_dd)).append(" 日血压图");
            HighchartsConfig_arr hcfg = HighChartUtils.createArrBasicChat(title.toString(), "血压/心率值");
            hcfg.getxAxis().setType("datetime");
            List<Series_Data> shousuoL = new ArrayList<>();
            List<Series_Data> shuzhangL = new ArrayList<>();
            List<Series_Data> xinlvL = new ArrayList<>();
            ////
            Date date22 = DateUtil.getDateHour22(d);//当天的晚上十点
            Date date6 = DateUtil.getDateHour6(d);//第二天的凌晨6点
            List<Series_Data> linjiess = new ArrayList<>();//收缩临界
            List<Series_Data> linjiesz = new ArrayList<>();//舒张临界
            dataList.forEach(item -> {
                long shuzhang = item.getDiastolicpressure();//舒张压
                long shousuo = item.getSystolicpressure();//收缩压
                long xinlv = item.getPulse();//心率
                Date measureTime = item.getKktime();//测量时间
                Series_Data shousuoArr = new Series_Data();
                shousuoArr.setX(measureTime.getTime());
                shousuoArr.setY(shousuo);
                Series_Data shuzhangArr = new Series_Data();
                shuzhangArr.setX(measureTime.getTime());
                shuzhangArr.setY(shuzhang);
                Series_Data xinlvArr = new Series_Data();
                xinlvArr.setX(measureTime.getTime());
                xinlvArr.setY(xinlv);
                shousuoL.add(shousuoArr);
                shuzhangL.add(shuzhangArr);
                xinlvL.add(xinlvArr);

            });
            ///临界start
            Date realStart=dataList.get(0).getKktime();
            Date realEnd=dataList.get(dataList.size()-1).getKktime();
            Series_Data linjiess_Data1 = new Series_Data();
            linjiess_Data1.setX(realStart.getTime());
            linjiess_Data1.setY(135l);
            Series_Data linjiess_Data2 = new Series_Data();
            linjiess_Data2.setX(date22.getTime());
            linjiess_Data2.setY(135l);
            Series_Data linjiess_Data3 = new Series_Data();
            linjiess_Data3.setX(date22.getTime());
            linjiess_Data3.setY(120l);
            Series_Data linjiess_Data4 = new Series_Data();
            linjiess_Data4.setX(date6.getTime());
            linjiess_Data4.setY(120l);
            Series_Data linjiess_Data5 = new Series_Data();
            linjiess_Data5.setX(date6.getTime());
            linjiess_Data5.setY(135l);
            Series_Data linjiess_Data6 = new Series_Data();
            linjiess_Data6.setX(realEnd.getTime());
            linjiess_Data6.setY(135l);
            linjiess.add(linjiess_Data1);
            linjiess.add(linjiess_Data2);
            linjiess.add(linjiess_Data3);
            linjiess.add(linjiess_Data4);
            linjiess.add(linjiess_Data5);
            linjiess.add(linjiess_Data6);
            //----
            Series_Data linjiesz_Data1 = new Series_Data();
            linjiesz_Data1.setX(realStart.getTime());
            linjiesz_Data1.setY(85l);
            Series_Data linjiesz_Data2 = new Series_Data();
            linjiesz_Data2.setX(date22.getTime());
            linjiesz_Data2.setY(85l);
            Series_Data linjiesz_Data3 = new Series_Data();
            linjiesz_Data3.setX(date22.getTime());
            linjiesz_Data3.setY(70l);
            Series_Data linjiesz_Data4 = new Series_Data();
            linjiesz_Data4.setX(date6.getTime());
            linjiesz_Data4.setY(70l);
            Series_Data linjiesz_Data5 = new Series_Data();
            linjiesz_Data5.setX(date6.getTime());
            linjiesz_Data5.setY(85l);
            Series_Data linjiesz_Data6 = new Series_Data();
            linjiesz_Data6.setX(realEnd.getTime());
            linjiesz_Data6.setY(85l);
            linjiesz.add(linjiesz_Data1);
            linjiesz.add(linjiesz_Data2);
            linjiesz.add(linjiesz_Data3);
            linjiesz.add(linjiesz_Data4);
            linjiesz.add(linjiesz_Data5);
            linjiesz.add(linjiesz_Data6);
            /////临界end
            //区域块
            PlotBands plotbands = new PlotBands();
            plotbands.setFrom(date22.getTime());
            plotbands.setTo(date6.getTime());
            hcfg.getxAxis().setPlotBands(Arrays.asList(plotbands));
            ////
            Series_arr shousuoSeries = new Series_arr();
            shousuoSeries.setName("收缩压");
            shousuoSeries.setType("spline");
            shousuoSeries.setData(shousuoL);
            shousuoSeries.setColor("red");

            Series_arr shuzhangSeries = new Series_arr();
            shuzhangSeries.setName("舒张压");
            shuzhangSeries.setType("spline");
            shuzhangSeries.setData(shuzhangL);
            shuzhangSeries.setColor("blue");

            Series_arr xinlvSeries = new Series_arr();
            xinlvSeries.setName("心率");
            xinlvSeries.setType("column");
            xinlvSeries.setData(xinlvL);
            List<Series_arr> series = hcfg.getSeries();
            series.add(xinlvSeries);//先添加的在下面
            series.add(shousuoSeries);
            series.add(shuzhangSeries);
            /////图标
            Series_Data xinlvArr = new Series_Data();
            xinlvArr.setX(DateUtil.getDateHour2(d).getTime());
            xinlvArr.setY(180l);
            Series_marker mark = new Series_marker();
            mark.setSymbol("assets/images/night.png");
            xinlvArr.setMarker(mark);
            Series_arr nightMark = new Series_arr();
            nightMark.setData(Arrays.asList(xinlvArr));
            series.add(nightMark);
            /////
            //////
            Series_marker noMark=new Series_marker();
            noMark.setEnabled(false);
            Series_arr linjiessSeries = new Series_arr();
            linjiessSeries.setName("收缩压临界值");
            linjiessSeries.setType("spline");
            linjiessSeries.setData(linjiess);
            linjiessSeries.setColor("red");
            linjiessSeries.setLineWidth(2);
            linjiessSeries.setMarker(noMark);
            linjiessSeries.setDashStyle("ShortDash");
            series.add(linjiessSeries);
            Series_arr linjieszSeries = new Series_arr();
            linjieszSeries.setName("舒张压临界值");
            linjieszSeries.setType("spline");
            linjieszSeries.setData(linjiesz);
            linjieszSeries.setColor("red");
            linjieszSeries.setLineWidth(2);
            linjieszSeries.setMarker(noMark);
            linjieszSeries.setDashStyle("ShortDash");
            series.add(linjieszSeries);
            return hcfg;
        } else {
            return HighchartsConfig_arr.getNullcig();
        }
    }
}
