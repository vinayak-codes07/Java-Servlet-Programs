<%@ page language="java" %>
<html>
<head>
    <title>Student Result</title>

    <script>
        function validateForm() {
            let f = document.forms["form"];

            if (f["rollno"].value === "" || f["name"].value === "") {
                alert("Roll No and Name required");
                return false;
            }

            for (let i = 1; i <= 5; i++) {
                let m = f["s" + i].value;

                if (m === "") {
                    alert("All marks are required");
                    return false;
                }

                if (m < 0 || m > 100) {
                    alert("Marks must be between 0 and 100");
                    return false;
                }
            }

            return true;
        }
    </script>
</head>
<body>

<h2>Student Result Form</h2>

<form name="form" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno"><br><br>
    Name: <input type="text" name="name"><br><br>

    Sub1: <input type="number" name="s1" required><br><br>
    Sub2: <input type="number" name="s2" required><br><br>
    Sub3: <input type="number" name="s3" required><br><br>
    Sub4: <input type="number" name="s4" required><br><br>
    Sub5: <input type="number" name="s5" required><br><br>

    <input type="submit" value="Calculate Result">
</form>

</body>
</html>