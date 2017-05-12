jQuery(document).ready(function () {
    $("div[class='tabbable']").find("li").find("a").click(function () {
        var contentDIVID = $(this).attr("href");
        var setNum = contentDIVID.split("tab")[1];
        //如果已加载不重复加载
        var $contentDIV=$("div[class='tab-content']").find("div[id=tab"+setNum+"]");
        if(!$.trim($contentDIV.html())){
            ajaxRun({
                paramurl: basePath + 'webHandler/getSetContentPage',
                paramdata: {setNum: setNum},
                callbackFun: function (data) {
                    $(contentDIVID).empty().html(data);
                }
            });
        }else{
           // layer.msg("已加载.....")
        }

    });
    $("div[class='tabbable']").find("li[class='active']").find("a").click();
});