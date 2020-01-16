<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color: lime;text-align: center">RESET PASSWORD PAGE</h1>
    <font color="green">${msg}</font>
    <form:form action="showpws" method="POST" modelAttribute="reset">
    <table  align="center" width="400" height="200" style="background-color: cyan">
    <tr>
    <td><b>Email Id::</b></td> <td> <form:input path="mail"  size="30"/></td></tr>
    <tr><td colspan="2" align="center"><input type="submit" value="reset"></td></tr>
    
    
    </table>
    <a href="/">Go Home...</a>
    </form:form>