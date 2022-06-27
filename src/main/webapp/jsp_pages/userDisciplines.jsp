{% extends '../layout/layout.html' %}
<%@ page import="java.util.List" %>
<%@ page import="entities.UserDiscipline" %><%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 23.06.2022
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Packs</title>
</head>
<body>
<input type="hidden" name="command" value="getAllUserDisciplines" />
<div>
    <%
        List<UserDiscipline> userDisciplines = (List<UserDiscipline>) request.getAttribute("userDisciplines");
        if (userDisciplines == null) {
            out.println("<p>DISCIPLINES NOT FOUND</p>");
            return;
        }
        for (int i = 0; i < userDisciplines.size(); i++) {
            out.println("<p>"+i+") "+userDisciplines.get(i)+"</p>");
        }
    %>
</div>
</body>
</html>