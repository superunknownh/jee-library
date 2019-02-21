<%@page import="jeelibrary.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Students</title>
    </head>
    <body>
        <h1>Students</h1>
        
        <jsp:include page="/WEB-INF/views/commons/menu.jsp" />
        
        <button onclick="window.location.href='students/add'">Add student</button>
        
        <br /><br />
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Carrer</th>
                <th>Options</th>
            </tr>
            <% Student[] students = (Student[])request.getAttribute("students"); %>
            <% for (Student student : students) { %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getLastName()%></td>
                <td><%= student.getCarrer()%></td>
                <td>
                    <a href="students/edit?id=<%= student.getId() %>">edit</a>
                    <a href="#" onclick="deleteStudent('<%= student.getId() %>')">delete</a>
                </td>
            </tr>
            <% } %>
        </table>
    </body>
    
    <script type="text/javascript">
        const deleteStudent = (id) => {
            const message = "Are you sure you want to delete the student with ID: '" + id +
                    "'?\n\nThis operation can't be undone.";
            if (confirm(message)) {
                window.location.href = 'students/delete?id=' + id;
            }
        }
    </script>
</html>
