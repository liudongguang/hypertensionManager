jQuery(document).ready(function() {
    $("#logdateID").datetimepicker({
        dayViewHeaderFormat:'YYYY MMMM',
        format: 'YYYY-MM-DD HH:mm:ss',
        sideBySide: true
    });
   $("#backPageID").click(function(){
       var url=$(this).attr("href");
       var searFormID=$(this).attr("searFormID");
       if(searFormID){
           var pageNumParamVal=$("[name=pageNumParam]").val();
           if(pageNumParamVal){
               $("[name=pageNum]").remove();
               var formSerialize = $("#" + searFormID).serialize();
               url=url+"?"+formSerialize+"&pageNum="+pageNumParamVal;
           }else{
               var formSerialize = $("#" + searFormID).serialize();
               url=url+"?"+formSerialize;
           }
       }
       jumpPageNoAuthority(url,$("#mainContent"));
       return false;
   });

    $("[name=logdate]").val(new Date().format('yyyy-MM-dd hh:mm:ss'));

    initAjaxForm($("#subForm"),$("#subBT"),function (data) {
        $("#mainContent").empty().html(data);
    },true,function (form, options) {
        var managerid=$("[name=managerid]").val();
        if(managerid==$("#manageridID").val()){//同一用户才可以操作
            options.zzcid = layer.load(0, {
                shade: [0.8, '#fff']
                // 0.1透明度的白色背景
            });
            form.ajaxSubmit(options);
        }else{
            layer.alert("该用户未分配工作！");
        }
    });
    ////
    initTable($("#mainContent"),$("#initTable"));
    initSetData();//设置默认选项
});