<%-- 
    Document   : register
    Created on : Feb 10, 2020, 10:39:34 PM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST">
            Username:<input type="text" name="userName"/>
            <input type="hidden" name="userAction" value="register">
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
