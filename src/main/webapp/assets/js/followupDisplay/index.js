jQuery(document).ready(function () {
    var menuA = $("ul[class=templatemo-sidebar-menu]").find("a[href!='javascript:;']");
    menuA.click(function () {
        var url = $(this).attr("href");
        var thisText = $(this).text();
        var jq_shangjiText = $.trim($(this).parent().parent().prev().text());
        /////
        $("#v1ID").text(jq_shangjiText);
        $("#v2ID").text(thisText);
        /////
        jumpPageNoAuthority(url, $("#mainContent"));
        return false;
    });
    /////修改密码
    $("[ajaxhref]").click(function () {
        var thisA = $(this);
        var url = $(this).attr("href");
        layerWindow(url, "修改密码",600,300);
        return false;
    });

    //默认选择第一项
    $("#cysfID").click();
});