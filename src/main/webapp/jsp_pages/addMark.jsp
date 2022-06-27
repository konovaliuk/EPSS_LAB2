<%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 25.06.2022
  Time: 01:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add mark</title>
</head>
<body>
<main>
    <form action="" method="POST">
        <%String message = (String) request.getAttribute("message");
            if (message == null) {
                message="";
            }%>
        <input type="hidden" name="command" value="addMark"/>
        Amount: <input type="text" name="amount"/> <br>
        Type: <input type="password" name="type"/> <br>
        Description: <input type="text" name="description"/> <br>
        Student_Id: <input type="password" name="studentId"/> <br>
        Teacher_Id: <input type="text" name="teacherId"/> <br>
        Discipline_Id: <input type="text" name="disciplineId"/> <br>


        <p  style="color: red; font-size: 14px">
            <%=message%>
        </p>
        <input type="submit" class="form-submit-button"/>
    </form>
</main>
</body>
</html>