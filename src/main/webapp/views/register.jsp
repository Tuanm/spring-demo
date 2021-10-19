<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Let's register an account for you!</h1>
    <div>
        <% String responseMessage = (String) request.getAttribute("responseMessage"); %>
        <%= responseMessage == null ? "" : responseMessage %>
    </div>
    <div>
        <form action="/register" method="POST">
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
                        <input type="text" name="password">
                    </td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>
                        <input type="email" name="email">
                    </td>
                </tr>
                <tr>
                    <th>Birthday</th>
                    <td>
                        <input type="date" name="birthday">
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Register">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <p>
            Already had an account? <a href="/login">Login!</a>
        </p>
    </div>
</body>
</html>
