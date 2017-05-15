jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addDoctor").click(function () {
        jumpPageNoAuthority("/webDoctorHandler/addDoctor",$("#mainContent"));
    });
});