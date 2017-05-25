package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.AppDoctorService;
import com.kangkang.api.service.AppPatientService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.vo.*;
import com.kangkang.constant.SysConstant;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by LiuDongguang on 2017/5/15.
 */
@Controller
@RequestMapping(value = "/appDoctorHandler")
public class AppDoctorController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private AppDoctorService appDoctorService;
    @Autowired
    private AppPatientService appPatientService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMsg login(HttpServletRequest request, AppDoctorParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        Integer userid = appDoctorService.getUserByUserName(param.getUsername());
        if (userid == null) {
            rs.setErrcode(1);
            rs.setErrmsg("用户未注册！");
            return rs;
        }
        DoctorUsersExt user = appDoctorService.login(param);
        if (user != null) {
            StringBuilder redisUID = new StringBuilder();
            String uid = user.getUid().toString();
            redisUID.append(uid).append(SysConstant.SYS_DOCTOR_STATE);
            String appToken = redisService.get(redisUID.toString());
            if (appToken == null) {
                appToken = UUID.randomUUID().toString();
                redisService.add(redisUID.toString(), appToken, 60 * 24 * 30);
            }
            user.setApptoken(appToken);
            rs.setData(user);
        } else {
            rs.setErrcode(1);
            rs.setErrmsg("用户名或密码错误！");
        }
        return rs;
    }
    /**
     * 退出登陆
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginout")
    @ResponseBody
    public ResultMsg loginout(HttpServletRequest request,AppParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        StringBuilder redisUID = new StringBuilder();
        redisUID.append(param.getUid()).append(SysConstant.SYS_DOCTOR_STATE);
        redisService.del(redisUID.toString());
        return rs;
    }
    /**
     * 个人中心
     * <p>
     * 个人信息
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public ResultMsg userInfo(HttpServletRequest request, Integer uid) throws Exception {
        ResultMsg rs = new ResultMsg();
        DoctorUsers doctor = appDoctorService.getUserInfoByUid(uid);
        rs.setData(doctor);
        return rs;
    }


    /**
     * 个人中心
     * <p>
     * 修改个人信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUserInfo")
    @ResponseBody
    public ResultMsg updateUserInfo(HttpServletRequest request, DoctorUsers doctor) throws Exception {
        ResultMsg rs = new ResultMsg();
        int updateNum = appDoctorService.updateUserInfoByUid(request, doctor);
        if (updateNum == 0) {
            rs.setErrcode(1);
            rs.setErrmsg("修改失败！");
        }
        return rs;
    }

    /**
     * 医生端调用
     * 根据荣云id获取头像跟姓名
     *
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getPatientHeadImgAndNameByRongYunID")
    @ResponseBody
    public ResultMsg getPatientHeadImgAndNameByRongYunID(HttpServletRequest request, String userId) throws Exception {
        ResultMsg rs = new ResultMsg();
        TUsers user = appPatientService.getPatientUserByrongyunid(userId);
        rs.setData(user);
        return rs;
    }


    @RequestMapping(value = "/patientListOLD")
    @ResponseBody
    public ResultMsg patientListOLD(HttpServletRequest request, PageParam pageParam) throws Exception {
        ResultMsg rs = new ResultMsg();
        PageInfo<TUsers> pageinfo = appPatientService.patientList(pageParam);
        rs.setData(pageinfo);
        /////
        return rs;
    }

    /**
     * 获取交流过的患者列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientList")
    @ResponseBody
    public ResultMsg patientList(HttpServletRequest request,Integer uid) throws Exception {
        ResultMsg rs = new ResultMsg();
        PageInfo<PatientListRsVo> rsList = appDoctorService.patientList(uid);
        Map<String,List<PatientListRsVo>> map=rsList.getList ().stream().collect(Collectors.groupingBy(PatientListRsVo::getFirstLetter));
        List<PinyinListDisplay> list=new ArrayList<>();
        map.forEach((key,val)->{
            PinyinListDisplay addobj=new PinyinListDisplay();
            addobj.setInitial(key);
            addobj.setList(val);
            list.add(addobj);
         });
        rs.setData(list);
        /////
        return rs;
    }

    /**
     * 获取患者详情
     * @param request
     * @param patientuid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/patientDetails")
    @ResponseBody
    public ResultMsg patientDetails(HttpServletRequest request,Integer patientuid) throws Exception {
        ResultMsg rs = new ResultMsg();
        TUsers user = appPatientService.getPatientUserById(patientuid);
        rs.setData(user);
        /////
        return rs;
    }
}
