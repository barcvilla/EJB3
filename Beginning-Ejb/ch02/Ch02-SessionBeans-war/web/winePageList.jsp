<%-- 
    Document   : winePageList
    Created on : 25/08/2018, 22:27:24
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wine List Result</title>
    </head>
    <body>
        <h1>Wine List Result</h1>
        <br/>
        <ul>
            <c:forEach varStatus="status" var="wine" items="${wineList}" >
                <li>${wine}</li>
            </c:forEach>
        </ul>
        <br/>
        <br/>
        <h4>Imprimiendo el conteo de buscadores luego de incrementarlo... ${shopper}</h4>
    </body>
</html>
