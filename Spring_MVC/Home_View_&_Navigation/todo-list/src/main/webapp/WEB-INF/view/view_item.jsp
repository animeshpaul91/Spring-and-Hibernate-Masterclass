<%--
  Created by IntelliJ IDEA.
  User: animesh
  Date: 12/28/20
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>

<html>
<head>
    <title>View Item</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2> View Item </h2></caption>
        <tr>
            <td><Label>ID</Label></td>
            <td><c:out value="${viewItem.id}"/></td>
        </tr>
        <tr>
            <td><Label>Title</Label></td>
            <td><c:out value="${viewItem.title}"/></td>
        </tr>
        <tr>
            <td><Label>Details</Label></td>
            <td><c:out value="${viewItem.details}"/></td>
        </tr>
        <tr>
            <td><Label>Deadline</Label></td>
            <td><c:out value="${viewItem.deadline}"/></td>
        </tr>
    </table>
    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <%--itemsLink points to the base url items--%>
    <h2><a href="${itemsLink}"> Show Todo Items </a></h2>
</div>
</body>
</html>
