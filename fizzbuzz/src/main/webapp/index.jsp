<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fizz Buzz</title>
</head>
<body>
	<form action="FizzBuzzServlet" method="post">
		<table align="center">
			<tr>
				<td colspan="3" class="heading1" align="center">Fizz Buzz</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" class="error"><%=request.getAttribute("error") != null ? request
					.getAttribute("error") : ""%></td>
			</tr>
			<tr>
				<td>Enter Number(s)*:</td>
				<td><input type="text" name="userInput" /></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td colspan="3">* Add comma for entering multiple numbers</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>

		<%
			String result = (String) request.getAttribute("result");
			if (request.getAttribute("result") != null) {
		%>
		<table align="center" width="24%">
			<tr>
				<td colspan="3" class="result">Result : <%=request.getAttribute("result")%></td>
			</tr>
		</table>
		<%
			}
		%>
		</table>
	</form>
</body>
</html>