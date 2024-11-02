<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Customer</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
        h1 { color: #333; }
        form { background: #fff; border: 1px solid #ccc; border-radius: 5px; padding: 15px; }
        label { display: block; margin-bottom: 10px; }
        input[type="text"], input[type="submit"] {
            width: 100%; padding: 10px; margin: 5px 0 15px; border-radius: 4px; border: 1px solid #ccc;
        }
        input[type="submit"] { background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        input[type="submit"]:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <h1>Search Customer</h1>
    <form action="/final/SearchCustomer" method="post">
        <label for="customerId">Enter Customer ID to Search:</label>
        <input type="text" id="customerId" name="customerId" required>
        <input type="submit" value="Search Customer">
    </form>
</body>
</html>
