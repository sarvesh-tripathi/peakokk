<!DOCTYPE html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en-gb" class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!--<title>Welcome to Peakook.</title>
--><title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="index,follow">
<meta name="keywords" content="">
<meta name="description" content="Welcome to Peakook....">


<link rel="stylesheet" href='${pageContext.servletContext.contextPath}/styles/reset.css' type="text/css" media="all">
<link rel="stylesheet" href='${pageContext.servletContext.contextPath}/styles/master.css' type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/carousel.css" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/media.css" type="text/css" media="all">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.servletContext.contextPath}/images/favicon.ico" />
<!-- this styles only adds some repairs on idevices  -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,500,600' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery/modernizr.custom.39290.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/scripts/jquery/responsiveslides.min.js"></script>
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
	<tiles:insertAttribute name="header" />
   	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="upperFooter" />
	<tiles:insertAttribute name="lowerFooter" />
</body>
</html>
