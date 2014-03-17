<%-- 
    Document   : all-customer-accounts
    Created on : 11-03-2014, 09:35:07
    Author     : Hanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All customer-accounts</title>
    </head>
    <body>
        <h1>All customer-accounts</h1>
           <hr/>
        
        <c:forEach var="accounts" items="${accounts}">
            ${accounts.number}<br>
        </c:forEach>
     
    </body>
</html>
