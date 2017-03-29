package com.sdey.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;
import com.sdey.api.po.Followuplog;
import com.sdey.api.po.Importlog;
import com.sdey.api.po.Manager;
import com.sdey.api.po.Patients;
import com.sdey.api.vo.DisSearch;
import com.sdey.api.vo.UpdatePassParam;
import com.sdey.api.vo.ext.DisPatients;
import com.sdey.api.vo.ext.GroupImportlogForFenPei;
import com.sdey.api.vo.ext.ManagerWork;
import com.sdey.api.vo.ext.fenpeiWorkParam;
import com.sdey.api.vo.hisoutpatient.InterfaceInfo;

import java.util.List;

/**
 * Created by liudo on 2017/3/15 0015.
 */
public interface SdeyFollowUpService {
     void addInfo();

     PageInfo<Manager> getPageInfo(PageParam pageParam);

     /**
      * 根据日期获取his出院病人数据
      * @param date
      * @return
      */
     InterfaceInfo getOneMonthHisChuYuanPatient(String date);

     /**
      * 处理出院病人数据到本地库
      * @param date
      * @return
      */
     String handlerOneMonthHisChuYuanPatient (String date);

     /**
      * 根据条件查询患者
      * @param pageParam
      * @param search
      * @return
      */
     PageInfo<DisPatients> getOutHosMembers(PageParam pageParam, DisSearch search);

     /**
      * 获取单个患者信息
      * @param uid
      * @return
      */
    Patients getPationtById(Integer uid);

     /**
      * 登陆
      * @param loginUser
      * @return
      */
    Manager login(Manager loginUser);

    /**
     * 保存随访记录
     * @param savelog
     * @return
     */
    int saveSuiFangLog(Followuplog savelog,Integer workid);

    /**
     * 获取次病人所有随访记录
     * @param uid
     * @param pageParam
     * @return
     */
    PageInfo<Followuplog> getpationtSFLogs(Integer uid, PageParam pageParam);

    /**
     * 获取管理员列表
     * @param pageParam
     * @return
     */
    PageInfo<Manager> getManagerList(PageParam pageParam);

    /**
     * 保存管理员
     * @return
     */
    int saveManager(Manager manager);

    int delManager(Integer uid);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    Integer checkManagerUserName(String username);

    /**
     * 获取可分配导入信息
     * @return
     */
    List<GroupImportlogForFenPei> getKeFenPeiList();

    /**
     * 根据人数分配工作量
     * @param param
     */
    void fenpeiWork(fenpeiWorkParam param);
    /**
     * 根据人数分配工作量,根据科室平均分
     * @param param
     */
    int fenpeiWorkPlus(fenpeiWorkParam param);
    /**
     * 获取分配的数据
     * @return
     */
    List<ManagerWork> getManagerWork();
    /**
     * 修改工作记录
     */
    int finishiwork(Integer workid);

    /**
     * 获取科室列表
     * @return
     */
    List<String> getListKsName();

    /**
     * 按照旧密码修改新密码
     * @param param
     * @return
     */
    String updatePass(UpdatePassParam param);

    /**
     * 获取当年已导入日期
     * @param pageParam
     * @return
     */
    PageInfo<Importlog> getImportlogPageInfo(PageParam pageParam, String thisYear);
}
