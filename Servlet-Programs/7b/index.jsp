<%@ page language="java" %>
<html>
<body>

<h2>Cookie Management</h2>

<form action="addCookie.jsp" method="post">
    Name: <input type="text" name="name" required><br><br>
    Domain: <input type="text" name="domain" required><br><br>
    Max Age (sec): <input type="number" name="age" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

</body>
</html>