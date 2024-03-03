<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 320px;
        }
        h1 {
            color: #333;
            margin-bottom: 10px;
        }
        p {
            color: #666;
            margin-bottom: 10px;
        }
        h3 {
            color: #666;
            font-style: italic;
            margin-bottom: 20px;
        }
        a {
            color: #337ab7;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
 <%
        // Retrieve the session object
        HttpSession session1 = request.getSession(false);

        // Check if the session is not null and the username attribute is set
        if (session1 != null && session1.getAttribute("username") != null) {
            // Get the username from the session
            String username = (String) session1.getAttribute("username");
    %>
   <div class="container">
        <h1>Welcome, <%= username %>!</h1>
        <p>you successfully login on our platform. 🌟</p>
        <h3>Explore, learn, and connect with me to know about this project 🚀</h3>
        <p>Feel free to stay as long as you like, and when you're ready,</p> 
        you can <a href="logout.jsp">LOGOUT</a> securely.
    </div>
     <%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("index.html");
        }
    %>
</body>
</html>
