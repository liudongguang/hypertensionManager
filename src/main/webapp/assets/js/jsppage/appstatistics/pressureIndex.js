jQuery(document).ready(function () {
    var datepickerOpt = {
        format: 'YYYY-MM-DD'
    }
    $("#searchDateID").datetimepicker(datepickerOpt).on("dp.change", function(e) {
         var currentDate=e.currentTarget.value;
         var patientid=$("#patientUID").val();
         var ii = layer.load(0, {
            shade: [0.8, '#fff']
            // 0.1透明度的白色背景
         });
         window.location.href="appstatistics/getKKDataByPatientidAndSearchDate?patientid="+patientid+"&searchDate="+currentDate;
    });
})