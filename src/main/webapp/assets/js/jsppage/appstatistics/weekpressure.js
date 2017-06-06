$(function () {
    var patientid=$("#patientUID").val();
    jumpPageNoAuthorityForHandlerNoContainer("/appstatistics/displayWeekChat?patientid="+patientid,function(data) {
        console.log(data.data)
        var chart = new Highcharts.Chart('container',data.data);
    });
});