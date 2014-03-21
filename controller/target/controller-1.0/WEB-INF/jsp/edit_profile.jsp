<!DOCTYPE html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en-gb" class="no-js"> <!--<![endif]-->
<head>
<title>Welcome to Peakook.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="index,follow">
<meta name="keywords" content="">
<meta name="description" content="Welcome to Peakook....">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/master.css" type="text/css" media="all">
<link rel="stylesheet" href="css/carousel.css" type="text/css" media="all">
<link rel="stylesheet" href="css/media.css" type="text/css" media="all">
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
  <script type="text/javascript" src="js/modernizr.custom.39290.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="js/responsiveslides.min.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

  <script>
    // You can also use "$(window).load(function() {"
    $(function () {
		  $("#slider1").responsiveSlides({
			maxwidth: 1920,
			speed: 700,
			timeout: 2000, 
		  });
		  
		    
			$(".mBTN").click(function(){
				$("ul").slideDown();
			});
			$(".mBTN").blur(function(){
				$("ul.sMenu").slideUp();
			});
			
			 $(".featured ul li#one,.featured ul li#two,.featured ul li#three").hover(function () {
				$("li#"+this.id+" .overlay").show();
				$("li#"+this.id+" .overlay").css("display","block");
			}, 
				function() {
					$(".overlay").hide();
				});
	
			$('.footerTwo ul li').click(function(){
				$('.footerTwo .content').slideUp();
				$(this).children('.content').slideDown();
			});
			$('.navIcon').click(function(){
				$(this).next('ul').slideToggle();
			});
			
			$('#selectFoodItem').change(function(event)
			{
			    var food_item_id = $('option:selected', this).attr('data-food-description-Id');
			  	$('#'+food_item_id).show();			
			});
			
			
	  });    
  </script>
