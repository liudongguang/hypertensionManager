jQuery(document).ready(function () {
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true, function (form, options) {
        var snVal = $("input[name=sn]").val();
        var uidVal = $("input[name=uid]").val();
        if (snVal) {
            ajaxRun({
                paramurl: basePath + "/deviceHandler/checkDeviceSN",
                paramdata: {
                    "sn": snVal, uid: uidVal
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
            if(!snVal){
                layer.alert("SN不能为空！");
                return false;
            }
        }
    });
});