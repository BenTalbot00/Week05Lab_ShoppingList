<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
        Hello, ${userName} <a href="/ShoppingList/ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        Add item:<input type="text" name="addItem"/>
        <input type="hidden" name="userAction" value="add">
        <input type="submit" value="Add"/>
        <form/>
        
        <form method="POST">
            <input type="hidden" name="userAction" value="delete">
            <c:forEach var="item" items="${itemList}" varStatus="status">
                <input type="radio" name="radSelect" value="${status.index}"/>${item}<br/> 
            </c:forEach>
                <c:if test="${items.size() > 0}">
                    <input type="submit" name="submit" value="delete"/>
                </c:if>
                
        </form>
    </body>
</html>
