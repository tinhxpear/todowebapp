<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Welcome to ${userName}</h1>
        <hr>
        <p>Name: ${userName}</p>
        <p><a href="list-todos">Manage your to do list</a></p>
    </div>
  </body>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</html>
