

<%@page import="jeelibrary.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Student</title>
    </head>
    <body>
        <h1>Edit Student</h1>
        
        <jsp:include page="/WEB-INF/views/commons/menu.jsp" />
        
        <% Student student = (Student)request.getAttribute("student"); %>
        <form method="post">
            <input name="id" type="hidden" value="<%= student.getId() %>" /><br />
            <label>Name:</label><input name="name" type="text" required="required" value="<%= student.getName() %>" /><br />
            <label>Last Name:</label><input name="lastName" type="text" required="required" value="<%= student.getLastName() %>" /><br />
            <label>Carrer</label>
            <select name="carrer" id="carrer">
                <option value="Ingeniería en Software">Ingeniería en Software</option>
                <option value="Ingeniería en Computación">Ingeniería en Computación</option>
                <option value="Ingeniería en Telecomunicaciones">Ingeniería en Telecomunicaciones</option>
                <option value="Licenciatura en Informática">Licenciatura en Informática</option>
            </select>
            <br /><br />
            <input type="submit" value="Update" />
        </form>
    </body>
    
    <script type="text/javascript">
        document.getElementById("carrer").value = "<%= student.getCarrer() %>";
    </script>
</html>
