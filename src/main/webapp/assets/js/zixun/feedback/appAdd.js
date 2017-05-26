$(function () {
    var $imgsDIVID = $("#imgsDIVID");
    var tempdiv = '<div class="am-form-group am-form-file am-fl up_all pic"><img class="up_img" src="" alt=""/><span class="init_bg focus"><img class="init_minus" src="assets/images/init.png" alt=""/></span></div>';
    $("#doc-form-file").change(function () {
        var findImgslength = $imgsDIVID.find("img[class='up_img']").length;
        var localfiles = $(this).get(0).files;
        var length = localfiles.length;
        if (length > 5) {
            layer.alert("最多五张图片！");
            return false;
        }
        if ((findImgslength + length) > 5) {
            layer.alert("最多上传五张图片！");
            return false;
        }
        var formData = new FormData();
        for (var i = 0; i < length; i++) {
            formData.append('file' + i, localfiles[i]);
        }
        //上传图片
        ajaxRunForUpload({
            paramurl: basePath + 'fileUpload/uploadIMGForZxMultiple?pici=' + $("#piciID").val(),
            paramdata: formData,
            callbackFun: function (data) {
                for (var index in data) {
                    var $addTempDIV = $(tempdiv);
                    var $setIMG = $addTempDIV.find("img[class='up_img']").attr("src", data[index]);
                    $imgsDIVID.append($addTempDIV);
                    var $init_minus = $addTempDIV.find("img[class='init_minus']");
                    $init_minus.attr("delsrc", data[index]);
                    $init_minus.parent().show();//显示右上角的图片
                    $init_minus.click(function () {
                        ajaxRun({
                            paramurl: basePath + 'fileUpload/deleteFileByPath',
                            paramdata: {delPath: $(this).attr("delsrc")},
                            otherParam:$(this).parent().parent(),
                            callbackFun: function (delrsdata,delele) {
                                delele.remove();
                                refreshImgsContent();
                            }
                        });
                    });
                }
                refreshImgsContent();
            }
        });
    });

    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        if(data.errcode==0){
            $("#subBT").attr("disabled","disabled");
            layer.alert("保存完成！",function (index) {
                layer.close(index);
                location.replace(basePath+"/success.jsp");
            });
        }else{
            layer.alert("保存失败！");
        }
    }, true);
});
function refreshImgsContent(){
    var $imgsContent=$("#imgsContentID");
    var $upimgs=$("#imgsDIVID").find("img[class='up_img']");
    var ss="";
    $upimgs.each(function (p1, p2, p3) {
        var src=$(this).attr("src");
        ss+=src+";";
    })
    $imgsContent.val(ss);
}