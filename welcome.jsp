<%@ page language="java" contentType="text/html" %>
<html>
<body>

<%
    String name = request.getParameter("username");
    int minutes = Integer.parseInt(request.getParameter("time"));

    // Create session
    session.setAttribute("user", name);

    // Set session expiry (seconds)
    session.setMaxInactiveInterval(minutes * 60);
%>

<h2>Hello <%= name %>!</h2>

<p>Session time set to <%= minutes %> minutes</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>