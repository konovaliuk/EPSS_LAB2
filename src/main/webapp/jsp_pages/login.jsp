<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
{% extends '../layout/layout_for_login.html' %}
<h1 style="position:relative;left:20px">Login</h1>
<link rel="stylesheet" href="../css/login.css">


<form action="" class="col-4"  method="POST">
    <%String message = (String) request.getAttribute("message");
        if (message == null) {
            message="";
        }%>
    <div class="form-group">
        <label >Email</label>
        <input size="20" type="email"  required name="email" class="form-control">

    </div>
    <p></p>
    <div class="form-group">
        <label style="position:relative;left:-15px" >Password</label>
        <input style="position:relative; left:-15px" type="password" required name="password" class="form-control" >
    </div>
    <p></p>
    <%=message%>
    <p></p>
    <button style="position:relative; left:20px " type="submit" class="btn btn-primary">Log in</button>
</form>

</html>