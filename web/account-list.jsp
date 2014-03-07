<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account list</title>
  </head>
      <link type="text/css" rel="stylesheet" href="CSS-main.css">
  <body>
    <h1>Account list</h1>
    
    <hr/>
   
    <c:forEach var="account" items="${customerAccounts}">
      <br/><a href ="Controller?command=account-detail&number=${account.number}"> ${account.number}</a> ${account.type}
    </c:forEach>

      </br>
      </br>

      <a href="Controller?command=back">Back to main page</a> 
    
</html>
