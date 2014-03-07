<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Details</title>
    </head>
    <link type="text/css" rel="stylesheet" href="CSS-main.css">
    <body>
        <h1>Account Details</h1>
        <hr/>

        <ul>
            <li> Account number: ${accountDetail.number} </li> 
            <li>  Type: ${accountDetail.type}  </li>
            <li> Interest: <fmt:formatNumber value="${accountDetail.interest}" groupingUsed="true" maxFractionDigits="3"/> </li> 
            <br/>
            Transfer:
            <table border="1">
                <tr><th> Date</th> <th> Amount</th> <th> Account Number</th></tr>

                <c:forEach var="accountDetails" items="${accountDetail.transfers}" >
                    
                    <tr> 

                        <td> <fmt:formatDate pattern="yy-MM-dd" value="${accountDetails.date}"/> </td> 
                        <td> ${accountDetails.amount} </td>
                        <td>  ${accountDetails.accountNumber}</td>

                    </tr>
                </c:forEach>
            </table>
        </ul>

            
            <a href="Controller?command=back">Back to main page</a> <a href="Controller?command=prepare-transfer&cpr=${cpr}"> Go to transfer</a>
    </body>
</html>
