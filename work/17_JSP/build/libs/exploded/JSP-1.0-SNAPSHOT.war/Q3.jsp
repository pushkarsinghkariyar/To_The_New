<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: pushkar
  Date: 7/3/18
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username= request.getParameter("username");
    String password= request.getParameter("password");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "ttn");

        PreparedStatement stmt= conn.prepareStatement("insert into login values (?,?)");

        stmt.setString(1,username);
        stmt.setString(2,password);

        stmt.executeUpdate();

        conn.close();
        response.sendRedirect("login.jsp");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
