<%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 22.06.2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
{% extends '../layout/layout.html' %}
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Educational Process Support System</title>

</head>

<body>
<header>
    <a href="${pageContext.request.contextPath}?command=logout" class="header-button right" >Logout</a>
</header>

<main>

    <div class="main-menu">
        <a class="menu-button top-button" href="${pageContext.request.contextPath}?command=main">Home</a> <br>
        <a class="menu-button" href="${pageContext.request.contextPath}?command=getUserDisciplines">My disciplines</a> <br>
    </div>
</main>
</body>
</html>