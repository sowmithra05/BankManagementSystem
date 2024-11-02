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

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
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
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Delete associated loans first
            String deleteLoansSQL = "DELETE FROM loan WHERE CustomerID = ?";
            pstmt = conn.prepareStatement(deleteLoansSQL);
            pstmt.setString(1, customerId);
            pstmt.executeUpdate();

            // Delete associated accounts
            String deleteAccountsSQL = "DELETE FROM account WHERE CustomerID = ?";
            pstmt = conn.prepareStatement(deleteAccountsSQL);
            pstmt.setString(1, customerId);
            pstmt.executeUpdate();

            // Now delete the customer
            String deleteCustomerSQL = "DELETE FROM customer WHERE CustomerID = ?";
            pstmt = conn.prepareStatement(deleteCustomerSQL);
            pstmt.setString(1, customerId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h1>Customer with ID " + customerId + " has been deleted successfully.</h1>");
            } else {
                out.println("<h1>No Customer found with ID: " + customerId + "</h1>");
            }
        } catch (SQLException e) {
            out.println("<h1>Error deleting customer:</h1>");
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
