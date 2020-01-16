<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color: #ff00cc;text-align: center">WELCOME TO STUDENT LOGIN FORM PAGE</h1>
    <font color="red">${emsg }</font>
    <font color="green">${smsg }</font>
    <form:form action="login" method="POST" modelAttribute="login">
    <table  align="center" width="400" height="200" style="background-color: cyan">
    <tr>
    <td><b>Email Id::</b></td> <td> <form:input path="email"  size="30"/></td></tr>
   <tr> <td><b> Password::</b></td><td><form:input path="password" size="30"/></td></tr>
    <tr> <td  colspan="2" align="center"><input type="submit" value="login" ></td></tr>
    <tr><td align="center"><a href="/resetpassword">Reset Password</a></td><td align="center"><a href="/view">Sign Up</a></td></tr>
    
    
    </table>
    </form:form>