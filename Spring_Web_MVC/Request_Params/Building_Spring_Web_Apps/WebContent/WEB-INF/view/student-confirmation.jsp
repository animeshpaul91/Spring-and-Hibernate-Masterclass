<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title> Student Confirmation Form </title>
</head>

<body>

 <h2> The Student is confirmed: ${student.firstName} ${student.lastName} </h2> 
 	<!-- calls to student.getfirstName() and student.getlastName() are made --> 
 <br> <br>
 <h2> Country: ${student.country} </h2>
 <br> <br>
 
</body>
</html>
