import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ss"; // Corrected port
    private static final String JDBC_USER =" your_username";
    private static final String JDBC_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String customerId = request.getParameter("customerId");
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 Statement stmt = conn.createStatement()) {
                 
                String sql = "UPDATE customer SET CustomerName='" + customerName + "', CustomerAddress='" + customerAddress +
                             "', PhoneNumber='" + phoneNumber + "', Email='" + email + "' WHERE CustomerID=" + customerId;
                int rowsAffected = stmt.executeUpdate(sql);
                
                if (rowsAffected > 0) {
                    out.println("<h1>Customer Updated Successfully!</h1>");
                } else {
                    out.println("<h1>Customer Not Found!</h1>");
                }
            }
        } catch (SQLException e) {
            out.println("<h1>Error updating customer:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            out.println("<h1>Error loading driver:</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
