jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("tr[checkTR]").click(function () {
        var uid = $(this).attr("checkTR");
        var enable = $(this).find("td[enable]").attr("enable");
        if (enable == 1) {
          $("#deviceid"+uid).prop("checked",true);
        } else if (enable == 2) {
            layer.alert("未激活，不能被选择！");
            return false;
        }
    });
    $("#sureBT").click(function () {
        var $checkedRadio=$("input[type='radio'][name='deviceid']:checked");
        var deviceID=$checkedRadio.val();
        var deviceName=$checkedRadio.attr("mingcheng");
        var deviceSN=$checkedRadio.attr("deviceSN");
        parent.setDevice(deviceID,deviceName,deviceSN);
    });
});