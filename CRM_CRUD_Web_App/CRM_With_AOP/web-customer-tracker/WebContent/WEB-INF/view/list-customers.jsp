<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.luv2code.springdemo.util.SortUtils" %>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<c:url var="sortLinkFirstName" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
	</c:url>
	
	<c:url var="sortLinkLastName" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
	</c:url>
	
	<c:url var="sortLinkEmail" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
	</c:url>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

		<div id="container">
			<div id="content">

				<!-- put new Button: Add Customer -->
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />

				<form:form action="search" method="GET">
					Search Customer: <input type="text" name="theSearchName" />
					<input type="submit" value="Search" class="add-button" />
				</form:form>
				
				<table>
					<tr>
						<th> <a href="${sortLinkFirstName}"> First Name </a> </th>
						<th> <a href="${sortLinkLastName}"> Last Name </a> </th>
						<th> <a href="${sortLinkEmail}"> Email </a> </th>
						<th>Action</th>
					</tr>

					<c:forEach var="customer" items="${customers}">
						<!-- construct an update link -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
							<!-- customer ID is the ID of the customer in iteration -->
						</c:url>

						<!-- construct an delete link -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id}" />
							<!-- customer ID is the ID of the customer in iteration -->
						</c:url>

						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a href="${updateLink}"> Update </a> | <a
								href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"> Delete </a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>