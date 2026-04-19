<!DOCTYPE html>
<html>
<head>
    <title>Prime Number Check</title>
</head>
<body>

<h2>Check Prime Number</h2>

<form action="PrimeServlet" method="post">
    Enter Number: <input type="text" name="num">
    <br><br>
    <input type="submit" value="Check">
</form>

</body>
</html>



package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(input);

            if (num <= 1) {
                out.println("<h3 style='color:red;'>Please enter number greater than 1</h3>");
            } else {
                boolean isPrime = true;

                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    out.println("<h2 style='color:green;'>" + num + " is a Prime Number</h2>");
                } else {
                    out.println("<h2 style='color:blue;'>" + num + " is NOT a Prime Number</h2>");
                }
            }

        } catch (Exception e) {
            // Error handling for invalid input
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Error Code
            out.println("<h3 style='color:red;'>Invalid Input! Please enter a valid number.</h3>");
        }

        out.println("</body></html>");
    }
}