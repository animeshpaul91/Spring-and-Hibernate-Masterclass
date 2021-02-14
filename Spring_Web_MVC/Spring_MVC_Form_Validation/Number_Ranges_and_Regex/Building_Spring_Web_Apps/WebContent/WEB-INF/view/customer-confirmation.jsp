<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<title>Customer Confirmation Form</title>
</head>

<body>
	<h2>The Customer is confirmed: ${customer.firstName}
		${customer.lastName}</h2>
	<br>
	<h2>Free Passes: ${customer.freePasses}</h2>
	<br>
	<h2>Postal Code: ${customer.postalCode}</h2>
	<br>
</body>
</html>
