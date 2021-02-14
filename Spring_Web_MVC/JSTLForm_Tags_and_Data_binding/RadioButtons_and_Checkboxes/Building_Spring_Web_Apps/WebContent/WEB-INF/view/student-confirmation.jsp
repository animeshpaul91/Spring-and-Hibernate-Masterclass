<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title> Student Confirmation Form </title>
</head>

<body>
<!-- Spring calls getMethods against all Student class fields -->
 <h2> The Student is confirmed: ${student.firstName} ${student.lastName} </h2> 
 	<!-- calls to student.getfirstName() and student.getlastName() are made --> 
 <br> <br>
 <h2> Country: ${student.country} </h2>
 <br> <br>
 <h2> Favorite Language: ${student.favoriteLanguage} </h2>
 
 <br> <br>
 
 Operating Systems:
 
 <ul>
 	<c:forEach var="temp" items="${student.operatingSystems}">
 		<li> ${temp} </li>
 	</c:forEach>
 </ul>
 
 <br> <br>
 
</body>
</html>
