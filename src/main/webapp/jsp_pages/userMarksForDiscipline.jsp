{% extends '../layout/layout.html' %}
<%@ page import="java.util.List" %>
<%@ page import="entities.Marks" %><%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 24.06.2022
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Packs</title>
</head>
<body>
<input type="hidden" name="command" value="getUserMarksForDiscipline" />
<div>
    <%
        List<Marks> marks = (List<Marks>) request.getAttribute("userMarksForDiscipline");
        if (marks == null) {
            out.println("<p>MARKS NOT FOUND</p>");
            return;
        }
        for (int i = 0; i < marks.size(); i++) {
            out.println("<p>"+i+") "+marks.get(i)+"</p>");
        }
    %>
</div>
</body>
</html>