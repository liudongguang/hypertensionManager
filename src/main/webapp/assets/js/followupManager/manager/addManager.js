jQuery(document).ready(function () {
    var jq_content = $("#mainContent");
    initBackBt($("#backBTID"), jq_content);
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true);
});