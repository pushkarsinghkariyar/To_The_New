<%! String str; %>
<%
    str= (String)session.getAttribute("key");
    if(str==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p> <%= str%> HAS SUCCESSFULLY LOGGED IN </p>
<br><br>
<a href="invalid.jsp">CLICK HERE TO LOGOUT</a>
</body>
</html>