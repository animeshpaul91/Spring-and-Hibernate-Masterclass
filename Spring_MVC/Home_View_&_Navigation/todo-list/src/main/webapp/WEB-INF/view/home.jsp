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
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
    <%--itemsLink points to the base url items--%>
    <h2> <a href="${itemsLink}"> Show Todo Items </a></h2>
</div>
</body>
</html>
