jQuery(document).ready(function () {
  $("tr[time]").each(function () {
      var time=parseInt($(this).attr("time"));
     if((time>=22&&time<=24)||(time<=6&&time>=0)){
         var $this=$(this);
         $this.children('td').css('background-color','#cdcdcd');
     }
  })
});
