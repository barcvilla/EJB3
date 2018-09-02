<%-- 
    Document   : customerOrders
    Created on : 01/09/2018, 23:54:01
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders by Customers</title>
    </head>
    <body>
        <h1>Orders</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Order Id</th>
                <th>Order Date</th>
                <th>Order Total</th>
                <th>Order Status</th>
            </tr>
            <c:forEach var="customerOrder" items="${customerOrders}">
                <tr>
                    <td>${customerOrder.id}</td>
                    <td>${customerOrder.creationDate}</td>
                    <td>${customerOrder.total}</td>
                    <td>${customerOrder.status}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
