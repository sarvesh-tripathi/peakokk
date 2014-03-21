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
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/owl.theme.css" type="text/css"
	media="all">
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
<script src="js/owl.carousel.js"></script>
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
		
		

    

    $(document).ready(function() {
		//Sort random function
		function random(owlSelector){
			owlSelector.children().sort(function(){
			return Math.round(Math.random()) - 0.5;
			}).each(function(){
			$(this).appendTo(owlSelector);
			});
		}
		 
		$("#owl-demo").owlCarousel({
			navigation: true,
			navigationText: [
				"<i class='icon-chevron-left icon-white'></i>",
				"<i class='icon-chevron-right icon-white'></i>"
			],
			beforeInit : function(elem){
				//Parameter elem pointing to $("#owl-demo")
				random(elem);
		}
		});
    });




  </script>
</head>
<body>
	<!--hedder-->
	<header class="topheader">
		<div class="pagewidth">
			<h1>
				<a href="index.html"><img src="images/logo.png" width="230"
					height="67" alt="Peakook" />
				</a>
			</h1>
			<nav class="topmenu">
				<ul class="clearfix">
					<li><a href="sign-in.html"> Sign-in</a>
					</li>
					<li><a href="how-it-work.html">How it works</a>
					</li>
					<li><a href="register.html">Register</a>
					</li>
					<li><a href="javascript:void(0)">Blogs</a>
					</li>
					<li><a class="last" href="javascript:void(0)">Feedback</a>
					</li>
				</ul>
				<div class="clr"></div>
			</nav>
			<nav class="menu">
				<input type="button" class="mBTN" />
				<ul class="clearfix sMenu">
					<li><a href="sign-in.html"> Sign-in</a>
					</li>
					<li><a href="javascript:void(0)">Blogs</a>
					</li>
					<li><a href="how-it-work.html">How it works</a>
					</li>
					<li><a href="register.html">Register</a>
					</li>
					<li><a class="last" href="javascript:void(0)">Feedback</a>
					</li>
				</ul>
				<div class="clr"></div>
			</nav>
			<div class="userAccount">
				<span>Welcome Rob!</span> | <a href="javascript:void(0)">Logout</a>
			</div>
		</div>
		<div class="clr"></div>
		</div>
	</header>
	<!--hedder/-->


	<!-- CONTENT -->
	<section id="content" class="pagewidth">
		<!-- CHEF PROFILE -->
		<section class="slider profileBanner">
			<div class="pagewidth">
				<ul class="rslides" id="slider1">
					<li><img src="images/slider/chef_banner.png" alt="">
					</li>
				</ul>
			</div>

			<div class="slideContent">
				<figure class="chefPic">
					<img src="images/slider/chef_pic.png" alt="" title="" />
				</figure>
				<div class="chefDetail">
					<h3>Babu Bhai</h3>
					<p>
						<span>India</span> <br> <img src="images/slider/rating.png"
							alt="" title="" />
					</p>
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry's , Lorem
						Ipsum is simply dummy text of the printing and typesetting
						industry. Lorem Ipsum has been the industry's</p>
					<a href="order.html">Order Now</a>
				</div>
				<div class="clr"></div>
			</div>
		</section>


		<section class="ChefProfileView">
			<div class="address">
				<div class="locationBox">
					<h2 class="location">Location</h2>
					<div class="rightContent">
						<p>Four street</p>
						<p>12 park avnue</p>
						<p>San Francisco</p>
					</div>
					<div class="clr"></div>
				</div>

				<div class="contactBox">
					<h2 class="contact">Contact</h2>
					<div class="rightContent">
						<p>0941 4545 56321</p>
						<p>
							<a href="maitto:babu@gmail.com">babu@gmail.com</a>
						</p>
					</div>
					<div class="clr"></div>
				</div>

				<div class="specialBox">
					<h2 class="specification">Specialization</h2>
					<div class="rightContent">
						<p>Indian</p>
						<p>Thai</p>
						<p>Chinese</p>
					</div>
					<div class="clr"></div>
				</div>
			</div>

			<div class="testimonial">
				<h2>Testimonials</h2>
				<ul>
					<li>
						<p>
							<a href="javascript:void(0)"><img
								src="images/testimonial/icon1.png" class="customerPic" alt=""
								title="" />
							</a> <a href="javascript:void(0)">Judi</a>
						</p>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit auctor aliquet.</p></li>

					<li>
						<p>
							<a href="javascript:void(0)"><img
								src="images/testimonial/icon2.png" class="customerPic" alt=""
								title="" />
							</a> <a href="javascript:void(0)">Judi</a>
						</p>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit auctor aliquet.</p></li>

					<li>
						<p>
							<a href="javascript:void(0)"><img
								src="images/testimonial/icon3.png" class="customerPic" alt=""
								title="" />
							</a> <a href="javascript:void(0)">Judi</a>
						</p>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit auctor aliquet.</p></li>

					<li>
						<p>
							<a href="javascript:void(0)"><img
								src="images/testimonial/icon4.png" class="customerPic" alt=""
								title="" />
							</a> <a href="javascript:void(0)">Judi</a>
						</p>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit auctor aliquet.</p></li>
				</ul>
			</div>
			<div class="clr"></div>
		</section>

		<!-- RECIPE -->
		<section class="recipeCrousal clearfix">
			<div id="owl-demo" class="owl-carousel owl-theme">
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon1.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Murg Masalam</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon2.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Chicken Cutlets</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon3.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Indian Beans</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon4.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Special Idli</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>

				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon1.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Murg Masalam</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon2.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Chicken Cutlets</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon3.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Indian Beans</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
				<div class="item">
					<a href="javascript:void(0)"><img src="images/recipe/icon4.png"
						alt="recipe Image">
					</a>
					<div class="recipeDetail">
						<h2>
							<a href="javascript:void(0)">Special Idli</a>
						</h2>
						<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
							nibh vel velit</p>
					</div>
				</div>
			</div>
		</section>
		<!-- /RECIPE -->

		<!-- COMMENTS -->
		<section class="commentsBlock">
			<h2>Comments</h2>
			<article>
				<figure>
					<img src="images/testimonial/icon4.png" alt="" title="" />
				</figure>
				<div class="commentBox">
					<img class="arrow" src="images/testimonial/rightarrow.png" alt=""
						title="" />
					<textarea></textarea>
					<input type="submit" value="Submit" />
				</div>
				<div class="clr"></div>
			</article>

			<article>
				<figure>
					<img src="images/testimonial/icon1.png" alt="" title="" />
				</figure>
				<div class="commentBox">
					<h4>
						<strong>Linda</strong> &nbsp;&nbsp;1 Sec ago
					</h4>
					<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
						nibh vel velit auctor aliquet. ersion of Lorem Ipsum. Proin
						gravida nibh vel velit auctor aliquet.</p>
					<p class="reply">
						<a href="javascript:void(0)">Reply</a> <a
							href="javascript:void(0)"><img
							src="images/testimonial/like.png" alt="" title="" />
						</a> <a href="javascript:void(0)"><img
							src="images/testimonial/dislike.png" alt="" title="" />
						</a>
					</p>
				</div>
				<div class="clr"></div>
			</article>

			<article>
				<figure>
					<img src="images/testimonial/icon2.png" alt="" title="" />
				</figure>
				<div class="commentBox">
					<h4>
						<strong>Linda</strong> &nbsp;&nbsp;1 Sec ago
					</h4>
					<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
						nibh vel velit auctor aliquet. ersion of Lorem Ipsum. Proin
						gravida nibh vel velit auctor aliquet.</p>
					<p class="reply">
						<a href="javascript:void(0)">Reply</a> <a
							href="javascript:void(0)"><img
							src="images/testimonial/like.png" alt="" title="" />
						</a> <a href="javascript:void(0)"><img
							src="images/testimonial/dislike.png" alt="" title="" />
						</a>
					</p>
				</div>
				<div class="clr"></div>
			</article>

			<article>
				<figure>
					<img src="images/testimonial/icon3.png" alt="" title="" />
				</figure>
				<div class="commentBox">
					<h4>
						<strong>Linda</strong> &nbsp;&nbsp;1 Sec ago
					</h4>
					<p>This is Photoshop's version of Lorem Ipsum. Proin gravida
						nibh vel velit auctor aliquet. ersion of Lorem Ipsum. Proin
						gravida nibh vel velit auctor aliquet.</p>
					<p class="reply">
						<a href="javascript:void(0)">Reply</a> <a
							href="javascript:void(0)"><img
							src="images/testimonial/like.png" alt="" title="" />
						</a> <a href="javascript:void(0)"><img
							src="images/testimonial/dislike.png" alt="" title="" />
						</a>
					</p>
				</div>
				<div class="clr"></div>
			</article>
		</section>
		<!-- COMMENTS -->

		<!-- /CHEF PROFILE -->
	</section>
	<!-- /CONTENT -->


	<!--footer-->
	<footer>
		<div class="pagewidth">
			<div class="fnav">
				<div class="fmenuBlock fmenufirst">
					<h2>Link</h2>
					<ul>
						<li><a href="index.html">Home</a>
						</li>
						<li><a href="javascript:void(0)">About</a>
						</li>
						<li><a href="javascript:void(0)">Portfolio</a>
						</li>
						<li><a href="javascript:void(0)">Blog</a>
						</li>
						<li><a href="javascript:void(0)">Contact</a>
						</li>
					</ul>
				</div>
				<div class="fmenuBlock">
					<h2>Find</h2>
					<ul>
						<li><a href="javascript:void(0)">Chefs</a>
						</li>
						<li><a href="javascript:void(0)">Recipes</a>
						</li>
						<li><a href="javascript:void(0)">Resturant</a>
						</li>
						<li><a href="javascript:void(0)">Hotline</a>
						</li>
						<li><a href="javascript:void(0)">Party Organizer</a>
						</li>
					</ul>
				</div>
				<div class="fmenuBlock">
					<h2>Provision</h2>
					<ul>
						<li><a href="how-it-work.html">How it Works</a>
						</li>
						<li><a href="javascript:void(0)">My Order</a>
						</li>
						<li><a href="javascript:void(0)">Faq</a>
						</li>
						<li><a href="javascript:void(0)">Help</a>
						</li>
						<li><a href="javascript:void(0)">Refer to Friend</a>
						</li>
					</ul>
				</div>
				<div class="clr"></div>
			</div>
			<div class="footerTwo clearfix">
				<ul>
					<li>
						<h3>
							Link <img src="images/footer_nav.png" width="22" height="22"
								alt="+" />
						</h3>
						<div class="content">
							<ul>
								<li><a href="index.hml">Home</a>
								</li>
								<li><a href="javascript:void(0)">About</a>
								</li>
								<li><a href="javascript:void(0)">Portfolio</a>
								</li>
								<li><a href="javascript:void(0)">Blog</a>
								</li>
								<li><a href="javascript:void(0)">Contact</a>
								</li>
							</ul>
						</div></li>
					<li>
						<h3>
							Find <img src="images/footer_nav.png" width="22" height="22"
								alt="+" />
						</h3>
						<div class="content">
							<ul>
								<li><a href="javascript:void(0)">Chefs</a>
								</li>
								<li><a href="javascript:void(0)">Recipes</a>
								</li>
								<li><a href="javascript:void(0)">Resturant</a>
								</li>
								<li><a href="javascript:void(0)">Hotline</a>
								</li>
								<li><a href="javascript:void(0)">Party Organizer</a>
								</li>
							</ul>
						</div></li>
					<li>
						<h3>
							Provision <img src="images/footer_nav.png" width="22" height="22"
								alt="+" />
						</h3>
						<div class="content">
							<ul>
								<li><a href="how-it-work.html">How it Works</a>
								</li>
								<li><a href="javascript:void(0)">My Order</a>
								</li>
								<li><a href="javascript:void(0)">Faq</a>
								</li>
								<li><a href="javascript:void(0)">Help</a>
								</li>
								<li><a href="javascript:void(0)">Refer to Friend</a>
								</li>
							</ul>
						</div></li>

				</ul>
			</div>
		</div>
		<div class="clr"></div>
	</footer>
	<!--footer/-->
	<div class="pagewidth">
		<section class="footerbtm">
			<p class="terms">&copy; 2012-2013. peakokk, a subsidiary of Z3
				Technologies Inc.</p>
			<p class="tright">
				<a href="javascript:void(0)">Terms &amp; Condition </a> / <a
					href="javascript:void(0)">Privacy Policy</a>
			</p>
			<div class="socialnet">
				<ul>
					<li><a href="javascript:void(0)"></a>
					</li>
					<li class="gplus"><a href="javascript:void(0)"></a>
					</li>
					<li class="youtube"><a href="javascript:void(0)"></a>
					</li>
				</ul>
			</div>
			<div class="clr"></div>
		</section>
	</div>


	<script>
    $(document).ready(function() {
      $("#owl-demo").owlCarousel({
        autoPlay:1000,
        items:4,
        itemsDesktop : [1199,3],
        itemsDesktopSmall : [979,3]
      });

    });
    </script>

</body>
</html>
