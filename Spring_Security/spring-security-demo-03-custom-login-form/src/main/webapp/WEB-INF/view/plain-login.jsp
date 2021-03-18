<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login Form</title>
<style>
.failed {
	color: red;
}
</style>
</head>

<body>
	<h3>My Custom Login Page</h3>


	<form:form action="${pageContext.request.contextPath}/authenticateUser"
		method="POST">

		<!-- Check for Login Error -->
		<c:if test="${param.error != null}">
			<i class="failed"> Sorry! You entered an invalid
				username/password. </i>
		</c:if>

		<p>
			User name: <input type="text" name="username" />
			<!-- Spring security filters will read form data and authenticate the user with default form field names username and password -->
		</p>

		<p>
			Password: <input type="password" name="password" />
			<!-- Spring security filters will read form data and authenticate the user with default form field names username and password -->
		</p>

		<input type="submit" value="Login" />

	</form:form>
</body>
</html>