
Bank Management System:-

This project is a web-based Bank Management System that allows users to manage customer records. The application supports adding, updating, viewing, deleting, and searching customer details, enhancing banking operations efficiency.

Features:-

Add New Customer:
Form-based interface for adding new customer records.

Update Customer Details:
Allows modification of existing customer information.

View Customer Details:
Displays customer information in a user-friendly card format.

Delete Customer:
Deletes specific customer records, including related accounts and loans.

Search Customer:
Enables searching for customers based on their ID.

Technologies Used

Frontend: HTML, CSS  
Backend: JSP, Servlets, Java  
Database: MySQL

File Structure:-

JSP Files:
customer.jsp: Displays a list of all customers.
add_customer.jsp: Form for adding new customers.
update_customer.jsp: Form for updating existing customer details.
delete_customer.jsp: Lists customers with an option to delete.
search_customer.jsp: Allows searching by customer ID.

Servlets:
AddCustomerServlet.java: Processes adding new customer records.
UpdateCustomerServlet.java: Handles updates to customer information.
DeleteCustomerServlet.java: Deletes customer records and related data.
SearchCustomerServlet.java: Searches and displays customer details by ID.

HTML File:
login.html: User login page to access the Bank Management System.

Database Configuration:-

Database Name: ss  
Tables:
Customer: Stores customer details such as ID, name, address, phone, and email.

Note: Database credentials are configured in each JSP and Servlet file as follows:
URL: jdbc:mysql://localhost:3306/ss  
Username: your_username
Password: your_password

Getting Started:_

1. Setup Database: Ensure MySQL is running and set up the ss database with the necessary tables.
2. Deploy Application: Deploy the application on a servlet container (e.g., Apache Tomcat).
3. Access Pages: Start with login.html and proceed to the various JSP pages to manage customer data.

