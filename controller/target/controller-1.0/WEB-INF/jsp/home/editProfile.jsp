<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--hedder/-->
    
    <!-- CONTENT -->
    <section id="content" class="pagewidth">
    	<!-- REGISTER -->
        <section class="orderList">        	
			   <h2>About</h2>
			   <div class="orderForm">
			       <form commandName="profilePage" action="saveProfile" method="post" enctype="multipart/form-data">
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
						<dd><input type="button" value="Submit"></dd>
					  </dl>
				   </form>
			   </div>
        </section>
        <!-- /REGISTER -->
    </section>
    <!-- /CONTENT -->