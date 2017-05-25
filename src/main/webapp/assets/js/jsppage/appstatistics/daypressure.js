$(function () {
    var patientid=$("#patientUID").val();
    var currentDate=$("#currentDateID").val();
    jumpPageNoAuthorityForHandlerNoContainer("/appstatistics/displayDayChat?patientid="+patientid+"&searchDate="+currentDate,function(data) {
        console.log(data.data)
        var chart = new Highcharts.Chart('container',data.data);
    });

});