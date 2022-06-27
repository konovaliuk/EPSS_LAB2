{% extends '../layout/layout.html' %}
<%@ page import="java.util.List" %>
<%@ page import="entities.Discipline" %><%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 24.06.2022
  Time: 02:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Packs</title>
</head>
<body>
<input type="hidden" name="command" value="getAllDisciplines" />
<div>
    <%
        List<Discipline> disciplines = (List<Discipline>) request.getAttribute("disciplines");
        if (disciplines == null) {
            out.println("<p>DISCIPLINES NOT FOUND</p>");
            return;
        }
        for (int i = 0; i < disciplines.size(); i++) {
            out.println("<p>"+i+") "+disciplines.get(i)+"</p>");
        }
    %>
</div>
</body>
</html>