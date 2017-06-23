jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addfeedbackID").click(function () {
        var piciVal=$(this).attr("pici");
        var url="/zixun/feedback/add.jsp?pici="+piciVal+"&registphone=13608944535";
        jumpPageNoAuthority(url,$("#mainContent"));
    });
    var datepickerOpt = {
        format: 'YYYY-MM-DD',
        ignoreReadonly:true  //配合readonly
    }
    $("#startTimeID").datetimepicker(datepickerOpt);
    $("#endTimeID").datetimepicker(datepickerOpt);
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    });
});