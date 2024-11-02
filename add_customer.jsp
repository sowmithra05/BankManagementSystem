<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Customer</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
        h1 { color: #333; }
        form { background: #fff; border: 1px solid #ccc; border-radius: 5px; padding: 15px; }
        label { display: block; margin-bottom: 10px; }
        input[type="text"], input[type="email"], input[type="submit"] {
            width: 100%; padding: 10px; margin: 5px 0 15px; border-radius: 4px; border: 1px solid #ccc;
        }
        input[type="submit"] { background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        input[type="submit"]:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <h1>Add New Customer</h1>
    <form action="/final/AddCustomerServlet" method="post">
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required>

        <label for="customerAddress">Customer Address:</label>
        <input type="text" id="customerAddress" name="customerAddress" required>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <input type="submit" value="Add Customer">
    </form>
</body>
</html>
