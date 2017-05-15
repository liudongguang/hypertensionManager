jQuery(document).ready(function () {
    var setNumVal = $("div[class='tabbable']").find("li[class='active']").find("a").attr("href").split("tab")[1];
    var PiCiIDVal=$("#piciID"+setNumVal).val();
    $("[name=pici][setnum="+setNumVal+"]").val(PiCiIDVal);
    /////初始化富文本编辑控件
    funwenbenInit($('#contents'+setNumVal),PiCiIDVal);
    initSet();//初始化单选按钮
    /////////单击图片进行裁切上传
    var imgid = 'checkfmID' + setNumVal;
    $("img[id="+imgid+"]").click(function () {
        layerWindow("/webutil/caiqieimg.jsp?pici=" + PiCiIDVal+"&bili=1&imgid="+$(this).attr("id"), "图片裁切", 1200, 600, true);
    });
    //////
    $("[name=linkState]").click(function () {
        setNumVal = $("div[class='tabbable']").find("li[class='active']").find("a").attr("href").split("tab")[1];
        var val=$(this).val();
        var $imgurl=$("[name=homeimageurl][setnum="+setNumVal+"]");
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
              var lunbo=data.data;
              $("input[type=hidden][name=uid][setnum="+setNumVal+"]").val(lunbo.uid);
              $("input[type=text][name=homeimageurl][setnum="+setNumVal+"]").val(lunbo.homeimageurl);
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
        var linkState=$("[name=linkState][setnum="+setNumVal+"]:checked").val();
        if(1==linkState){
            ///连接地址必填
            var linkURL=$("[name=homeimageurl][setnum="+setNumVal+"]").val();
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
    /////////////初始化页面
    function initSet(){
       var $radio_linkState=$("#radio_linkState_"+setNumVal);
       var radioval=$radio_linkState.val();
       var $imgurl=$("[name=homeimageurl][setnum="+setNumVal+"]");
       var $content=$("#contents"+setNumVal);
       if (radioval == 1) { //针对于使用外部连接的默认设置情况
            $imgurl.prop("disabled", false);
            $content.summernote('disable');
           $("[name=linkState][setnum="+setNumVal+"][value="+radioval+"]").prop("checked",true);
        }
    }
});
function disImg(imgpath,imgid) {
    $("#"+imgid).attr("src", imgpath);
    $("#"+imgid+"_path").val(imgpath);
    layer.close(jumpPageLayerNum);
}