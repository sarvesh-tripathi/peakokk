<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--hedder-->
<header class="topheader">
   	<div class="pagewidth">
           <h1><a href="home"><img src="${pageContext.servletContext.contextPath}/images/logo.png" width="230" height="67"  alt="Peakook"/></a></h1>
           <nav class="topmenu">
		<c:if test="${sessionScope.sessionExist}">
			<div class="userInfo">Welcome! ${sessionScope.USERNAME}</div>
		</c:if>
		<c:if test="${sessionScope.sessionExist && sessionScope.USER_TYPE_ID==2}">
			<div class="userInfo">
               <a href="editProfile" class="editProfile">Edit Profile</a>
            </div>
		</c:if>
		   <ul class="clearfix">
			<c:if test="${sessionScope.sessionExist}">
				<li><a href="j_spring_security_logout" class="logoutNav"> Log out</a></li>
			</c:if>
			<c:if test="${! sessionScope.sessionExist}">
				<li><a href="signIn"> Sign-in</a></li>
				<li><a href="how-it-work.html">How it works</a></li>
				<li><a href="register">Register</a></li>
				<li><a href="javascript:void(0)">Blogs</a></li>
				<li><a class="last" href="javascript:void(0)">Feedback</a></li>
			</c:if>
		    </ul>
               <div class="clr"></div>
           </nav>
           <nav class="menu">
               <input type="button" class="mBTN"/>
               <ul class="clearfix sMenu">
                   <li><a href="signIn"> Sign-in</a></li>
                   <li><a href="javascript:void(0)">Blogs</a></li>
                   <li><a href="how-it-work.html">How it works</a></li>
                   <li><a href="register">Register</a></li>
                   <li><a class="last" href="javascript:void(0)">Feedback</a></li>
               </ul>
               <div class="clr"></div>
           </nav>
           </div>
           <div class="clr"></div>
           </div>
   </header>
   <!--hedder/-->