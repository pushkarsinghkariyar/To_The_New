<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: pushkar
  Date: 7/3/18
  Time: 2:59 PM
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

        PreparedStatement stmt= conn.prepareStatement("select * from login where username=? and password=?");

        stmt.setString(1,username);
        stmt.setString(2,password);

        ResultSet rs=stmt.executeQuery();

        while(rs.next()){
            HttpSession session1= request.getSession(true);
            session1.setAttribute("key",username);
            response.sendRedirect("logout.jsp");
            conn.close();
            return;
        }
        response.sendRedirect("login.jsp");
        return;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
