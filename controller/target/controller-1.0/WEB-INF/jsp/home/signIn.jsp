<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Chef Reg/-->
    	<section class="chefReg">
        	<div class="pagewidth">
            	<h2>Sign In</h2>
            	<form action="j_spring_security_check" method="post">
			<ul>
				<li>
					<c:if test="${not empty param.authfailed}">
						<span id="infomessage" class="errorMsg2">
						The email or password is incorrect. </span>
					</c:if>
					<c:if test="${not empty param.newpassword}">
						<span id="infomessage" class="errorMsg2"> The email or password is incorrect. <%--Login failed due
						to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />. --%></span>
					</c:if>
					<c:if test="${not empty param.acclocked}">
						<span id="infomessage" class="errorMsg2"> The email or password is incorrect. <%--Login failed due
						to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.--%> </span>
					</c:if>
					<c:if test="${not empty param.accdisabled}">
					<span id="infomessage" class="errorMsg2"> The email or password is incorrect. <%--Login failed due
						to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.--%> </span>
					</c:if>
					<c:if test="${not empty param.loggedout}">
						<span id="infomessage" class="successmessage"> The email or password is incorrect.<%--You have been
						successfully logged out.--%> </span>
					</c:if>
				</li>
                		<li><input name="j_username" type="email" tabindex="1" placeholder="Enter Email" value='<c:out value="${SPRING_SECURITY_LAST_USERNAME}" escapeXml="false"/>'  /></li>
            			<li><input name="j_password" tabindex="2" type="password" placeholder="Enter Password"/>
                    			<div class="forgotPassword"><label><input type="checkbox"/> Remember Me</label> <a href="forgotPassword">Forgot Password</a> </div>
                    		</li>
                    		<li class="tcenter">
					<input type="submit" value="Submit "/>
				</li>
                	</ul>
			
		<span id="infomessage" class="successmessage"> </span>
                </form>
            </div>
        </section>
    <!--Chef Reg/-->