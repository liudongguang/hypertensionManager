jQuery(document).ready(function () {
    $("img[id=checkfmID]").click(function () {
        var imgpici = $("input[type=hidden][name=imgpici]").val();
        layerWindow("/webutil/caiqieimg.jsp?pici=" + imgpici, "图片裁切", 1200, 600, true);
    });
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true, function (form, options) {
        var usernameVal = $("input[name=username]").val();
        var gonghaoVal = $("input[name=gonghao]").val();
        if (usernameVal || gonghaoVal) {
            ajaxRun({
                paramurl: basePath + "/webDoctorHandler/checkManagerUserName",
                paramdata: {
                    "username": usernameVal, "gonghao": gonghaoVal
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
            if(!gonghaoVal){
                layer.alert("工号不能为空！");
                return false;
            }
            if(!usernameVal){
                layer.alert("登陆帐号不能为空！");
                return false;
            }

        }
    });
})
function disImg(imgpath) {
    $("input[type=hidden][name=headimg]").val(imgpath);
    $("#checkfmID").attr("src", imgpath);
    layer.close(jumpPageLayerNum);
}