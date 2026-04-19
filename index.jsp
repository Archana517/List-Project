<%@ page language="java" contentType="text/html" %>
<html>
<body>

<h2>Session Management</h2>

<form action="welcome.jsp" method="post">
    Enter your name:
    <input type="text" name="username" required>
    <br><br>

    Session time (in minutes):
    <input type="number" name="time" required>
    <br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>