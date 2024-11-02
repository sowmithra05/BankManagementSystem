import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ss";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "9865@sowmi";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String sql = "INSERT INTO customer (CustomerName, CustomerAddress, PhoneNumber, Email) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customerName);
            pstmt.setString(2, customerAddress);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, email);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h1>Customer Added Successfully!</h1>");
                out.println("<p>Name: " + customerName + "</p>");
                out.println("<p>Address: " + customerAddress + "</p>");
                out.println("<p>Phone: " + phoneNumber + "</p>");
                out.println("<p>Email: " + email + "</p>");
            } else {
                out.println("<h1>Failed to Add Customer</h1>");
            }
        } catch (SQLException e) {
            out.println("<h1>Error adding customer:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            out.println("<h1>Error loading driver:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                out.println("<h1>Failed to close the connection</h1>");
                out.println("<p>" + e.getMessage() + "</p>");
            }
        }
    }
}
