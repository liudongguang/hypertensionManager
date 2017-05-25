<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" user-scalable="no">
    <meta name="description" content="ECharts, a powerful, interactive charting and visualization library for browser">
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css">
    <link rel="stylesheet" href="assets/css/gdh/appstatistics.css">
</head>
<body>
<div style="padding: 10px 0;" class="am-u-sm-12 am-margin-bottom am-margin-top">
    <div class="divs1 am-u-sm-12 am-margin-bottom">
        <img class="am-margin-left imgs1" src="assets/images/date.png" alt=""/>
        <input style="border:none;background-color: #fff!important;float: left;display: inline-block;width: 35%"
               type="text" class="am-form-field " placeholder="时间" data-am-datepicker="{theme: 'success'}" readonly/>
        <a href="jsppage/appstatistics/pressureIndex.jsp"><img class="imgs2" src="assets/images/bd.png" alt=""/></a>
        <a href="jsppage/appstatistics/daypressure.jsp"><img class="imgs3" src="assets/images/today.png" alt=""/></a>
    </div>
    <div style="width: 100%;border-top: solid 1px #aaa;border-bottom: solid 1px #aaa;padding: 10px 0;"
         class="am-u-sm-12 am-margin-bottom">
        <span class="spans1 am-margin-left"><a href="jsppage/appstatistics/weekpressure.jsp">最近一周</a></span>
        <span class="spans2 am-margin-right"><a href="jsppage/appstatistics/monthpressure.jsp">最近一月</a></span>
    </div>
</div>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="container" style="width: 100%;height:550px"></div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/Highcharts/highcharts.js"></script>
<script type="text/javascript">
    $(function () {
        $('#container').highcharts({
            chart: {
                type: 'area',
                inverted: true
            },
            title: {
                text: ''
            },
            xAxis: {
                labels: {
                    rotation: -270
                },
                categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31']
            },
            yAxis: {
                labels: {
                    rotation: -270
                },
                title: {
                    text: '血压/心率值',
                    style: {
                        color: Highcharts.getOptions().colors[1]
                    }
                }
            },

            plotOptions: {
                series: {
                    stacking: 'normal'
                }
            },
            series: [{
                type: 'column',
                name: '心率',
                data: [70, 80, 73, 78, 64, 62, 60, 80, 73, 78, 64, 62, 60, 80, 73, 78, 64, 62, 60, 80, 73, 78, 64, 62, 60, 80, 73, 78, 64, 62, 60]
            }, {
                name: '收缩压',
                type: 'spline',
                data: [121, 126, 135, 140, 120, 120, 115, 126, 135, 140, 120, 120, 115, 126, 135, 140, 120, 120, 115, 126, 135, 140, 120, 120, 115, 126, 135, 140, 120, 120, 115],
                tooltip: {
                    valueSuffix: ''
                }
            }, {
                name: '舒张压',
                type: 'spline',
                data: [60, 68, 72, 80, 65, 65, 64, 68, 72, 80, 65, 65, 64, 68, 72, 80, 65, 65, 64, 68, 72, 80, 65, 65, 64, 68, 72, 80, 65, 65, 64],
                tooltip: {
                    valueSuffix: ''
                }
            }],
            credits: {
                enabled: false
            }
        });
    });
</script>
</body>
</html>