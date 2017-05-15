jQuery(document).ready(function () {
    $("img[id=checkfmID]").click(function () {
        var imgpici = $("input[type=hidden][name=imgpici]").val();
        layerWindow("/webutil/caiqieimg.jsp?pici=" + imgpici, "图片裁切", 1200, 600, true);
    });
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true);
})
function disImg(imgpath) {
    $("input[type=hidden][name=headimg]").val(imgpath);
    $("#checkfmID").attr("src", imgpath);
    layer.close(jumpPageLayerNum);
}