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
            	<div class="userAccount"><span>Welcome Rob!</span> | <a href="javascript:void(0)">Logout</a></div>
            </div>
            <div class="clr"></div>
            </div>
    </header>
    <!--hedder/-->
    
    <!-- CONTENT -->
    <section id="content" class="pagewidth">
    	<!-- REGISTER -->
        <section class="orderList">        	
			   <h2>Place your Order</h2>
			   <div class="orderForm">
			       <form action="#" name="form1" method="post" enctype="multipart/form-data">
				      <dl class="clearfix">
					     <dt>Choose Cuisine</dt>
						 <dd>
						    <div class="select-style">
							    <select name="cuisine">
									    <option value="indian">Indian</option>
										<option value="chinese">Chinese</option>
										<option value="Italian">Italian</option>
								</select>
							</div>
						 </dd>
						 
						 <dt>Food Item</dt>
						 <dd>
						    <div class="select-style">
							    <select name="cuisine" id="selectFoodItem">
								        <option value="">Select Food Item</option>
									    <option value="butterChicken" id="food1" data-food-description-Id="1">Butter Chicken</option>
										<option value="butterChicken1" id="food2" data-food-description-Id="2">Butter Chicken2</option>
										<option value="butterChicken2" id="food3" data-food-description-Id="3">Butter Chicken3</option>
								</select>
							</div>
							
							<div class="foodDesc" id="1" >
							   <div class="foodDesc1">
							         <h3>Butter Chicken</h3>
									 <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. version .</p>
									 <div class="optionE clearfix">
									   <p>Extra</p>
									   <input type="radio"> <label>Butter</label>
									   <input type="radio"><label>Spice</label>									   
									 </div>
							   </div>
							   
							   <div class="foodDesc2">
							     <h3>Special Instruction</h3>
								 <input type="text" name="specIns">
							   </div>							   
							</div>
							
							<div class="foodDesc" id="2" >
							   <div class="foodDesc1">
							         <h3>Butter Chicken 1</h3>
									 <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. version .</p>
									 <div class="optionE clearfix">
									   <p>Extra</p>
									   <input type="radio"> <label>Butter</label>
									   <input type="radio"><label>Spice</label>									   
									 </div>
							   </div>
							   
							   <div class="foodDesc2">
							     <h3>Special Instruction</h3>
								 <input type="text" name="specIns">
							   </div>							   
							</div>
							
							<div class="foodDesc" id="3" >
							   <div class="foodDesc1">
							         <h3>Butter Chicken 2</h3>
									 <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. version .</p>
									 <div class="optionE clearfix">
									   <p>Extra</p>
									   <input type="radio"> <label>Butter</label>
									   <input type="radio"><label>Spice</label>									   
									 </div>
							   </div>
							   
							   <div class="foodDesc2">
							     <h3>Special Instruction</h3>
								 <input type="text" name="specIns">
							   </div>							   
							</div>
						 </dd>
						 
						 <dt>Qty</dt>
						 <dd>
						    <div class="select-style">
							    <select name="qty">
									    <option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>										
								</select>
							</div>
							
							<div class="btnBox">
							     <input type="submit" value="Cancel">
							     <input type="reset" value="Add Item">
							</div>
						 </dd>
						 
									 
						 
						 <dt>Time</dt>
						 <dd>
						    <div class="select-style1 time">
							    <select name="hours">
									    <option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>																				
								</select>
							</div>
							<div class="select-style1 time">
							    <select name="min">
									     <option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
										<option value="32">32</option>
										<option value="33">33</option>
										<option value="34">34</option>
										<option value="35">35</option>
										<option value="36">36</option>
										<option value="37">37</option>
										<option value="38">38</option>
										<option value="39">39</option>
										<option value="40">40</option>
										<option value="41">41</option>
										<option value="42">42</option>
										<option value="43">43</option>
										<option value="44">44</option>
										<option value="45">45</option>
										<option value="46">46</option>
										<option value="47">47</option>
										<option value="48">48</option>
										<option value="49">49</option>
										<option value="50">50</option>
										<option value="51">51</option>
										<option value="52">52</option>
										<option value="53">53</option>
										<option value="54">54</option>
										<option value="55">55</option>
										<option value="56">56</option>
										<option value="57">57</option>
										<option value="58">58</option>
										<option value="59">59</option>
										<option value="60">60</option>
										<option value="60">60</option>
								</select>
							</div>
							<div class="select-style1 time">
							    <select name="hours">
									    <option value="AM">AM</option>
										<option value="PM">PM</option>										
								</select>
							</div>
						 </dd>
						 
						 <dt>Date</dt>
						 <dd><img src="images/datePicker.png"></dd>
						 
						 <dt>Deliver Option</dt>
						 <dd>
						   <div class="select-style">
							    <select name="deliver">
									    <option value="pick">Pick</option>
										<option value="deliver">Deliver</option>										
								</select>
							</div>
						</dd>
						
						<dt></dt>
						<dd><input type="button" value="View Order" onClick="window.location.href='order_review.html'"></dd>
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
</html>
