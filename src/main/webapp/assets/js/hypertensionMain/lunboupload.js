jQuery(document).ready(function () {
    //自定义模版，去除了缩略图上传按钮
    var customlayoutTemplates={
        actions: '<div class="file-actions">\n' +
        '    <div class="file-footer-buttons">\n' +
        '         {delete} {zoom} {other}' +
        '    </div>\n' +
        '    {drag}\n' +
        '    <div class="file-upload-indicator" title="{indicatorTitle}">{indicator}</div>\n' +
        '    <div class="clearfix"></div>\n' +
        '</div>'
    }
    var match = /^((ht|f)tps?):\/\/[\w\-]+(\.[\w\-]+)+([\w\-\.,@?^=%&:\/~\+#]*[\w\-\@?^=%&\/~\+#])?$/;
    var ajaxOpt = {
        paramurl: $("#basePath").val() + "/webHandler/getlunbotuData",
        paramdata: {},
        dataType: 'json',
        callbackFun: function (data) {
            var Sendings=data.data;
            var send1=Sendings[0];
            var file1OPT=null;
            var jq_file1_homeimageurl=$("input[name=file1_homeimageurl]");
            if(send1){
                var uid1=send1.uid;
                jq_file1_homeimageurl.val(send1.imglink);
                file1OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    initialPreview:send1.initialPreview,
                    initialPreviewConfig:send1.initialPreviewConfig,
                    initialPreviewThumbTags:send1.initialPreviewThumbTags,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file1_homeimageurl.val();
                        var obj = {"homeimageurl": homeimageVal,"uid":uid1};
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }else{
                file1OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file1_homeimageurl.val();
                        var RT_uid=jq_file1_homeimageurl.attr("uid");
                        var obj = {"homeimageurl": homeimageVal};
                        if(RT_uid){
                            obj = {"homeimageurl": homeimageVal,"uid":RT_uid};
                        }
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }
            $('#file1').fileinput(file1OPT).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!jq_file1_homeimageurl.val()) {
                    return {
                        message: '没有填写连接地址1！'
                    };
                }else{
                    if(!match.test(jq_file1_homeimageurl.val())){
                        return {
                            message: '连接地址不合法！'
                        };
                    }
                }
            }).on('fileuploaded', function(event, data, previewId, index) {
                 var RT_uid=data.response.initialPreviewConfig[0].key;
                  jq_file1_homeimageurl.attr("uid",RT_uid);
            });



            var send2=Sendings[1];
            var file2OPT=null;
            var jq_file2_homeimageurl=$("input[name=file2_homeimageurl]");
            if(send2){
            var uid2=send2.uid;
            jq_file2_homeimageurl.val(send2.imglink);
                file2OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    initialPreview:send2.initialPreview,
                    initialPreviewConfig:send2.initialPreviewConfig,
                    initialPreviewThumbTags:send2.initialPreviewThumbTags,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file2_homeimageurl.val();
                        var obj = {"homeimageurl": homeimageVal,"uid":uid2};
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }else{
                file2OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file2_homeimageurl.val();
                        var RT_uid=jq_file2_homeimageurl.attr("uid");
                        var obj = {"homeimageurl": homeimageVal};
                        if(RT_uid){
                            obj = {"homeimageurl": homeimageVal,"uid":RT_uid};
                        }
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }
            $('#file2').fileinput(file2OPT).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!jq_file2_homeimageurl.val()) {
                    return {
                        message: '没有填写连接地址2！'
                    };
                }else{
                    if(!match.test(jq_file2_homeimageurl.val())){
                        return {
                            message: '连接地址不合法！'
                        };
                    }
                }
            }).on('fileuploaded', function(event, data, previewId, index) {
                var RT_uid=data.response.initialPreviewConfig[0].key;
                jq_file2_homeimageurl.attr("uid",RT_uid);
            });
            var send3=Sendings[2];
            var file3OPT=null;
            var jq_file3_homeimageurl=$("input[name=file3_homeimageurl]");
            if(send3){
            var uid3=send3.uid;
            jq_file3_homeimageurl.val(send3.imglink);
                file3OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    initialPreview:send3.initialPreview,
                    initialPreviewConfig:send3.initialPreviewConfig,
                    initialPreviewThumbTags:send3.initialPreviewThumbTags,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file3_homeimageurl.val();
                        var obj = {"homeimageurl": homeimageVal,"uid":uid3};
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }else{
                file3OPT={
                    language: 'zh',
                    uploadUrl: $("#basePath").val() + 'webHandler/uploadLunBoTu',
                    allowedFileExtensions: ['jpg', 'png', 'gif'],
                    maxFileCount: 1,
                    uploadExtraData: function (previewId, index) {   //额外参数的关键点
                        var homeimageVal = jq_file3_homeimageurl.val();
                        var RT_uid=jq_file3_homeimageurl.attr("uid");
                        var obj = {"homeimageurl": homeimageVal};
                        if(RT_uid){
                            obj = {"homeimageurl": homeimageVal,"uid":RT_uid};
                        }
                        return obj;
                    },
                    showRemove:false,
                    showBrowse:false,
                    browseOnZoneClick:true,
                    autoReplace:true,
                    allowedPreviewTypes: ['image'],
                    layoutTemplates:customlayoutTemplates
                }
            }
            $('#file3').fileinput(file3OPT).on('filepreupload', function (event, file, previewId, index, reader) {
                if (!jq_file3_homeimageurl.val()) {
                    return {
                        message: '没有填写连接地址3！'
                    };
                }else{
                    if(!match.test(jq_file3_homeimageurl.val())){
                        return {
                            message: '连接地址不合法！'
                        };
                    }
                }
            }).on('fileuploaded', function(event, data, previewId, index) {
                var RT_uid=data.response.initialPreviewConfig[0].key;
                jq_file3_homeimageurl.attr("uid",RT_uid);
            });
        }
    };
    ajaxRun(ajaxOpt);
});