<!DOCTYPE html>
<html>
<head>
	<title> Hello World - Name Page </title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/helloworld.css">
</head>
<body>

<h2> Hello World of Spring! </h2>

<br><br>
<h2> Student Name: ${param.studentName} </h2>
<br><br>
<h2> The Message: ${message} </h2>

</body>

</html>
