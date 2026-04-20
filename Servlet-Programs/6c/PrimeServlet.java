/*6c. Build a servlet program to check the given number is prime number or not using HTML with step by
step procedure.*/


package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML Form inside servlet
        out.println("<html><body>");
        out.println("<h2>Prime Number Checker</h2>");
        out.println("<form action='PrimeServlet' method='post'>");
        out.println("Enter Number: <input type='number' name='num' required>");
        out.println("<input type='submit' value='Check'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));

        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        out.println("<html><body>");
        out.println("<h2>Prime Number Result</h2>");

        if (isPrime) {
            out.println("<h3 style='color:green;'>" + num + " is a Prime Number</h3>");
        } else {
            out.println("<h3 style='color:red;'>" + num + " is NOT a Prime Number</h3>");
        }

        out.println("<br><a href='PrimeServlet'>Check another number</a>");
        out.println("</body></html>");
    }
}