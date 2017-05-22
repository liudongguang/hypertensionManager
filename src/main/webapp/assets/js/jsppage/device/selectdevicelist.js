jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("tr[checkTR]").click(function () {
        var uid = $(this).attr("checkTR");
        var enable = $(this).find("td[enable]").attr("enable");
        var destroy = $(this).find("td[destroy]").attr("destroy");
        var returnstate = $(this).find("td[returnstate]").attr("returnstate");
        if (enable == 1 && destroy == 1 && returnstate != 1) {
            $("#deviceid" + uid).prop("checked", true);
        } else {
            if (enable == 2) {
                layer.alert("未激活，不能被选择！");
                return false;
            }
            if (destroy == 2) {
                layer.alert("已报废，不能被选择！");
                return false;
            }
            if (returnstate == 1) {
                layer.alert("出借中，不能被选择！");
                return false;
            }
        }
    });
    $("#sureBT").click(function () {
        var $checkedRadio = $("input[type='radio'][name='deviceid']:checked");
        var deviceID = $checkedRadio.val();
        var deviceName = $checkedRadio.attr("mingcheng");
        var deviceSN = $checkedRadio.attr("deviceSN");
        parent.setDevice(deviceID, deviceName, deviceSN);
    });
});