/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP
called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all
the fields with server sided validation and display all the data along with result ( Pass if all subjects
greater than 40%) and Average marks through result.jsp with a link to move to the client side*/


package com.result;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String roll = request.getParameter("rollno");
        String name = request.getParameter("name");

        String p1 = request.getParameter("s1");
        String p2 = request.getParameter("s2");
        String p3 = request.getParameter("s3");
        String p4 = request.getParameter("s4");
        String p5 = request.getParameter("s5");

        // Validation
        if (roll.isEmpty() || name.isEmpty() ||
            p1.isEmpty() || p2.isEmpty() || p3.isEmpty() || p4.isEmpty() || p5.isEmpty()) {

            response.getWriter().println("<h3 style='color:red;'>All fields are required!</h3>");
            return;
        }

        try {
            int s1 = Integer.parseInt(p1);
            int s2 = Integer.parseInt(p2);
            int s3 = Integer.parseInt(p3);
            int s4 = Integer.parseInt(p4);
            int s5 = Integer.parseInt(p5);

            int[] marks = {s1, s2, s3, s4, s5};

            for (int m : marks) {
                if (m < 0 || m > 100) {
                    response.getWriter().println("<h3 style='color:red;'>Marks must be 0-100</h3>");
                    return;
                }
            }

            int total = s1 + s2 + s3 + s4 + s5;
            double avg = total / 5.0;

            boolean pass = true;
            for (int m : marks) {
                if (m < 40) {
                    pass = false;
                    break;
                }
            }

            String result = pass ? "PASS" : "FAIL";

            request.setAttribute("roll", roll);
            request.setAttribute("name", name);
            request.setAttribute("s1", s1);
            request.setAttribute("s2", s2);
            request.setAttribute("s3", s3);
            request.setAttribute("s4", s4);
            request.setAttribute("s5", s5);
            request.setAttribute("avg", avg);
            request.setAttribute("result", result);

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            response.getWriter().println("<h3 style='color:red;'>Invalid Input!</h3>");
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