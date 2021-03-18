<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Luv2code Company Title Page</title>
</head>

<body>
	<h2>Luv2code Company Page</h2>
	<hr>

	<p>Welcome to Luv2code Company Page</p>

	<!-- display the username and the role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to leaders -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders"> Leadership
				Meeting </a> (Only for Managers)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to systems (only for admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems"> IT Systems
				Meeting </a> (Only for System Administrators)
		</p>
	</security:authorize>

	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>
</body>

</html>