jQuery(document).ready(function () {
    initAjaxForm($("#subFormUpdatePass"), $("#subUpdatePassBT"), function (data) {
       if(data.errorCode==0){
           layer.close(jumpPageLayerNum);
           layer.alert("修改成功，请重新登陆！",function () {
               location.href="sdeyfollowup/loginOut";
           });
       }else{
           layer.alert(data.errorMsg);
       }
    }, true,function (form,options) {
        //检查重复密码是否相同
        var pass1=$("#newpasswordID").val();
        var pass2=$("#newpassword2ID").val();
        if(pass1==pass2){
            options.zzcid = layer.load(0, {
                shade: [0.8, '#fff']
                // 0.1透明度的白色背景
            });
            form.ajaxSubmit(options);
        }else{
             layer.msg("新密码不一致！");
        }
    });
    $("#backPageID").click(function () {
        layer.close(jumpPageLayerNum);
    });
});