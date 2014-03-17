<%-- 
    Document   : account-edit
    Created on : 10-03-2014, 13:25:01
    Author     : Hanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account edit</title>
    </head>
    <body>
        <style>

            label{

                float: left;
                width: 110px;
            }

        </style>
        <h1>Account edit</h1>
        <hr>
        <form action="Controller"> 
            <label> Cpr</label> <input type="text" name="cpr"> <br>
            <label> Account Number</label> <input type="text" name="accountNumber"> <br>
            <label> Interest</label> <input type="text" name="interest"><br>
            <input type="submit" name="submit" value="Add account">
            <input type="hidden" name="command" value="createCheckingAccount">

        </form>

    </body>
</html>
