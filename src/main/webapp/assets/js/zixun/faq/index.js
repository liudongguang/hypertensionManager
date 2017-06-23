jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addfaq").click(function () {
        var piciVal=$(this).attr("pici");
        var url="/zixun/faq/addafq.jsp?pici="+piciVal;
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