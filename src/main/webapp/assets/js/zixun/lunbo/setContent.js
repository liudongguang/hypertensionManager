jQuery(document).ready(function () {
    var PiCiIDVal=$("#piciID").val();
    $("[name=pici]").val(PiCiIDVal);
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
    });
    initAjaxForm($("#subForm"+setNumVal), $("#subBT"+setNumVal), function (data) {
          if(data.errcode==0){
             layer.alert("保存完成！");
          }else{
              layer.alert("保存失败！");
          }
    }, false,function (form,options) {
        var setNumVal = $("div[class='tabbable']").find("li[class='active']").find("a").attr("href").split("tab")[1];
        /////
        var imgPath=$("#checkfmID"+setNumVal+"_path").val();
        if(!imgPath){
            layer.alert("需要上传图片！");
            return false;
        }
        /////
        var linkState=$("[name=linkState]:checked").val();
        if(1==linkState){
            ///连接地址必填
            var linkURL=$("[name=homeimageurl]").val();
            if(linkURL){
                var match = /^((ht|f)tps?):\/\/[\w\-]+(\.[\w\-]+)+([\w\-\.,@?^=%&:\/~\+#]*[\w\-\@?^=%&\/~\+#])?$/;
                if(!match.test(linkURL)){
                    layer.alert("链接地址不合法！");
                    return false;
                }
            }else{
                layer.alert("链接地址不能为空！");
                return false;
            }
        }else if(2==linkState) {
            var $content = $("#contents" + setNumVal);
            //内容必填
            if(!$.trim($content.val())){
                layer.alert("关联内容不能为空！");
                return false;
            }
        }
        form.ajaxSubmit(options);
    });
});
function disImg(imgpath,imgid) {
    $("#"+imgid).attr("src", imgpath);
    $("#"+imgid+"_path").val(imgpath);
    layer.close(jumpPageLayerNum);
}