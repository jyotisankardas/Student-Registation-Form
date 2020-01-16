<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="js/jquery.min.js">
	
</script>

<script>
	$(document).ready(function(event) {
		$("#studentEmail").blur(function(e) {
			var email = $("#studentEmail").val();
			$.ajax({
				url : "/email?email=" + email,
				success : function(result) {
					if (result == "duplicate") {
						$("#dupemail").html("Email already registered");
						$("#studentEmail").focus();
						$("#butn").prop("disabled", true);
					} else {
						$("dupemail").html("");
						$("#butn").prop("disabled", false);
					}
				}
			});
		});
	});
</script>


<h1 style="color: blue; text-align: center">WELCOME STUDENT
	REGISTRATION FORM PAGE</h1>
<font color="green">${vsmsg}</font>
<font color="red">${vemsg}</font>
<br>
<font color="red">${msg1}</font>
<form:form action="register" method="POST" modelAttribute="student">
	<table border="2" rules="all" align="center" width="600" height="300"
		style="background-color: yellow">
		<tr>
			<td><b>Student Name::</b></td>
			<td><form:input path="studentName" size="30" /></td>
		</tr>
		<tr>
			<td><b>Student Email::</b></td>
			<td><form:input path="studentEmail" size="30" />
				<div id="dupemail" style="color: red"></div></td>
		</tr>
		<tr>
			<td><b>Student Addrs::</b></td>
			<td><form:input path="studentaddress" size="30" /></td>
		</tr>
		<tr>
			<td><b>Student Phone No::</b></td>
			<td><form:input path="phoneNo" size="30" /></td>
		</tr>

		<tr>
			<td align="center"><input type="submit" value="submit" id="butn"></td>
			<td align="center"><input type="reset" value="reset"></td>
		</tr>

	</table>





</form:form>