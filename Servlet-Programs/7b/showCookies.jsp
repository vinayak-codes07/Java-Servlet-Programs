<%@ page import="javax.servlet.http.*,java.net.*" %>
<html>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            String name = c.getName();
            String value = URLDecoder.decode(c.getValue(), "UTF-8");
%>
            <p>
                <b>Name:</b> <%= name %> <br>
                <b>Value:</b> <%= value %> <br><br>
            </p>
<%
        }
    } else {
%>
    <p>No active cookies found.</p>
<%
    }
%>

<br>
<a href="index.jsp">Back</a>

</body>
</html>