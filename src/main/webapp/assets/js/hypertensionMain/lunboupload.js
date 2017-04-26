jQuery(document).ready(function () {
    var ajaxOpt = {
        paramurl: $("#basePath").val() + "/webHandler/getlunbotuData",
        paramdata: {},
        dataType: 'json',
        callbackFun: function (data) {
            var img1=data.data[0];
            var mycars=new Array();
            mycars[0]=img1;
            $('#file1').fileinput({
                language: 'zh',
                uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                allowedFileExtensions: ['jpg', 'png', 'gif'],
                maxFileCount: 1,
                initialPreview:mycars,
                uploadExtraData: function (previewId, index) {   //额外参数的关键点
                    var homeimageVal = $("input[name=file1_homeimage]").val();
                    var obj = {"homeimageurl": homeimageVal};
                    return obj;
                },
                showRemove:false,
                showBrowse:false,
                browseOnZoneClick:true,
                autoReplace:true
            }).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!$("input[name=file1_homeimage]").val()) {
                    return {
                        message: '没有填写连接地址1！'
                    };
                }
            });;
            var img2=data.data[1];
            console.log(img2);
            $('#file2').fileinput({
                language: 'zh',
                uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                allowedFileExtensions: ['jpg', 'png', 'gif'],
                maxFileCount: 1,
                uploadExtraData: function (previewId, index) {   //额外参数的关键点
                    var homeimageVal = $("input[name=file2_homeimage]").val();
                    var obj = {"homeimageurl": homeimageVal};
                    return obj;
                }
            }).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!$("input[name=file2_homeimage]").val()) {
                    return {
                        message: '没有填写连接地址2！'
                    };
                }
            });
            var img3=data.data[2];
            console.log(img3);
            $('#file3').fileinput({
                language: 'zh',
                uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                allowedFileExtensions: ['jpg', 'png', 'gif'],
                maxFileCount: 1,
                uploadExtraData: function (previewId, index) {   //额外参数的关键点
                    var homeimageVal = $("input[name=file3_homeimage]").val();
                    var obj = {"homeimageurl": homeimageVal};
                    return obj;
                }
            }).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!$("input[name=file3_homeimage]").val()) {
                    return {
                        message: '没有填写连接地址3！'
                    };
                }
            });
        }
    };
    ajaxRun(ajaxOpt);


   
});