<%-- 
    Document   : customer-edit
    Created on : 09-03-2014, 20:27:13
    Author     : Hanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer edit</title>
    </head>
    <body>
        
         <style>

        label{
            
            float: left;
            width: 110px;
  }

    </style>
        <h1>Customer edit</h1>
        <hr/>

        <form action="Controller"> 
            <label>CPR number</label><input type="text" name="cpr" value=""> <br>
            <label>Title</label><input type="text" name="title" value=""> <br>
            <label>Firstname</label><input type="text" name="firstName" value=""> <br>
            <label>Lastname</label><input type="text" name="lastName" value=""> <br>
            <label>Street</label><input type="text" name="street" value=""> <br>
            <label>Postal Code</label><input type="text" name="postalCode" value=""> <br>
            <label>Postal District</label><input type="text" name="postalDistrict" value=""> <br>
            <label>Phone</label><input type="text" name="phone" value=""> <br>
            <label>E-mail</label><input type="text" name="email" value=""><br>
            <input type="submit" name="submit" value="OK">
            <input type="hidden" name="command" value="create-customer">
            
        </form>
    </body>
</html>
