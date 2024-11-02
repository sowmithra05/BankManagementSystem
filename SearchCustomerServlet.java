import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchCustomer")
public class SearchCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ss";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "9865@sowmi";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String customerId = request.getParameter("customerId");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM customer WHERE CustomerID = " + customerId;
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("CustomerName");
                String address = rs.getString("CustomerAddress");
                String phone = rs.getString("PhoneNumber");
                String email = rs.getString("Email");

                out.println("<h1>Customer Found:</h1>");
                out.println("<p>Customer ID: " + id + "</p>");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Address: " + address + "</p>");
                out.println("<p>Phone: " + phone + "</p>");
                out.println("<p>Email: " + email + "</p>");
            } else {
                out.println("<h1>No Customer Found with ID: " + customerId + "</h1>");
            }
        } catch (SQLException e) {
            out.println("<h1>Error searching customer:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            out.println("<h1>Error loading driver:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                out.println("<h1>Failed to close the connection</h1>");
                out.println("<p>" + e.getMessage() + "</p>");
            }
        }
    }
}
