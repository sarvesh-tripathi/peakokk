<!DOCTYPE html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en-gb" class="no-js">
<!--<![endif]-->
<head>
<title>Welcome to Peakook.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="index,follow">
<meta name="keywords" content="">
<meta name="description" content="Welcome to Peakook....">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/master.css" type="text/css" media="all">
<link rel="stylesheet" href="css/carousel.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/media.css" type="text/css" media="all">
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600'
	rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="js/modernizr.custom.39290.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
      $("#slider1").responsiveSlides({
        maxwidth: 1920,
        speed: 700,
		timeout: 2000, 
      });
    });
		$(document).ready(function(){
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
		});
		
	$(function(){
		$('.footerTwo ul li').click(function(){
			$('.footerTwo .content').slideUp();
			$(this).children('.content').slideDown();
		});
	$('.navIcon').click(function(){
		$(this).next('ul').slideToggle();
	})
		});
  </script>
</head>
<body>
<!--hedder-->
<header class="topheader">
<div class="pagewidth">
<h1><a href="index.html"><img src="images/logo.png" width="230"
	height="67" alt="Peakook" /></a></h1>
<nav class="topmenu">
<ul class="clearfix">
	<li><a href="sign-in.html"> Sign-in</a></li>
	<li><a href="how-it-work.html">How it works</a></li>
	<li><a href="register.html">Register</a></li>
	<li><a href="javascript:void(0)">Blogs</a></li>
	<li><a class="last" href="javascript:void(0)">Feedback</a></li>
</ul>
<div class="clr"></div>
</nav> <nav class="menu"> <input type="button" class="mBTN" />
<ul class="clearfix sMenu">
	<li><a href="sign-in.html"> Sign-in</a></li>
	<li><a href="javascript:void(0)">Blogs</a></li>
	<li><a href="how-it-work.html">How it works</a></li>
	<li><a href="register.html">Register</a></li>
	<li><a class="last" href="javascript:void(0)">Feedback</a></li>
</ul>
<div class="clr"></div>
</nav></div>
<div class="clr"></div>
</div>
</header>
<!--hedder/-->

<!--Slider-->
<section class="slider">
<div class="pagewidth">
<ul class="rslides" id="slider1">
	<li><img src="images/slider.jpg" alt=""></li>
	<li><img src="images/slider1.jpg" alt=""></li>
	<li><img src="images/slider2.jpg" alt=""></li>
	<li><img src="images/slider3.jpg" alt=""></li>
	<li><img src="images/slider4.jpg" alt=""></li>
</ul>
</div>
<div class="slideContent">
<h2>Peakokk</h2>
<h3>Lorem Ipsum is simply dummy text of the printing.</h3>
<a href="chef_in_your_area.html">Looking For Chef in your area</a></div>
</section>
<!--slider/-->
<!--Slider-->
<section class="featured ">

<div class="pagewidth">
<div class="lookingChef"><a href="javascript:void(0)">Looking
For Chef in your area</a></div>
<ul>
	<li id="one"><figure><img src="images/chef.png" alt="" /></figure>
	<h2>Top Rated Chef</h2>
	<p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh
	vel velit auctor aliquet.</p>
	<a class="overlay" href=""> <img src="images/ring.png"> </a></li>
	<li id="two"><figure><img src="images/recipes.png" alt="" /></figure>
	<h2>Top Rated Recipes</h2>
	<p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh
	vel velit auctor aliquet.</p>
	<a class="overlay" href="javascript:void(0)"> <img
		src="images/ring.png"> </a></li>
	<li id="three"><figure><img src="images/feedback.png"
		alt="" /></figure>
	<h2>Reviews and Feedback</h2>
	<p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh
	vel velit auctor aliquet.</p>
	<a class="overlay" href="javascript:void(0)"> <img
		src="images/ring.png"> </a></li>
</ul>
<div class="clr"></div>
</div>
</section>
<!--slider/-->
<!--about /-->
<div class="pagewidth"><section class="about">
<div class="recommendChef">
<h2>Recommended Chef in your Area</h2>
<ul>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg.png" class="displayB" alt="" /><img
		src="images/chefimg_1.png" class="displayN" alt="" /></a></figure>
	<h2>Maesh Kumar</h2>
	<p>Indian Chef</p>
	</li>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg1.png" class="displayB" alt="" /> <img
		src="images/chefimg1_1.png" class="displayN" alt="" /></a></figure>
	<h2>Mark dew</h2>
	<p>Mexican Chef</p>
	</li>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg2.png" class="displayB" alt="" /><img
		src="images/chefimg2_1.png" class="displayN" alt="" /></a></figure>
	<h2>Ravi Kumar</h2>
	<p>Indian Chef</p>
	</li>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg3.png" class="displayB" alt="" /> <img
		src="images/chefimg3_1.png" class="displayN" alt="" /></a></figure>
	<h2>John Smith</h2>
	<p>Itlaian Chef</p>
	</li>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg4.png" class="displayB" alt="" /><img
		src="images/chefimg4_1.png" class="displayN" alt="" /></a></figure>
	<h2>Kushal kant</h2>
	<p>Indian Chef</p>
	</li>
	<li><figure><a href="chef_profile.html"><img
		src="images/chefimg5.png" class="displayB" alt="" /><img
		src="images/chefimg5_1.png" class="displayN" alt="" /></a></figure>
	<h2>Dany</h2>
	<p>Indian Chef</p>
	</li>
</ul>
<div class="clr"></div>
</div>
<div class="appstore">
<h2>Get Peakokk on your Finger Tips</h2>
<figure><img src="images/app.png" alt="" /></figure>
<p><a href="javascript:void(0)"><img src="images/itunes.png"
	alt="" /></a></p>
<p><a href="javascript:void(0)"><img src="images/googleplay.png"
	alt="" /></a></p>
<div class="clr"></div>
</div>
<div class="clr"></div>
</section></div>

<!--about /-->
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
	<h3>Link <img src="images/footer_nav.png" width="22" height="22"
		alt="+" /></h3>
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
	<h3>Find <img src="images/footer_nav.png" width="22" height="22"
		alt="+" /></h3>
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
	<h3>Provision <img src="images/footer_nav.png" width="22"
		height="22" alt="+" /></h3>
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
</div>
</div>
<div class="clr"></div>
</footer>
<!--footer/-->
<div class="pagewidth"><section class="footerbtm">
<p class="terms">&copy; 2012-2013. peakokk, a subsidiary of Z3
Technologies Inc.</p>
<p class="tright"><a href="javascript:void(0)">Terms &amp;
Condition </a> / <a href="javascript:void(0)">Privacy Policy</a></p>
<div class="socialnet">
<ul>
	<li><a href="javascript:void(0)"></a></li>
	<li class="gplus"><a href="javascript:void(0)"></a></li>
	<li class="youtube"><a href="javascript:void(0)"></a></li>
</ul>
</div>
<div class="clr"></div>
</section></div>
</body>
</html>
