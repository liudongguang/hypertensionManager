jQuery(document).ready(function () {
    $("#addfaq").click(function () {
        var piciVal=$(this).attr("pici");
        var url="/zixun/faq/addafq.jsp?pici="+piciVal;
        jumpPageNoAuthority(url,$("#mainContent"));
    });
});