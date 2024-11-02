<%@ page import="java.sql.*" %>
<%
    String url = "jdbc:mysql://localhost:3306/ss"; 
    String user = "root";
    String password = "9865@sowmi";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM customer");

        out.println("<html><head><title>Customer List</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }");
        out.println("h1 { color: #333; }");
        out.println(".customer-card { background: #fff; border: 1px solid #ccc; border-radius: 5px; padding: 15px; margin-bottom: 15px; }");
        out.println("</style></head><body>");
        out.println("<h1>Customer Details</h1>");

        while (rs.next()) {
            int customerId = rs.getInt("CustomerID");
            String customerName = rs.getString("CustomerName");
            String customerAddress = rs.getString("CustomerAddress");
            String phoneNumber = rs.getString("PhoneNumber");
            String email = rs.getString("Email");

            out.println("<div class='customer-card'>");
            out.println("<p><strong>Customer ID:</strong> " + customerId + "</p>");
            out.println("<p><strong>Name:</strong> " + customerName + "</p>");
            out.println("<p><strong>Address:</strong> " + customerAddress + "</p>");
            out.println("<p><strong>Phone:</strong> " + phoneNumber + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("</div>");
        }
        out.println("</body></html>");
    } catch (Exception e) {
        out.println("<h1>An error occurred:</h1>");
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
%>
