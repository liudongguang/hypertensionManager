jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addPatient").click(function () {
        jumpPageNoAuthority("/webPatientHandler/addPatient",$("#mainContent"));
    });
});