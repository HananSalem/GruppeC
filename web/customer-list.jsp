
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="CSS-main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer list</title>
    </head>
    <body>
        <h1>Customer list</h1>
        <hr/>
        <c:forEach var="customer" items="${customers}">
            Kunde: <a href="Controller?command=customer-accounts&cpr=${customer.cpr}"> ${customer.cpr}</a>
            <br/>
        </c:forEach>

        </br> 
        </br>

        <a href="Controller?command=back">Back to main page</a>

    </body>
</html>
