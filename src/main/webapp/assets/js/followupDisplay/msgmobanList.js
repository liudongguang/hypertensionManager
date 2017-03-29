jQuery(document).ready(function() {
     $("[mtips]").mouseover(function () {
         var jq_this=$(this);
         layer.tips(jq_this.attr("mtips"), "#"+jq_this.attr('id'), {
             tips: [1, '#3595CC'],
             time: 3000
         });
     });
    $("[name=msguid]").click(function (event) {
        event.stopPropagation();
    });
    $("tr[id^=tr_]").click(function () {
        var jq_thisTR = $(this);
        var id = jq_thisTR.attr("id").split("_")[1];
        var checkbox = $("input[type=radio][value=" + id + "]");
        if (checkbox.is(':checked')) {
            checkbox.prop("checked", false);
        } else {
            checkbox.prop("checked", true);
        }
        return false;
    });
    //////发送按钮    /////
    initAjaxForm($("#subForm"), $("#sendMSGBTID"), function (data) {
       //成功后的执行函数
        parent.refreshData(function () {
             parent.cloaseLayerWindow();
        });
    },false,function (form, options) {
        var jq_checkedRadio=$("input[type='radio'][name=msguid]:checked");
        if(jq_checkedRadio.length>0){
            var msgid=jq_checkedRadio.val();
            var msgContent=$("#td_"+msgid).attr("mtips");
            $("#msgcontentID").val(msgContent);
            $("#msguidID").val(msgid);
             ///////////////////////////////////////
            options.zzcid = layer.load(0, {
                shade: [0.8, '#fff']
                // 0.1透明度的白色背景
            });
            form.ajaxSubmit(options);
        }else{
            layer.alert("请选择一条短信模版！");
        }
    });
});