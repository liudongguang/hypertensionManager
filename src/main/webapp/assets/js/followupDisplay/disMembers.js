jQuery(document).ready(function () {
    var datepickerOpt = {
        format: 'YYYY-MM-DD',
        showTodayButton: true
    }
    $('#startTimeID').datetimepicker(datepickerOpt);
    $('#endTimeID').datetimepicker(datepickerOpt);
    initTable($("#mainContent"));
    $("[name^=uids]").click(function (event) {
        event.stopPropagation();
    });
    $("tr").click(function () {
        var jq_thisTR = $(this);
        var id = jq_thisTR.attr("id");
        var checkbox = $("input[type=checkbox][value=" + id + "]");
        if (checkbox.is(':checked')) {
            checkbox.prop("checked", false);
        } else {
            checkbox.prop("checked", true);
        }
        return false;
    });
    ///////////////////////
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    });
    //////
    initSetData();
    /////
    $("#checkAllCheckBox").click(function (event) {
        if ($(this).prop("checked")) {
            $("[name^=uids]").prop("checked", true);
        } else {
            $("[name^=uids]").prop("checked", false);
        }
        event.stopPropagation();
    });
    ////
    $("#sendMsgID").click(function () {
        var checkeds = $("[name^=uids]:checked");
        var manageridVal = $("#manageridID").val();
        var checkState = true; //默认通过状态
        if (checkeds.length <= 0) {
            layer.msg("至少选择一个患者！");
        } else {
            var str = "";
            checkeds.each(function () {
                var pationtID = $(this).val();
                var phone = "";
                var managerid = $(this).attr("managerid");
                var workid = $(this).attr("workid");
                if (manageridVal != managerid) {
                    checkState = false;  //有问题不允许通过
                    return false;
                }
                //手机号
                var shouji = $("#tdlxdh_" + pationtID).text();
                //家庭电话
                if (shouji) {
                    phone = shouji;
                } else {
                    phone = $("#tdjtdh_" + pationtID).text();
                }
                //////////
                str += pationtID + "-" + phone + "-" + workid + ";"
            });
            /////打开短信模版页面
            // var openPageParam = {
            //     paramurl: $("#basePath").val() + "/followupDisplay/msgmoban.jsp",
            //     paramdata: {phones: str},
            //     callbackFun: function (data) {
            //         $("#mainContent").empty().html(data);
            //     },
            //     serverDataType: "html"
            // }
            // ajaxRun(openPageParam);
            if (checkState) {
                layerWindow("/sdeyfollowup/getMsgModels?sendPationts=" + str, "选择短信模版", 800, 600, true);
            } else {
                layer.alert("该用户未分配工作！");
            }
        }
    });
    //////

});
function refreshData(callbackFun) {
    var url = "/sdeyfollowup/getOutHosMembers?pageNum=" + $("#pageNum").val();
    if (searFormID) {
        var formSerialize = $("#subForm").serialize();
        url = url + "&" + formSerialize;
    }
    jumpPageNoAuthorityForHandler(url, $("#mainContent"), function () {
        callbackFun();
    });
}