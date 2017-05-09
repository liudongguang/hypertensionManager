jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addfeedbackID").click(function () {
        var piciVal=$(this).attr("pici");
        var url="/zixun/feedback/add.jsp?pici="+piciVal+"&registphone=13608944535";
        jumpPageNoAuthority(url,$("#mainContent"));
    });
});