<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
  <h3>Login with username & password</h3>
  
  <form name="formbean" action="login.jsp" method="post">
  
  <table>
      <tr>
      
          <td>User:</td>
          <td><input type="text" name = "j_username" value="" />
          </td>
          
        </tr>
        
        
      <tr>
        
           <td>Password:</td>
           <td><input type="password" name="j_password" />  
            </td>
            
        </tr>
        
        
     <tr>
     
          <td colspan = 2><input name="submit" type="button" value="submit">
          </td>
         
        </tr>
        
     </table> 
         
         
</body>
</html>