package jeelibrary.servlets.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeelibrary.interfaces.IStudentService;
import jeelibrary.models.Student;
import jeelibrary.services.DatabaseStudentService;

@WebServlet(name = "AddStudentServlet", urlPatterns = {"/students/add"})
public class AddStudentServlet extends HttpServlet {

    public AddStudentServlet() {
        this.studentService = DatabaseStudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/student/add-student.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student newStudent = getIncomingStudent(request);
        if (newStudent != null) {
            this.studentService.add(newStudent);
            response.sendRedirect("/jee-library/students");
        } else {
            response.sendRedirect("/jee-library/student/add?error=Error");
        }
    }
    
    private Student getIncomingStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String carrer = request.getParameter("carrer");
        Student newStudent = new Student(id, name, lastName, carrer);
        return newStudent;
    }

    private final IStudentService studentService;

}
