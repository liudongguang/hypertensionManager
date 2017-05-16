package com.kangkang.controller;

import com.github.pagehelper.PageInfo;
import com.kangkang.api.po.HytbDeviceRepertory;
import com.kangkang.api.service.DeviceService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/5/16.
 */
@Controller
@RequestMapping(value = "/deviceHandler")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    /**
     * 设备列表
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deviceList")
    public String deviceList(HttpServletRequest request, PageParam pageParam) throws Exception {
        PageInfo<HytbDeviceRepertory> page = deviceService.getDeviceListPageInfo(pageParam);
        request.setAttribute("page", page);
        return "/jsppage/device/devicelist.jsp";
    }

    /**
     * 进入添加设备页面
     * @param request
     * @param pageParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addDevice")
    public String addDevice(HttpServletRequest request, PageParam pageParam) throws Exception {
        return "/jsppage/device/addDevice.jsp";
    }

    /**
     * 检查sn或imei是否存在
     * @param request
     * @param device
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkSNAndImei")
    @ResponseBody
    public ResultMsg checkSNAndImei(HttpServletRequest request, HytbDeviceRepertory device) throws Exception {
        ResultMsg rs = new ResultMsg();
        String errorInfo = deviceService.checkSNAndImei(device);
        if (errorInfo != null) {
            rs.setErrcode(1);
            rs.setErrmsg(errorInfo);
        }
        return rs;
    }

    /**
     * 保存设备
     * @param request
     * @param device
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveDevice")
    public String saveDevice(HttpServletRequest request, HytbDeviceRepertory device) throws Exception {
        int saveNum=deviceService.saveDevice(device);
        return "/deviceHandler/deviceList";
    }

    @RequestMapping(value = "/delDeviceById")
    public String delDeviceById(HttpServletRequest request, HytbDeviceRepertory device) throws Exception {
        int saveNum=deviceService.delDeviceByUid(device);
        return "/deviceHandler/deviceList";
    }


}
