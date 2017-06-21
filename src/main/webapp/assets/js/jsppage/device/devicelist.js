jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addDevice").click(function () {
        jumpPageNoAuthority("/deviceHandler/addDevice",$("#mainContent"));
    });

    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    });

});