jQuery(document).ready(function () {
    initTable($("#mainContent"));
    $("#addhealthInquiryID").click(function () {
        var piciVal=$(this).attr("pici");
        var url="/zixun/healthInquiry/add.jsp?pici="+piciVal;
        jumpPageNoAuthority(url,$("#mainContent"));
    });
});