
    
$(document).ready( function() {

      // sidebar menu click
      $('.templatemo-sidebar-menu li.sub a').click(function(){
      if($(this).parent().hasClass('open')) {
      $(this).parent().removeClass('open');
      $(this).parent().siblings().removeClass('open');
      } else {
      $(this).parent().addClass('open');
      $(this).parent().siblings().removeClass('open');
      }
      });  // sidebar menu click

      }); // document.ready



      $(".templatemo-submenu li a").click(function(){
      if($(this).has(".lon")){  
      $(this).addClass('lon').parent().siblings().find("a").removeClass("lon");
	  $(this).parentsUntil("sub").siblings().find("a").removeClass('lon');
      }
	 
	  }) ;
