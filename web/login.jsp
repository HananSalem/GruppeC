<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
      label {display: block;width: 8em;text-align: left;float: left;}
      #login {margin-left: auto;margin-right:auto ;margin-top :2em;width:20em;}
    </style>
    <title>Login Page</title>
  </head>
  <body>
   
      <form method="POST" action="Controller">
        <div><label>Cpr</label> <input type="text" name="cpr" id="cpr"></div>
        <div><label> Password</label> <input type="password" name="password" id="password"></div>
        <input type='submit' value='login'/>
        <input type='hidden' name="command" value='login'/>  <!-- dette er ligesom når man skriver  action="Controller?command=login". Der er to forskellige måder at sende parametre -->
      </form>
      <p style='color:red'>${loginerror}</p>
    
  </body>
</html>