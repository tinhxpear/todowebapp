<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>List To Do Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h2>Todos of ${userName}</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="toDo">
                    <tr>
                        <td>${toDo.description}</td>
                        <td>${toDo.targetDate}</td>
                        <td>${toDo.done}</td>
                        <td><a href="update-todo?id=${toDo.id}" class="btn btn-warning">UPDATE</a></td>
                        <td><a href="delete-todo?id=${toDo.id}" class="btn btn-danger">DELETE</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="add-todo" class="btn btn-primary">Add To Do</a></p>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
