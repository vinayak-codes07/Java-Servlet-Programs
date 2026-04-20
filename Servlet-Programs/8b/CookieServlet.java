/*8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) along with the list of cookies and its setvalues and demonstrate the
expiry of cookie also.*/



package com.cookieservlet;

import java.io.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        String name = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    name = URLDecoder.decode(c.getValue(), "UTF-8");
                }
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        out.println("<html><body>");

        if (name != null) {
            count++;

            Cookie nameCookie = new Cookie("username", URLEncoder.encode(name, "UTF-8"));
            Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

            // ⏳ Expiry demo (30 seconds)
            nameCookie.setMaxAge(30);
            countCookie.setMaxAge(30);

            response.addCookie(nameCookie);
            response.addCookie(countCookie);

            // Greeting
            out.println("<h2 style='color:blue;'>Welcome back " + name + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times.</h3>");

            // Display cookie list with values
            out.println("<h3>List of Cookies and Values:</h3>");

            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("<p>");
                    out.println("<b>Name:</b> " + c.getName() + "<br>");
                    out.println("<b>Value:</b> " + URLDecoder.decode(c.getValue(), "UTF-8") + "<br>");
                    out.println("</p>");
                }
            }

            out.println("<p style='color:red;'>Cookie expires in 30 seconds</p>");

        } else {
            // First visit
            out.println("<h2>Enter your name</h2>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("Name: <input type='text' name='username' required>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");

        // Encode to avoid space error
        String encodedName = URLEncoder.encode(name, "UTF-8");

        Cookie nameCookie = new Cookie("username", encodedName);
        Cookie countCookie = new Cookie("visitCount", "0");

        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        response.sendRedirect("CookieServlet");
    }
}