jQuery(document).ready(function () {
    var PiCiIDVal=$("#piciID").val();
    var setNumVal = $("div[class='tabbable']").find("li[class='active']").find("a").attr("href").split("tab")[1];
    /////初始化富文本编辑控件
    funwenbenInit($('#contents'+setNumVal),PiCiIDVal);
    /////////单击图片进行裁切上传
    var imgid = 'checkfmID' + setNumVal;
    $("img[id="+imgid+"]").click(function () {
        layerWindow("/webutil/caiqieimg.jsp?pici=" + PiCiIDVal+"&bili=1&imgid="+$(this).attr("id"), "图片裁切", 1200, 600, true);
    });
    //////
    $("[name=linkState]").click(function () {
        setNumVal = $("div[class='tabbable']").find("li[class='active']").find("a").attr("href").split("tab")[1];
        var val=$(this).val();
        var $imgurl=$("[name=homeimageurl]");
        var $content=$("#contents"+setNumVal);
        if(1==val){
            $imgurl.prop("disabled",false);
            $content.summernote('disable');
        }else if(2==val){
            $imgurl.prop("disabled",true);
            $content.summernote('enable');
        }
    })
});
function disImg(imgpath,imgid) {
    var imgPath = imgpath + "?t=" + new Date().getTime();
    $("#"+imgid).attr("src", imgPath);
    $("#"+imgid+"_path").val(imgPath);
    layer.close(jumpPageLayerNum);
}