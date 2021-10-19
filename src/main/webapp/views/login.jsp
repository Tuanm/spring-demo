<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login first.</h1>
    <div>
        <% String responseMessage = (String) request.getAttribute("responseMessage"); %>
        <%= responseMessage == null ? "" : responseMessage %>
    </div>
    <div>
        <form action="/login" method="POST">
            <table>
                <tr>
                    <th>Username</th>
                    <td>
                        <input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td>
                        <input type="password" name="password">
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <p>
            Don't have an account? <a href="/register">Create one!</a>
        </p>
    </div>
</body>
</html>