</head>
<body>
	<!--hedder-->
	<header class="topheader">
    	<div class="pagewidth">
            <h1><a href="index.html"><img src="images/logo.png" width="230" height="67"  alt="Peakook"/></a></h1>
            <nav class="topmenu">
                <ul class="clearfix">
                    <li><a href="sign-in.html"> Sign-in</a></li>
                    <li><a href="how-it-work.html">How it works</a></li>
                    <li><a href="register.html">Register</a></li>
                    <li><a href="javascript:void(0)">Blogs</a></li>
                    <li><a class="last" href="javascript:void(0)">Feedback</a></li>
                </ul>
                <div class="clr"></div>
            </nav>
            <nav class="menu">
                <input type="button" class="mBTN"/>
                <ul class="clearfix sMenu">
                    <li><a href="sign-in.html"> Sign-in</a></li>
                    <li><a href="javascript:void(0)">Blogs</a></li>
                    <li><a href="how-it-work.html">How it works</a></li>
                    <li><a href="register.html">Register</a></li>
                    <li><a class="last" href="javascript:void(0)">Feedback</a></li>
                </ul>
                <div class="clr"></div>
            </nav>
            	<div class="userAccount"><span>Welcome Rob!</span> | <a href="edit_profile.html">Edit Profile</a>  | <a href="javascript:void(0)">Logout</a></div>
            </div>
            <div class="clr"></div>
            </div>
    </header>
    <!--hedder/-->
    
    <!-- CONTENT -->
    <section id="content" class="pagewidth">
    	<!-- REGISTER -->
        <section class="orderList">        	
			   <h2>About</h2>
			   <div class="orderForm">
			       <form action="#" name="form1" method="post" enctype="multipart/form-data">
				      <dl class="clearfix editProfile">
					     <dt>Profile Picture</dt>
						 <dd>
						    <input class="uploadFile input" placeholder="Choose File" disabled="disabled" />
							<div class="fileUpload btn btn-primary">
								<span>Browse</span>
								<input  type="file" class="upload uploadBtn" />
							</div>
							<div class="clr"></div>
						 </dd>
						 
						 <dt>Background Picture</dt>
						 <dd>
						    <input class="uploadFile input" placeholder="Choose File" disabled="disabled" />
							<div class="fileUpload btn btn-primary">
								<span>Browse</span>
								<input  type="file" class="upload uploadBtn" />
							</div>
							<div class="clr"></div>
						 </dd>
							
						 
						 <dt>Name</dt>
						 <dd>
						    <input type="text" name="name" placeholder="Babu Bhai">
						 </dd>
						 
									 
						 
						 <dt>Chef Category</dt>
						 <dd>
						    <input type="checkbox"><label>Indian</label>	
							<input type="checkbox"><label>Chinese</label>	
							<input type="checkbox"><label>Thai</label>							
						 </dd>
						 
						 <dt>Location</dt>
						 <dd>
						    <a href="#" class="addressMap"><img src="images/map.png" alt=""></a>
							<div class="chifAddress">
							   <p contenteditable="true">Four street,<br>12 park avnue<br>San Francisco</p>
							</div>
						 </dd>
						 
						 <dt>Contact no.</dt>
						 <dd class="chifContact"> 
						    <input type="text" name="contctno"><a href="javascript:void(0);" class="addContact"><img src="images/contactPlus.png" alt=""></a>
						 </dd>
						
						 <dt>Specialization</dt>
						 <dd><textarea name="specialization"></textarea></dd>
						 
						  <dt>Delivery</dt>
						 <dd>
						    <input type="checkbox"><label>Pick</label>	
							<input type="checkbox"><label>Deliver</label>
						 </dd>
						 
						  <dt>About Me</dt>
						 <dd><textarea name="aboutMe"></textarea></dd>
						 
						 <dt>Top Recipes</dt>
						 <dd class="topRecipe">
						   <input type="text" name="topRecipes">
						   <textarea name="topRecpiesDes" ></textarea>
						   <div  style="position:relative;">
						    <input class="uploadFile input" placeholder="Choose File" disabled="disabled" />
							<div class="fileUpload btn btn-primary">
								<span>Browse</span>
								<input  type="file" class="upload uploadBtn" />
							</div>
							<div class="clr"></div>
							<a 	href="javascript:void(0);" class="addContact" style="right:-35px;"><img src="images/contactPlus.png" alt=""></a></div>
						 </dd>
						
						<dt></dt>
						<dd><input type="button" value="Submit" onClick="window.location.href='order_review.html'"></dd>
					  </dl>
				   </form>
			   </div>
        </section>
        <!-- /REGISTER -->
    </section>
    <!-- /CONTENT -->
    
    
    
    <!--footer-->
    <footer>
        <div class="pagewidth">
            <div class="fnav">
                <div class="fmenuBlock fmenufirst">
                    <h2>Link</h2>
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="javascript:void(0)">About</a></li>
                        <li><a href="javascript:void(0)">Portfolio</a></li>
                        <li><a href="javascript:void(0)">Blog</a></li>
                        <li><a href="javascript:void(0)">Contact</a></li>
                    </ul>
                </div>
                <div class="fmenuBlock">
                    <h2>Find</h2>
                        <ul>
                            <li><a href="javascript:void(0)">Chefs</a></li>
                            <li><a href="javascript:void(0)">Recipes</a></li>
                            <li><a href="javascript:void(0)">Resturant</a></li>
                            <li><a href="javascript:void(0)">Hotline</a></li>
                            <li><a href="javascript:void(0)">Party Organizer</a></li>
                        </ul>
                </div>
                <div class="fmenuBlock">    
                    <h2>Provision</h2>
                    <ul>
                        <li><a href="how-it-work.html">How it Works</a></li>
                        <li><a href="javascript:void(0)">My Order</a></li>
                        <li><a href="javascript:void(0)">Faq</a></li>
                        <li><a href="javascript:void(0)">Help</a></li>
                        <li><a href="javascript:void(0)">Refer to Friend</a></li>
                    </ul>
                </div>
                <div class="clr"></div>
        </div>
            <div class="footerTwo clearfix">
            <ul>
                <li>
                    <h3>Link <img src="images/footer_nav.png" width="22" height="22" alt="+" /></h3>
                    <div class="content">
                        <ul>
                            <li><a href="index.hml">Home</a></li>
                            <li><a href="javascript:void(0)">About</a></li>
                            <li><a href="javascript:void(0)">Portfolio</a></li>
                            <li><a href="javascript:void(0)">Blog</a></li>
                            <li><a href="javascript:void(0)">Contact</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <h3>Find <img src="images/footer_nav.png" width="22" height="22" alt="+" /></h3>
                    <div class="content">
                        <ul>
                            <li><a href="javascript:void(0)">Chefs</a></li>
                            <li><a href="javascript:void(0)">Recipes</a></li>
                            <li><a href="javascript:void(0)">Resturant</a></li>
                            <li><a href="javascript:void(0)">Hotline</a></li>
                            <li><a href="javascript:void(0)">Party Organizer</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <h3>Provision <img src="images/footer_nav.png" width="22" height="22" alt="+" /></h3>
                    <div class="content">
                        <ul>
                            <li><a href="how-it-work.html">How it Works</a></li>
                            <li><a href="javascript:void(0)">My Order</a></li>
                            <li><a href="javascript:void(0)">Faq</a></li>
                            <li><a href="javascript:void(0)">Help</a></li>
                            <li><a href="javascript:void(0)">Refer to Friend</a></li>
                        </ul>
                    </div>
                </li>
                
            </ul>
        </div></div>
        <div class="clr"></div>
    </footer>
    <!--footer/-->
	<div class="pagewidth">
        <section class="footerbtm">
            <p class="terms">&copy; 2012-2013. peakokk, a subsidiary of Z3 Technologies Inc. </p>
            <p class="tright"><a href="javascript:void(0)">Terms &amp; Condition </a> / <a href="javascript:void(0)">Privacy Policy</a></p>
            <div class="socialnet">
                <ul>
                    <li><a href="javascript:void(0)"></a></li>
                    <li class="gplus"><a href="javascript:void(0)"></a></li>
                    <li class="youtube"><a href="javascript:void(0)"></a></li>
                </ul>
            </div>      
            <div class="clr"></div>
        </section>
    </div>
</body>
<script>
	$(function() {
		$( "#datepicker" ).datepicker({
				showOn: "button",
				buttonImage: "images/datePicker.png",
				buttonImageOnly: true
			});
	});
	</script>
</html>
