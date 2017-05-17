jQuery(document).ready(function () {
    $("input[type=text][name=shebeiName]").click(function () {
        layerWindow("/deviceHandler/deviceListForSelect", "选择设备", 1200, 600, true);
    });
    var datepickerOpt = {
        format: 'YYYY-MM-DD'
    }
    var nowday=new Date();
    var nowdatepickerOpt = {
        format: 'YYYY-MM-DD',
        minDate:nowday
    }
    $("input[type=text][name=zjstart]").datetimepicker(nowdatepickerOpt);
    $("input[type=text][name=zjend]").datetimepicker(nowdatepickerOpt);
    $("input[type=text][name=birthday]").datetimepicker(datepickerOpt);
    ///////////////////////////////////////////////////////////////////////
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true, function (form, options) {
        var registphoneVal = $("input[name=registphone]").val();
        var uidVal = $("input[name=uid]").val();
        if (registphoneVal) {
            ajaxRun({
                paramurl: basePath + "/webPatientHandler/checkValidate",
                paramdata: {
                    "registphone": registphoneVal,uid:uidVal
                },
                dataType: 'json',
                callbackFun: function (data) {
                    if (data.errcode == 0) {
                        options.zzcid = layer.load(0, {
                            shade: [0.8, '#fff']
                            // 0.1透明度的白色背景
                        });
                        form.ajaxSubmit(options);
                    } else {
                        layer.alert(data.errmsg);
                    }
                }
            });
        }else{
            if(!registphoneVal){
                layer.alert("手机号不能为空！");
                return false;
            }
        }
    });
});
function setDevice(deviceId,deviceName,deviceSN) {
    $("input[type=text][name=shebeiName]").val(deviceName);
    $("input[type=hidden][name=shebeiUID]").val(deviceId);
    $("input[type=hidden][name=shebeiSN]").val(deviceSN);
    layer.close(jumpPageLayerNum);
}