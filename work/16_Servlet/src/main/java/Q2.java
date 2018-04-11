import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Q2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is GET method redirecting to index.bhp");
        resp.sendRedirect("index.jsp");
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw= resp.getWriter();
        Integer bid= Integer.parseInt(req.getParameter("bid"));
        String bcontent= req.getParameter("bcontent");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "ttn");

            PreparedStatement stmt= conn.prepareStatement("insert into blog values (?,?)");

            stmt.setInt(1,bid);
            stmt.setString(2,bcontent);

            Integer rs=stmt.executeUpdate();

            if(rs!=0)
                System.out.println("INSERTION SUCCESSFULL");
            else
                System.out.println("INSERTION NOT SUCCESSFULL");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
