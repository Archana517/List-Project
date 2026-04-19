package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/FirstServlet")   // URL mapping
public class FirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // doGet method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");

        // Get writer
        PrintWriter out = response.getWriter();

        // HTML output
        out.println("<html><body>");
        out.println("<h2 style='color:blue;'>Hello World!!!</h2>");
        out.println("<p style='color:magenta;'>The server time is: "
                + new Date() + "</p>");
        out.println("</body></html>");
    }

    // doPost method
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}