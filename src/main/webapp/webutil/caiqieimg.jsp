<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="A simple jQuery image cropping plugin.">
    <meta name="keywords"
          content="HTML, CSS, JS, JavaScript, jQuery plugin, image cropping, image crop, image move, image zoom, image rotate, image scale, front-end, frontend, web development">
    <meta name="author" content="Fengyuan Chen">
    <title>Cropper</title>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="assets/cropper/font-awesome.min.css">
    <link rel="stylesheet" href="assets/cropper/tether.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css">
    <link rel="stylesheet" href="assets/cropper/cropper.css">
    <link rel="stylesheet" href="assets/cropper/main.css">

</head>
<body>
<!-- Content -->
<div class="container">
    <form id="subForm" action="webHandler/uploadCropperImage" enctype="multipart/form-data" method="post">
        <input type="hidden" name="pici" value="${param.pici}" id="piciID">
        <div class="row">
            <div class="col-md-9">
                <!-- <h3>Demo:</h3> -->
                <div class="img-container">
                    <img id="image" src="assets/images/cutbg.jpg" alt="Picture">
                </div>
            </div>

            <div class="col-md-3">
                <!-- <h3>Preview:</h3> -->
                <div class="docs-preview clearfix">
                    <div class="img-preview preview-lg"></div>
                    <div class="img-preview preview-md"></div>
                    <div class="img-preview preview-sm"></div>
                    <div class="img-preview preview-xs"></div>
                </div>

                <!-- <h3>Data:</h3> -->
                <div class="docs-data">
                    <input type="hidden" class="form-control" id="dataX" placeholder="x" readonly="readonly"
                           name="cut_x">
                    <input type="hidden" class="form-control" id="dataY" placeholder="y" readonly="readonly"
                           name="cut_y">
                    <input type="hidden" class="form-control" id="dataWidth" placeholder="width" readonly="readonly"
                           name="cut_width">
                    <input type="hidden" class="form-control" id="dataHeight" placeholder="height" readonly="readonly"
                           name="cut_height">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="btn-group">
                <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
                    <input type="file" class="sr-only" id="inputImage" name="avatar_file"
                           accept=".jpg,.jpeg,.png,.gif,.bmp,.tiff">
                    <span class="docs-tooltip" data-toggle="tooltip" data-animation="false"
                          title="Import image with Blob URLs">
              <span class="fa fa-upload"></span>
            </span></label>
            </div><!-- /.docs-buttons -->


            <div class="btn-group">
                <button id="subBT" type="button" class="btn btn-primary" style="margin-left: 10px">提交图片
                </button>
            </div>
        </div><!-- /.docs-toggles -->
    </form>
</div>
</div>
<!-- Scripts -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="assets/cropper/html5shiv.min.js"></script>
<script src="assets/cropper/respond.min.js"></script>
<![endif]-->
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script src="assets/cropper/tether.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script src="assets/cropper/fengyuanchencommon.js"></script>
<script src="assets/cropper/cropper.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script src="assets/js/webutil/caiqieimg.js"></script>
</body>
</html>
