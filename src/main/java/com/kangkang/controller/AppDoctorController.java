package com.kangkang.controller;

import com.kangkang.api.po.DoctorUsers;
import com.kangkang.api.service.AppDoctorService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.vo.AppDoctorParamVo;
import com.kangkang.api.vo.DoctorUsersExt;
import com.kangkang.constant.SysConstant;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMsg login(HttpServletRequest request, AppDoctorParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        Integer userid=appDoctorService.getUserByUserName(param.getUsername());
        if(userid==null){
            rs.setErrcode(1);
            rs.setErrmsg("用户未注册！");
            return rs;
        }
        DoctorUsersExt user=appDoctorService.login(param);
        if(user!=null){
            StringBuilder redisUID=new StringBuilder();
            String uid=user.getUid().toString();
            redisUID.append(uid).append(SysConstant.SYS_DOCTOR_STATE);
            String appToken=redisService.get(redisUID.toString());
            if(appToken==null){
                appToken=UUID.randomUUID().toString();
                redisService.add(redisUID.toString(), appToken, 60*24*30);
            }
            user.setApptoken(appToken);
            rs.setData(user);
        }else{
            rs.setErrcode(1);
            rs.setErrmsg("用户名或密码错误！");
        }
        return rs;
    }

    /**
     * 个人中心
     *
     * 个人信息
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public ResultMsg userInfo(HttpServletRequest request, Integer uid) throws Exception {
        ResultMsg rs = new ResultMsg();
        DoctorUsers doctor=appDoctorService.getUserInfoByUid(uid);
        rs.setData(doctor);
        return rs;
    }


    /**
     * 个人中心
     *
     * 修改个人信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUserInfo")
    @ResponseBody
    public ResultMsg updateUserInfo(HttpServletRequest request, DoctorUsers doctor) throws Exception {
        ResultMsg rs = new ResultMsg();
        int updateNum=appDoctorService.updateUserInfoByUid(request,doctor);
        return rs;
    }

}
