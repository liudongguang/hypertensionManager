jQuery(document).ready(function () {
    var jq_content=$("#mainContent");
    initTable(jq_content);
    initAjaxForm($("#subForm"), $("#fenpeiID"), function (data) {
        jq_content.empty().html(data);
    }, false,function (form, options) {
        var jq_checkedCheckbox=$("input[name='userid']:checked");
        if(jq_checkedCheckbox.length){
            var jq_fenpeiDateVal=$("#fenpeiDateID option:selected").val();
            if(jq_fenpeiDateVal){
                options.zzcid = layer.load(0, {
                    shade: [0.8, '#fff']
                    // 0.1透明度的白色背景
                });
                form.ajaxSubmit(options);
            }else{
                layer.alert("请选择分配日期！");
            }
        }else{
            layer.alert("至少选择一个人！");
        }
    });
});