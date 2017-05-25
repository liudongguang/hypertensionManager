jQuery(document).ready(function () {
    jumpPageNoAuthorityForHandlerNoContainer("/highchat/testChat",function(data) {
        console.log(data.data)
        var chart = new Highcharts.Chart('container',data.data);
    });
})