<%-- 
    Document   : customer-detail
    Created on : 10-03-2014, 12:00:01
    Author     : Hanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer detail</title>
    </head>
     <style>

        label{
            
            float: left;
            width: 110px;
  }

    </style>
    <body>
        <h1>Customer detail</h1>
        <hr>

        <label>Cpr:</label> ${customerDetail.cpr}  <br>
        <label>Title:</label> ${customerDetail.title} <br>
        <label>Firstname: </label>${customerDetail.firstName} <br>
        <label>LastName:</label> ${customerDetail.lastName} <br>
        <label>Street:</label> ${customerDetail.street}<br>
        <label>PostalCode:</label> ${customerDetail.postalCode} <br>
        <label>PostalDistrict: </label>${customerDetail.postalDistrict} <br>
        <label>Phone: </label>${customerDetail.phone} <br>
        <label>E-mail: </label>${customerDetail.email} <br>

    </body>
</html>
