<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add To Do Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
  </head>
  <body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h2>Enter Todo Details</h2>
        <form:form method="POST" modelAttribute="toDo">
            <fieldset class="mb-3">
                <form:label path="description">Description: </form:label>
                <form:input type="text" path="description" required="required" />
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetDate">Target Date: </form:label>
                <form:input type="text" path="targetDate" required="required" />
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden" path="id" />
            <form:input type="hidden" path="done" />

            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
    	$('#targetDate').datepicker({
    	    format: 'yyyy-mm-dd'
    	});
    </script>
  </body>
</html>
