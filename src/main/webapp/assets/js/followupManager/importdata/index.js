jQuery(document).ready(function () {
    $("[ajaxthispage]").click(function () {
        var dateStr=$("#fprqID option:selected").val();
        if(dateStr){
            var hrefVal=$(this).attr("href")+"?handlerDate="+dateStr;
            jumpPageNoAuthority(hrefVal,$("#mainContent"));
        }else{
            layer.alert("请选择一个日期！");
        }
        return false;
    });
});