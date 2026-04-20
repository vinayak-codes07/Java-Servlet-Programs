/*6a. Build a servlet program to find the factorial of a number using HTML with step by step procedure.*/
  package com.factorial;
 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numStr = request.getParameter("num");

        if (numStr == null || numStr.isEmpty()) {
            out.println("<h3 style='color:red;'>Please enter a number</h3>");
            return;
        }

        try {
            int n = Integer.parseInt(numStr);

            if (n < 0) {
                out.println("<h3 style='color:red;'>Factorial not defined for negative numbers</h3>");
                return;
            }

            long fact = 1;

            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }

            out.println("<html><body>");
            out.println("<h2>Factorial Result</h2>");
            out.println("<p>Number: " + n + "</p>");
            out.println("<p>Factorial: " + fact + "</p>");
            out.println("<br><a href='index.html'>Go Back</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Invalid input! Enter a valid number.</h3>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}