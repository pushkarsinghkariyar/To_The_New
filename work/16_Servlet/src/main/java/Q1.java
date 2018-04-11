import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.out;

public class Q1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is GET method redirecting to index.php");
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is POST method");
        PrintWriter pw= resp.getWriter();
        String username= req.getParameter("username");
        String password= req.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "ttn");

            PreparedStatement stmt= conn.prepareStatement("select * from login where username=? and password=?");

            stmt.setString(1,username);
            stmt.setString(2,password);

            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                resp.sendRedirect("welcome.jsp");
                return;
            }
            resp.sendRedirect("invalid.jsp");
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
