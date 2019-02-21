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

@WebServlet(name = "EditStudentServlet", urlPatterns = {"/students/edit"})
public class EditStudentServlet extends HttpServlet {

    public EditStudentServlet() {
        this.studentService = DatabaseStudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.get(id);
        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("/WEB-INF/views/student/edit-student.jsp").forward(request, response);
        }
        response.sendRedirect("/jee-library/students?error=404");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = getIncomingStudent(request);
        if (student != null) {
            this.studentService.update(student);
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
