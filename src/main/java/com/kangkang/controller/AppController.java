package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.Acceptkkdata;
import com.kangkang.api.service.KangKangDataService;
import com.kangkang.api.service.RedisService;
import com.kangkang.api.util.PeonyMessageUtil;
import com.kangkang.api.vo.GetVerificationCodeParam;
import com.kangkang.api.vo.RongYunJsonRsInfo;
import com.kangkang.api.vo.SetPwdVo;
import com.kangkang.constant.SysConstant;
import com.ldg.api.util.LdgRequestUtils;
import com.ldg.api.vo.MsgResult;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
     * 获取血压数据
     *
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hypertensionListByUser")
    public String hypertensionListByUser(HttpServletRequest request, PageParam pageParam) throws Exception {
        PageInfo<Acceptkkdata> page = kkService.hypertensionListByUser(pageParam);
        request.setAttribute("page", page);
        return "/hypertensionMain/dishypertensionList.jsp";
    }



    @RequestMapping(value = "/getVerificationCode")
    @ResponseBody
    public ResultMsg getVerificationCode(HttpServletRequest request,GetVerificationCodeParam param) throws Exception {
        ResultMsg rs = new ResultMsg();
        //1.判断是否注册
        Integer userid=kkService.getUserByPhoneNumber(param);
        if(null==userid){
            rs.setErrcode(SysConstant.ResultMsg_FAIL_CODE);
            rs.setErrmsg("该手机号已注册！");
            return rs;
        }
        //2.未注册发送短信验证码
        StringBuilder sendmsg=new StringBuilder("验证码为：");
        sendmsg.append(param.getVerificationCode());
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
    public ResultMsg setPwd(HttpServletRequest request,SetPwdVo param) throws Exception {
        ResultMsg rs = new ResultMsg();
        RongYunJsonRsInfo ryRsObj=kkService.registerUser(param);
        if(200==ryRsObj.getCode()){

        }else{
            rs.setErrcode(1);
            rs.setErrmsg("注册融云消息服务失败！");
        }
        return rs;
    }

    @RequestMapping(value = "/testRedis")
    @ResponseBody
    public ResultMsg testRedis(HttpServletRequest request) {
        ResultMsg msg = new ResultMsg();
        redisService.add("1", msg, 3);
        ResultMsg msg2 =redisService.get("1");
        System.out.println(msg2);
        redisService.del("1");
        msg2 =redisService.get("1");
        System.out.println(msg2);
        return msg;
    }

}
