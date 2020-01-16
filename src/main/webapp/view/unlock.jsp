<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color: lime;text-align: center">WELCOME STUDENT UNLOCK FORM PAGE</h1>
    
    <font color="red">${uemsg}</font><br>
    <font color="green">${usmsg}</font>
    <form:form action="active" method="POST" modelAttribute="unlock">
    <table border="2" rules="all" align="center" width="600" height="300" style="background-color: cyan">
    <tr>
    <td><b>Email Id::</b></td> <td> <form:input path="email" readonly="true" size="30"/></td></tr>
   <tr> <td><b>Temporary password::</b></td><td><form:input path="tempPassword" size="30" /></td></tr>
   <tr> <td><b>New Password::</b></td><td><form:input path="newpws" size="30"/></td></tr>
    <tr><td><b>Conform Password::</b></td><td><form:input path="confpws" size="30"/></td></tr>
    <tr><td align="center"><input type="submit" value="unlock" onclick="return validationPassword()"></td><td align="center"><input type="reset" value="reset"></td></tr>
    
    
    </table>
    <b><a href="/">LOG IN</a></b>
    </form:form>
    
    <script>
    function validationPassword(){
    	var nwps=document.getElementById("newpws").value;
    	var cwps=document.getElementById("confpws").value;
    	if(nwps == cwps){
//     		alert("Successfully passsword updated.");
    		return true;
    	}
        alert("Please give confirm password as new password.");
        return false;
    }
    
    </script>
