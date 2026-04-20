<%@ page import="java.util.*" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    // Set session expiry to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    // Store name in session
    if (name != null) {
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");
%>

<%
    if (user != null) {
%>

    <h2 style="color:blue;">Hello <%= user %>!</h2>

    <h3>Session Details</h3>
    <p>Session ID: <%= session.getId() %></p>
    <p>Creation Time: <%= new Date(session.getCreationTime()) %></p>
    <p>Last Access Time: <%= new Date(session.getLastAccessedTime()) %></p>

    <p style="color:red;">Session expires in 1 minute</p>

    <br>
    <a href="welcome.jsp">Refresh</a>

<%
    } else {
%>

    <h3 style="color:red;">Session expired! Please enter again.</h3>
    <a href="index.jsp">Go Back</a>

<%
    }
%>

</body>
</html>