jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addDevice").click(function () {
        jumpPageNoAuthority("/deviceHandler/addDevice",$("#mainContent"));
    });
});