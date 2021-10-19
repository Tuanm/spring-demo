<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Hi!</h1>
    <div>
        <% String responseMessage = (String) request.getAttribute("responseMessage"); %>
        <%= responseMessage == null ? "" : responseMessage %>
    </div>
    <div>
        <form>
            <p>Name: <%= request.getAttribute("name") %></p>
            <p>Email: <%= request.getAttribute("email") %></p>
            <p>Birthday: <%= request.getAttribute("birthday") %></p>
        </form>
    </div>
</body>
</html>
