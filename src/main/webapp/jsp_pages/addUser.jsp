<%--
  Created by IntelliJ IDEA.
  User: blasphem0us
  Date: 25.06.2022
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<main>
    <form action="" method="POST">
        <%String message = (String) request.getAttribute("message");
            if (message == null) {
                message="";
            }%>
        <input type="hidden" name="command" value="addUser"/>
        Username: <input type="text" name="email"/> <br>
        Password: <input type="password" name="password"/> <br>
        Role: <input type="text" name="role"/> <br>
        Name: <input type="password" name="name"/> <br>
        Surname: <input type="text" name="surname"/> <br>

        <p  style="color: red; font-size: 14px">
            <%=message%>
        </p>
        <input type="submit" class="form-submit-button"/>
    </form>
</main>
</body>
</html>