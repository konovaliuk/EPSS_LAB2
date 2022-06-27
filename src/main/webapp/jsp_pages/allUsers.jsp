{% extends '../layout/layout.html' %}
<%@ page import="java.util.List" %>
<%@ page import="entities.User" %><%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 24.06.2022
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Packs</title>
</head>
<body>
<input type="hidden" name="command" value="getAllUsers" />
<div>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users == null) {
            out.println("<p>USERS NOT FOUND</p>");
            return;
        }
        for (int i = 0; i < users.size(); i++) {
            out.println("<p>"+i+") "+users.get(i)+"</p>");
        }
    %>
</div>
</body>
</html>