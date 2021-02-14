<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>

</head>
<body>
<!--  When the form gets loaded the getters on Student class are called. When the form gets 
	submitted the setters are called  -->
	
	<form:form action="processForm" modelAttribute="student">
		<!--model attribute should match with the model attribute defined in StudentController in line # 17 -->
		First Name: <form:input path="firstName" /> <!-- firstName is a property of Student Class -->
		<br><br>
		Last Name: <form:input path="lastName" /> <!-- lastName is a property of Student Class -->
		<br><br>
		<input type="submit" value="submit">
	
	</form:form>

</body>
</html>
