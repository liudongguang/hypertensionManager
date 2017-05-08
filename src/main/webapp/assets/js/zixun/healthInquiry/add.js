jQuery(document).ready(function () {
    var PiCiIDVal=$("#piciID").val();
    $('#contents').summernote({
        height: 500,
        lang: 'zh-CN',
        callbacks: {
            onImageUpload: function(files) {
                //上传图片到服务器，使用了formData对象，至于兼容性...据说对低版本IE不太友好
                var formData = new FormData();
                formData.append('file',files[0]);
                $.ajax({
                    url : basePath+'webHandler/uploadIMGForZx?pici='+PiCiIDVal,//后台文件上传接口
                    type : 'POST',
                    data : formData,
                    processData : false,
                    contentType : false,
                    success : function(data) {
                        $('#contents').summernote('insertImage',data,"img");
                    }
                });
            }
        }
    });
    $("#checkfmID").click(function () {
        layerWindow("/webutil/caiqieimg.jsp?pici="+PiCiIDVal,"图片裁切",1200,600,true);
    });
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true);

});
function disImg(imgpath){
    var imgPath=imgpath+"?t="+new Date().getTime();
    $("#checkfmID").attr("src",imgPath);
    $("#smallimgID").val(imgpath);
    layer.close(jumpPageLayerNum);
}