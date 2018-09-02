<%-- 
    Document   : customerlist
    Created on : 01/09/2018, 20:44:49
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Management System</title>
    </head>
    <body>
        <h1>Customer List</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Direcion. Envio</th>
                <th>Email</th>
                <th>Direc. Facturacion</th>
                <th>Acciones</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.shippingAddress}</td>
                    <td>${customer.email}</td>
                    <td>${customer.billingAddress}</td>
                    <td><a href="CustomerController?accion=verPedidos&customer=${customer}">ver pedidos</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
