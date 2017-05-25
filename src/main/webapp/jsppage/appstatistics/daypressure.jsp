<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>日血压图</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" user-scalable="no">
    <meta name="description" content="ECharts, a powerful, interactive charting and visualization library for browser">
    <link rel="stylesheet" href="assets/css/gdh/amazeui.min.css">
    <style>
        .divs1 {
            border-top: solid 1px #aaa;
            border-bottom: solid 1px #aaa;
            padding: 10px 0;
        }

        .imgs1 {
            width: 32px;
            float: left;
            margin-right: 20px;
        }

        .imgs2 {
            width: 35px;
            float: right;
            margin-right: 20px;
        }

        .imgs3 {
            width: 33px;
            float: right;
            margin-right: 20px;
        }

        .spans1 {
            width: 44%;
            height: 35px;
            line-height: 35px;
            display: inline-block;
            float: left;
            text-align: center;
            border-right: solid 1px #aaa;
        }

        .spans2 {
            width: 44%;
            height: 35px;
            line-height: 35px;
            display: inline-block;
            float: right;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="padding: 10px 0;" class="am-u-sm-12 am-margin-bottom am-margin-top">
    <div class="divs1 am-u-sm-12 am-margin-bottom">
        <img class="imgs1 am-margin-left" src="assets/images/date.png" alt=""/>
        <!--<span style="width: 50px;height: 35px;line-height: 35px;display: inline-block;float: left;border-right: solid 1px #aaa;font-size: 18px;">日期</span>-->
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
<div id="container" style="width: 100%;height:400px"></div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/Highcharts/highcharts.js"></script>
<script type="text/javascript">
    $(function () {
        $('#container').highcharts({
            title: {
                text: ''
            },
            xAxis: {
                categories: ['6:00', '9：00', '12:00', '15:00', '18:00']
            },
            yAxis: {
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
                data: [70, 80, 73, 78, 64]
            }, {
                name: '收缩压',
                type: 'spline',
                data: [121, 126, 135, 140, 120],
                tooltip: {
                    valueSuffix: ''
                }
            }, {
                name: '舒张压',
                type: 'spline',
                data: [60, 68, 72, 80, 65],
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