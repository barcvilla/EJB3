<%-- 
    Document   : shoppingCartItems
    Created on : 26/08/2018, 00:30:44
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppingCart Test</title>
    </head>
    <body>
        <h1>ShoppingCart Lookup</h1>
        <br/>
        <ul>
            <c:forEach varStatus="status" var="cartItem" items="${cartItems}" >
                <li>${cartItem}</li>
            </c:forEach>
        </ul>
    </body>
</html>
