<%--
  Created by IntelliJ IDEA.
  User: animesh
  Date: 12/28/20
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="academy.learnprogramming.util.AttributeNames" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>

<html>
<head>
    <title>View Item</title>
</head>
<body>
<div align="center">
    <form:form method="GET" modelAttribute="${AttributeNames.VIEW_ITEM}">
        <table border="1" cellpadding="5">
            <caption><h2> View Item </h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Details</th>
                <th>Deadline</th>
            </tr>

            <tr>
                <td><form:input path="id" /></td>
                <td><form:input path="title" /></td>
                <td><form:input path="details" /></td>
                <td><form:input path="deadline" /></td>
            </tr>
        </table>
    </form:form>
    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <%--itemsLink points to the base url items--%>
    <h2> <a href="${itemsLink}"> Show Todo Items </a></h2>
</div>
</body>
</html>
