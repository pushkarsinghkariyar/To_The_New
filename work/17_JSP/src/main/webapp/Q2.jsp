<%--
  Created by IntelliJ IDEA.
  User: pushkar
  Date: 7/3/18
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Q2</title>
</head>
<body>
<form action="Q2.jsp" method="post">
Enter the number: <input type="text" name="num">
<input type="submit" name="Submit" value="Submit">
</form>
<%
    System.out.println("THIS IS REQ" + request.getParameter("num"));
    Integer num1;
    if(request.getParameter("num") != null) {
        num1 = Integer.parseInt(request.getParameter("num"));
        for (Integer i = 1; i <= num1; i++)
            out.print(i + " ");
    }
    %>
</body>
</html>
