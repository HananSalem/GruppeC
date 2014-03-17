<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central bank</title>
    </head>
    <link type="text/css" rel="stylesheet" href="CSS-main.css">
    <body>
        <h1>Central bank</h1>
        <hr/>

        <h3> Content </h3>

        <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
        <li><a href="Controller?command=customer-accounts">Customer accounts</a></li>
    </c:if > <!-- Efter man er logget ind: hvis du er Customer så vises dette link frem -->
    <c:if test="${pageContext.request.isUserInRole('AccountManager')==true}">
        <li><a href="Controller?command=showCreateCustomer">Create customer</a></li>
    </c:if > <!-- Efter man er logget ind: hvis du er AccountManager så vises dette link frem -->
    <c:if test="${pageContext.request.isUserInRole('AccountManager')==true}"> 
        <li><a href="Controller?command=list-customers">Customer list</a></li>
    </c:if > <!-- Efter man er logget ind: hvis du er AccountManager så vises dette link frem -->

    <c:if test="${pageContext.request.isUserInRole('AccountManager')== true}">
        <li><a href="Controller?command=showCreateAccount">Create New Account</a></li>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('AccountManager')== true}">
        <li><a href="Controller?command=">All the customers bankaccounts</a></li>
        </c:if>
        
        
        <li><a href="Controller?command=sayHello">hello</a></li>
 
        


    <c:choose >
        <c:when test="${pageContext.request.remoteUser== null}">
            <li><a href="Controller?command=showlogin">Go to Login</a>
            </c:when>
            <c:otherwise>
            <li><a href="Controller?command=logout">Log out</a></li>
            </c:otherwise> 
        </c:choose>


    <!-- linje 28: hvis du IKKE er logget ind så viser den et link der går til login -->
    <!-- linje 32 hvis du ER logget ind så viser den et link der kan gå til LOGOUT -->


</body>
</html>
