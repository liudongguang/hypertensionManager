jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addDoctor").click(function () {
        jumpPageNoAuthority("/webDoctorHandler/addDoctor",$("#mainContent"));
    });
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    });

});