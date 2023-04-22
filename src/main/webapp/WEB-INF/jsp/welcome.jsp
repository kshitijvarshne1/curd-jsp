<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Our Site</title>
    <style>
        /* Add styles to the navbar */
        .navbar {
            background-color: red;
            overflow: hidden;
        }

        /* Style the links inside the navbar */
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        /* Change the color of links on hover */
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Add a color to the active/current link */
        .navbar a.active {
            background-color: #4CAF50;
            color: white;
        }

        /* Center the page content */
        .content {
            padding: 50px;
            text-align: center;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        button {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<!-- Add the navbar -->
<div class="navbar" style="display: flex;flex-direction: row; justify-content: space-between">
    <div>
        <a class="active" href="welcome">Main Page</a>
    </div>
    <div>
        <a class="active" href="login">Log Out</a>
    </div>
</div>

<!-- Add the page content -->
<!-- Add the page content -->
<div style="display: flex; justify-content: center; text-align: center">
    <h1>List of Users...</h1>
</div>
<table>
    <tr>
        <th>S.No</th>
        <th>Picture</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Operation</th>
        <th>Operation</th>
    </tr>
    <%
        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/crudJsp";
        String user = "kshitijdb";
        String password = "root@123";
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery("SELECT * FROM crudJsp.user");
        int i = 1;
        while (rs2.next()) {
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td><img src=https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2f9zGL0ATdsgzW04B8ADbUAhNsSQmE-FqBM4BjonDfw&usqp=CAU&ec=48600112" + " width=\"100\" height=\"100\"></td>");
            out.println("<td>" + rs2.getString("name") + "</td>");
            out.println("<td>" + rs2.getString("email") + "</td>");
            out.println("<td>" + rs2.getString("phone_number") + "</td>");
            // add a button to update the quantity
            // add Two buttons to update the quantity and delete the product
            out.println("<td><button type=\"button\" onclick=\"location.href='delete?id=" + rs2.getString("id") + "'\">Delete User</button></td>");
            out.println("<td><button type=\"button\" onclick=\"location.href='update?id=" + rs2.getString("id") + "'\">Update User</button></td>");
            out.println("</tr>");
            i++;
        }
        conn.close();
    %>
</table>

</body>
</html>
