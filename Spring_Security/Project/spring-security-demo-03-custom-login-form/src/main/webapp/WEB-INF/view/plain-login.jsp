<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Login Form</title>
</head>

<body>
	<h3>My Custom Login Page</h3>


	<form:form action="${pageContext.request.contextPath}/authenticateUser"
		method="POST">
		<p>
			User name: <input type="text" name="username"/>
			<!-- Spring security filters will read form data and authenticate the user with default form field names username and password -->
		</p>

		<p>
			Password: <input type="password" name="password"/> 
			<!-- Spring security filters will read form data and authenticate the user with default form field names username and password -->
		</p>
		
		<input type="submit" value="Login" />

	</form:form>
</body>
</html>