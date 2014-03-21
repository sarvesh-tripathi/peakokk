<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Chef Reg/-->
<section class="chefReg">
<div class="pagewidth">
	<h2>Chef Register</h2>	
	<form:form commandName ="user" action="addUser" method="post">
		<ul>
        	<li><form:input type="text" placeholder="First Name" path="firstName" tabindex="1" />
		 <form:errors path="firstName" cssClass="errorMsg" />
	</li>
        	    
            <li><form:input type="text" placeholder="Last Name" path="lastName" tabindex="2" />
                 <form:errors path="lastName" cssClass="errorMsg" /></li>
            <li><form:input type="text" placeholder="E-Mail" path="emailId" tabindex="3" />
                 <form:errors path="emailId" cssClass="errorMsg" />
			</li>
            <input type="hidden" name="userTypeId" value="2"/>  
            <li><form:input type="password" placeholder="Password" path="password" tabindex="4"/>
                <form:errors path="password" cssClass="errorMsg" /></li>
            <li><form:input type="password" placeholder="Confirm Password" path="confirmPassword" tabindex="5"/>
                 <form:errors path="confirmPassword" cssClass="errorMsg" /></li>
            <li><form:input type="text" placeholder="Contact Number" path="contactNumber" tabindex="6" /></li>    
            <li><label><form:checkbox path="termsCheckbox" tabindex="7"/> I agree to terms and Condition and Privacy Policy</label>
                       <div><form:errors path="termsCheckbox" cssClass="errorMsg" /></div> </li>
            <li class="tcenter"><input type="submit" value="Register" tabindex="7"/></li>
        </ul>
     </form:form>

</div>
</section>
<!--Chef Reg/-->
