<%-- 
    Document   : shoppingList
    Created on : Feb 10, 2020, 10:51:22 PM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <form method="POST">
        <h1>Shopping List</h1>
        Hello, ${userName} <a href="register.jsp">Logout</a>
        <h2>List</h2>
        Add item:<input type="text" name="addItem"/>
        <input type="submit" value="Add"/>
        <form/>
    </body>
</html>
