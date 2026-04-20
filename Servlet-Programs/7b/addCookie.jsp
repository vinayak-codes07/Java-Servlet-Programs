<%@ page import="javax.servlet.http.*,java.net.*" %>
<html>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    // Encode name (avoid space error)
    String encodedName = URLEncoder.encode(name, "UTF-8");

    Cookie cookie = new Cookie("user", encodedName);

    // Set domain (optional, may not work in localhost)
    cookie.setDomain(domain);

    // Set expiry
    cookie.setMaxAge(age);

    // Add cookie
    response.addCookie(cookie);
%>

<h2>Cookie Created Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= age %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>