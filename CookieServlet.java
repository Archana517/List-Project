<!DOCTYPE html>
<html>
<head>
    <title>Cookie Demo</title>
</head>
<body>

<form action="CookieServlet" method="get">
    Enter your name:
    <input type="text" name="username" required>
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>


package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        int visitCount = 1;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry 30 minutes (1800 seconds)
        nameCookie.setMaxAge(1800);
        countCookie.setMaxAge(1800);

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // OUTPUT
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<h3>List of Cookies:</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

        // Show cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }
        }

        // Show current cookies also
        out.println("<tr><td>username</td><td>" + name + "</td></tr>");
        out.println("<tr><td>visitCount</td><td>" + visitCount + "</td></tr>");

        out.println("</table>");

        out.println("<br><b>Cookie Expiry Time: 30 minutes</b>");

        out.println("</body></html>");
    }
}