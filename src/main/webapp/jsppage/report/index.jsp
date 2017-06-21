<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>动态心电</title>
    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css">
    <link rel="stylesheet" href="assets/css/jsppage/report/style.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<div class="row">
    <div class="col-md-12">
        <div class="commen_tt"><span class="commen_topt">个人信息</span>

            <table class="table table-striped table-hover table-bordered">
                <tbody>
                <tr>
                    <td class="td_bg">姓名</td>
                    <td class="td_cont">${obj.name}</td>
                    <td class="td_bg">性别</td>
                    <td class="td_cont">${obj.sex}</td>
                    <td class="td_bg">体重(kg)</td>
                    <td class="td_cont"></td>
                </tr>
                </tbody>
            </table>

        </div>
        <!-- 个人信息ending -->
        <div class="commen_tt"><span class="commen_topt">基础信息</span>

            <table class="table table-striped table-hover table-bordered">
                <tbody>
                <tr>
                    <td class="td_bg">记录开始时间</td>
                    <td class="td_cont"><fmt:formatDate value="${obj.logStartTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td class="td_bg">记录结束时间</td>
                    <td class="td_cont"><fmt:formatDate value="${obj.logEndTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td class="td_bg">记录总时间</td>
                    <td class="td_cont">${obj.shicha}</td>
                    <td class="td_bg">成功的读数</td>
                    <td class="td_cont">${obj.logSize}</td>
                </tr>
                </tbody>
            </table>

        </div>
        <!-- 基础信息ending -->
        <div class="commen_tt"><span class="commen_topt">指标分析</span>

            <table class="table table-striped table-hover table-bordered">
                <tbody>
                <tr>
                    <td class="td_bg">收缩压(最高)</td>
                    <td class="td_cont">${obj.maxSystolic}(<fmt:formatDate value="${obj.maxSystolicTime}"
                                                                           pattern="HH:mm:ss"></fmt:formatDate>)
                    </td>
                    <td class="td_bg">收缩压(最低)</td>
                    <td class="td_cont">${obj.minSystolic}(<fmt:formatDate value="${obj.minSystolicTime}"
                                                                           pattern="HH:mm:ss"></fmt:formatDate>)
                    </td>
                    <td class="td_bg">收缩压(平均)</td>
                    <td class="td_cont">${obj.avgSystolic}</td>
                    <td class="td_bg">舒张压(最高)</td>
                    <td class="td_cont">${obj.maxDiastolic}(<fmt:formatDate value="${obj.maxDiastolicTime}"
                                                                            pattern="HH:mm:ss"></fmt:formatDate>)
                    </td>
                </tr>
                <tr>
                    <td class="td_bg">舒张压(最低)</td>
                    <td class="td_cont">${obj.minDiastolic}(<fmt:formatDate value="${obj.minDiastolicTime}"
                                                                            pattern="HH:mm:ss"></fmt:formatDate>)
                    </td>
                    <td class="td_bg">舒张压(平均)</td>
                    <td class="td_cont">${obj.avgDiastolic}</td>
                    <td class="td_bg">血压负荷<br>收缩压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.shousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                    <td class="td_bg">血压负荷<br>舒张压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.shuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                </tr>
                <tr>
                    <td class="td_bg">血压变异系数<br>收缩压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.shousuobianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                    <td class="td_bg">血压变异系数<br>舒张压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.shuzhangbianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                    <td class="td_bg">夜间血压下降率<br>收缩压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.yeshousuoxjl}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                    <td class="td_bg">夜间血压下降率<br>舒张压</td>
                    <td class="td_cont"><fmt:formatNumber value="${obj.yeshuzhangxjl}" type="PERCENT" pattern="0.00%"></fmt:formatNumber></td>
                </tr>
                <tr>
                    <td class="td_bg">心率平均值</td>
                    <td class="td_cont">${obj.avgHrrest}</td>
                    <td class="td_bg">血压晨峰比</td>
                    <td class="td_cont"></td>
                    <td class="td_bg">谷/峰值</td>
                    <td class="td_cont" colspan="3"></td>
                </tr>

                </tbody>
            </table>

        </div>
        <!-- 基础信息ending -->
        <div class="row n-p">
            <div class="col-md-4 n-p-l" style="padding-left: 0">
                <div class="commen_tt">
                    <span class="commen_topt">统计分析</span>
                    <table class="table table-striped table-bordered tb_comen">
                        <thead>
                        <th>名称</th>
                        <th>平均值</th>
                        <th>最大值</th>
                        <th>最小值</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>收缩压(mmHg)</td>
                            <td>${obj.avgSystolic}</td>
                            <td>${obj.maxSystolic}(<fmt:formatDate value="${obj.maxSystolicTime}"
                                                                   pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.minSystolic}(<fmt:formatDate value="${obj.minSystolicTime}"
                                                                   pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>舒张压(mmHg)</td>
                            <td>${obj.avgDiastolic}</td>
                            <td>${obj.maxDiastolic}(<fmt:formatDate value="${obj.maxDiastolicTime}"
                                                                    pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.minDiastolic}(<fmt:formatDate value="${obj.minDiastolicTime}"
                                                                    pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>心率(BPM)</td>
                            <td>${obj.avgHrrest}</td>
                            <td>${obj.maxHrrest}</td>
                            <td>${obj.minHrrest}</td>
                        </tr>
                        </tbody>
                    </table>
                    <p style="line-height: 20px">
                        收缩压变异系数：<fmt:formatNumber value="${obj.shousuobianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压变异系数：<fmt:formatNumber value="${obj.shuzhangbianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        平均脉压差：${obj.avgMaiyacha}<br>
                        血压负荷(收缩压)：<fmt:formatNumber value="${obj.shousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        血压负荷(舒张压)：<fmt:formatNumber value="${obj.shuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.shousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.shuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压时间超过临床限制的百分比：<br>
                        舒张压时间超过临床限制的百分比：<br>
                    </p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="commen_tt">
                    <span class="commen_topt">日间分析</span>
                    <table class="table table-striped tb_comen table-bordered">
                        <thead>
                        <th>名称</th>
                        <th>平均值</th>
                        <th>最大值</th>
                        <th>最小值</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>收缩压(mmHg)</td>
                            <td>${obj.dayavgSystolic}</td>
                            <td>${obj.daymaxSystolic}(<fmt:formatDate value="${obj.daymaxSystolicTime}"
                                                                      pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.dayminSystolic}(<fmt:formatDate value="${obj.dayminSystolicTime}"
                                                                      pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>舒张压(mmHg)</td>
                            <td>${obj.dayavgDiastolic}</td>
                            <td>${obj.daymaxDiastolic}(<fmt:formatDate value="${obj.daymaxDiastolicTime}"
                                                                       pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.dayminDiastolic}(<fmt:formatDate value="${obj.dayminDiastolicTime}"
                                                                       pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>心率(BPM)</td>
                            <td>${obj.dayavgHrrest}</td>
                            <td>${obj.daymaxHrrest}</td>
                            <td>${obj.dayminHrrest}</td>
                        </tr>
                        </tbody>
                    </table>
                    <p style="line-height: 20px">
                        收缩压变异系数：<fmt:formatNumber value="${obj.dayshousuobianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压变异系数：<fmt:formatNumber value="${obj.dayshuzhangbianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        平均脉压差：${obj.dayavgMaiyacha}<br>
                        血压负荷(收缩压)：<fmt:formatNumber value="${obj.dayshousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        血压负荷(舒张压)：<fmt:formatNumber value="${obj.dayshuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.dayshousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.dayshuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压时间超过临床限制的百分比：<br>
                        舒张压时间超过临床限制的百分比：<br>
                    </p>
                </div>
            </div>
            <div class="col-md-4 n-p-r">
                <div class="commen_tt">
                    <span class="commen_topt">夜间分析</span>
                    <table class="table table-striped tb_comen table-bordered">
                        <thead>
                        <th>名称</th>
                        <th>平均值</th>
                        <th>最大值</th>
                        <th>最小值</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>收缩压(mmHg)</td>
                            <td>${obj.nightavgSystolic}</td>
                            <td>${obj.nightmaxSystolic}(<fmt:formatDate value="${obj.nightmaxSystolicTime}"
                                                                      pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.nightminSystolic}(<fmt:formatDate value="${obj.nightminSystolicTime}"
                                                                      pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>舒张压(mmHg)</td>
                            <td>${obj.nightavgDiastolic}</td>
                            <td>${obj.nightmaxDiastolic}(<fmt:formatDate value="${obj.nightmaxDiastolicTime}"
                                                                       pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                            <td>${obj.nightminDiastolic}(<fmt:formatDate value="${obj.nightminDiastolicTime}"
                                                                       pattern="HH:mm:ss"></fmt:formatDate>)
                            </td>
                        </tr>
                        <tr>
                            <td>心率(BPM)</td>
                            <td>${obj.nightavgHrrest}</td>
                            <td>${obj.nightmaxHrrest}</td>
                            <td>${obj.nightminHrrest}</td>
                        </tr>
                        </tbody>
                    </table>
                    <p style="line-height: 20px">
                        收缩压变异系数：<fmt:formatNumber value="${obj.nightshousuobianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压变异系数：<fmt:formatNumber value="${obj.nightshuzhangbianyi}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        平均脉压差：${obj.nightavgMaiyacha}<br>
                        血压负荷(收缩压)：<fmt:formatNumber value="${obj.nightshousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        血压负荷(舒张压)：<fmt:formatNumber value="${obj.nightshuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.nightshousuofuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        舒张压读数超过临床限制的百分比：<fmt:formatNumber value="${obj.nightshuzhangfuhe}" type="PERCENT" pattern="0.00%"></fmt:formatNumber><br>
                        收缩压时间超过临床限制的百分比：<br>
                        舒张压时间超过临床限制的百分比：<br>
                    </p>
                </div>
            </div>

        </div>
        <!-- 指标ending -->
        <div class="hg_top">血压趋势图(反勺型血压)</div>
        <div class="commen_tt2">
            <!--这里放心电的插件-->
            <div id="container">
            </div>
        </div>
        <!-- 血压趋势图ending -->

        <div class="row n-p">
            <div class="col-md-6 n-p-l">
                <div class="hg_top">血压数据</div>
                <div class="commen_tt2" style="height: 295px; overflow: scroll; width: 100% ">
                    <table class="table table-striped table-bordered pd_rg tb_comen" style="margin-bottom: 0;">
                        <thead style=" background: #d4e1f1; ">
                        <th>收缩压</th>
                        <th>舒张压</th>
                        <th>脉压差</th>
                        <th>心率</th>
                        <th>测量时间</th>
                        <th>血压等级</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${obj.acceptDataList}" var="obj">
                            <tr time="<fmt:formatDate value="${obj.kktime}" pattern="HH"></fmt:formatDate>">
                                <td>${obj.systolicpressure}</td>
                                <td>${obj.diastolicpressure}</td>
                                <td>${obj.systolicpressure-obj.diastolicpressure}</td>
                                <td>
                                        ${obj.pulse}
                                </td>
                                <td><fmt:formatDate value="${obj.kktime}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                                <td>
                                    <c:if test="${obj.kklevel==0}"><span style="color:#71ddc5">低</span></c:if>
                                    <c:if test="${obj.kklevel==1}"><span style="color:#42d1b1">正常</span></c:if>
                                    <c:if test="${obj.kklevel==2}"><span style="color:#13c69e">高值</span></c:if>
                                    <c:if test="${obj.kklevel==3}"><span style="color:#fc7982">轻度</span></c:if>
                                    <c:if test="${obj.kklevel==4}"><span style="color:#fb4c59">中度</span></c:if>
                                    <c:if test="${obj.kklevel==5}"><span style="color:#fa1f2f">高度</span></c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-6 n-p-r">
                <div class="hg_top">服药记录</div>
                <div class="commen_tt2">
                    <table class="table table-striped table-bordered pd_rg tb_comen" style="margin-bottom: 0;">
                        <thead style="background: #d4e1f1; ">
                        <th class="w_28"></th>
                        <th class="w_148">用药时间</th>
                        <th class="w_148">药品名称</th>
                        <th class="w_88">用药剂量</th>
                        <th></th>
                        </thead>
                    </table>
                    <div class="t_tbody">
                        <table class="table table-striped table-bordered tb_comen">
                            <tbody>
                            <tr>
                                <td class="w_28">1</td>
                                <td class="w_148">2017-03-22 07:00</td>
                                <td class="w_148">氨氯地平</td>
                                <td class="w_88">5mg</td>
                                <td class="td_null"></td>
                            </tr>
                            <tr>
                                <td class="w_28">1</td>
                                <td class="w_148">2017-03-22 07:00</td>
                                <td class="w_148">氨氯地平</td>
                                <td class="w_88">5mg</td>
                                <td class="td_null"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- 血压数据服药记录-ending -->

    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/Highcharts/highcharts.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jsppage/report/index.js"></script>
</body>
</html>