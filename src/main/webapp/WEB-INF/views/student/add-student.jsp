
<%@page import="jeelibrary.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1>New Student</h1>
        
        <jsp:include page="/WEB-INF/views/commons/menu.jsp" />
        
        <form method="post">
            <label>ID:</label><input name="id" type="number" min="0" required="required" /><br />
            <label>Name:</label><input name="name" type="text" required="required" /><br />
            <label>Last Name:</label><input name="lastName" type="text" required="required" /><br />
            <label>Carrer</label>
            <select name="carrer">
                <option value="Ingeniería en Software">Ingeniería en Software</option>
                <option value="Ingeniería en Computación">Ingeniería en Computación</option>
                <option value="Ingeniería en Telecomunicaciones">Ingeniería en Telecomunicaciones</option>
                <option value="Licenciatura en Informática">Licenciatura en Informática</option>
            </select>
            <br /><br />
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
