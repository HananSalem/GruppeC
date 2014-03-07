
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer edit</title>
    </head>
    <body>
        <h1>Transfer edit</h1>
        
        <form action="Controller" method="post"> 
            Amount: <input type ="text" name="amount" value="">
            Source: <input type="text" name="source" value="">
            Target: <input type="text" name="target" value="">
            <input type ="hidden" name="cpr" value="${cpr}">
            <input type ="hidden" name="command" value="transfer-amount">
            <input type="submit" name="ok" value="Accept">
       
        </form>   
            <a href="Controller?command=customer-accounts&cpr=${cpr}">Customer accounts</a>
            
    </body>
</html>
