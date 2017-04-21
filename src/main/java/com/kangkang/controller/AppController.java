package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.po.TUsers;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.util.PeonyMessageUtil;
import com.kangkang.api.vo.AppParamVo;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.TUsersExt;
import com.kangkang.constant.SysConstant;
import com.ldg.api.vo.MsgResult;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by liudo on 2017/3/30.
 */
@Controller
@RequestMapping(value = "/appHandler")
public class AppController {
    @Autowired
    private KangKangDataService kkService;
    @Autowired
    private RedisService redisService;
    /**
     * 注册获取验证码
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getVerificationCode")
    @ResponseBody
    public ResultMsg getVerificationCode(HttpServletRequest request,GetVerificationCodeParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        //1.判断是否注册
        Integer userid=kkService.getUserByPhoneNumber(param.getMobile());
        if(null!=userid){
            rs.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            rs.setErrmsg("该手机号已注册！");
            return rs;
        }
        //2.未注册发送短信验证码
        StringBuilder sendmsg=new StringBuilder("验证码为：");
        sendmsg.append(param.getVerificationcode());
        MsgResult msgrs=PeonyMessageUtil.sendMessage(param.getMobile(),sendmsg.toString());
        if(SysConstant.PEONYMSG_SUCCESS_CODE!=msgrs.getCode()){
            rs.setErrcode(msgrs.getCode());
            rs.setErrmsg(msgrs.getMessage());
            if(SysConstant.ResultMsg_FAIL_PHONEERR==msgrs.getCode()){
                rs.setErrmsg("手机号错误！");
            }
        }
        return rs;
    }

    /**
     * 注册
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/setPwd")
    @ResponseBody
    public ResultMsg setPwd(HttpServletRequest request,AppParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        TUsers user=kkService.registerUser(param);
        if(user.getRytoken()!=null){
            rs.setData(user);
        }else{
            rs.setErrcode(1);
            rs.setErrmsg("注册融云消息服务失败！");
        }
        return rs;
    }


    /**
     * 登陆
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMsg login(HttpServletRequest request,AppParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        Integer userid=kkService.getUserByPhoneNumber(param.getMobile());
        if(userid==null){
            rs.setErrcode(1);
            rs.setErrmsg("用户未注册！");
            return rs;
        }
        TUsersExt user=kkService.login(param);
        if(user!=null){
            String uid=user.getUid().toString();
            String appToken=redisService.get(uid);
            if(appToken==null){
                appToken=UUID.randomUUID().toString();
                redisService.add(uid, appToken, 60*24*30);
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
        redisService.del(param.getUid().toString());
        return rs;
    }
    /**
     * 忘记密码的发送验证码
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forgetPwd")
    @ResponseBody
    public ResultMsg forgetPwd(HttpServletRequest request,GetVerificationCodeParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        //2.未注册发送短信验证码
        StringBuilder sendmsg=new StringBuilder("验证码为：");
        sendmsg.append(param.getVerificationcode());
        MsgResult msgrs=PeonyMessageUtil.sendMessage(param.getMobile(),sendmsg.toString());
        if(SysConstant.PEONYMSG_SUCCESS_CODE!=msgrs.getCode()){
            rs.setErrmsg(msgrs.getMessage());
            rs.setErrcode(msgrs.getCode());
            if(SysConstant.ResultMsg_FAIL_PHONEERR==msgrs.getCode()){
                rs.setErrmsg("手机号错误！");
            }
        }
        return rs;
    }
    /**
     * 忘记密码
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/resetPwd")
    @ResponseBody
    public ResultMsg resetPwd(HttpServletRequest request,AppParamVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        int updateNum=kkService.resetPwd(param);
        if(updateNum==0){
            rs.setErrcode(1);
            rs.setErrmsg("设置密码失败！");
        }
        return rs;
    }

    /**
     * 绑定设备
     * @param request
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/relevanceDevice")
    @ResponseBody
    public ResultMsg relevanceDevice(HttpServletRequest request,TUsers user) throws Exception {
        ResultMsg rs = new ResultMsg();
        TUsers bindUser=kkService.isBindedBySN(user);
        if(bindUser!=null){
            rs.setErrcode(1);
            rs.setErrmsg("设备已经被绑定，绑定失败！");
            return rs;
        }
        int updateNum=kkService.relevanceDevice(user);
        if(updateNum==0){
            rs.setErrcode(1);
            rs.setErrmsg("绑定失败！");
        }
        return rs;
    }
    /**
     * 绑定设备
     * @param request
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unrelevanceDevice")
    @ResponseBody
    public ResultMsg unrelevanceDevice(HttpServletRequest request,TUsers user) throws Exception {
        ResultMsg rs = new ResultMsg();
        int updateNum=kkService.unBindedDevice(user);
        if(updateNum==0){
            rs.setErrcode(1);
            rs.setErrmsg("解绑失败！");
        }
        return rs;
    }

    /**
     * 判断是否关联设备
     * @param request
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/judgeRelevanceDevice")
    @ResponseBody
    public ResultMsg judgeRelevanceDevice(HttpServletRequest request,TUsers user) throws Exception {
        ResultMsg rs = new ResultMsg();
        TUsers bindUser=kkService.isBindedByUid(user);
        if(bindUser==null){
            rs.setErrcode(1);
            rs.setErrmsg("未关联设备！");
        }else{
            rs.setData(bindUser);
        }
        return rs;
    }



    @RequestMapping(value = "/testRedis")
    @ResponseBody
    public ResultMsg testRedis(HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();
        msg.setData("22222");
        redisService.add("1", msg, 3);
        ResultMsg msg2 =redisService.get("1");
        System.out.println(msg2);
        redisService.del("1");
        msg2 =redisService.get("1");
        System.out.println(msg2);


        return msg;
    }

}
