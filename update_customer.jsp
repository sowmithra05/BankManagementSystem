<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
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
    <h1>Update Customer</h1>
      <form action="/final/UpdateCustomerServlet" method="post">


        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" required><br>
        <label for="customerName">Name:</label>
        <input type="text" id="customerName" name="customerName" required><br>
        <label for="customerAddress">Address:</label>
        <input type="text" id="customerAddress" name="customerAddress" required><br>
        <label for="phoneNumber">Phone:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit" value="Update Customer">
    </form>
</body>
</html>
