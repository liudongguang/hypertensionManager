jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addPatient").click(function () {
        jumpPageNoAuthority("/webPatientHandler/addPatient",$("#mainContent"));
    });
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    });

});