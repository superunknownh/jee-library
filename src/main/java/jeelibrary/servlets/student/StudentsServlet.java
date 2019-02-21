package jeelibrary.servlets.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeelibrary.interfaces.IStudentService;
import jeelibrary.services.DatabaseStudentService;

@WebServlet(name = "StudentsServlet", urlPatterns = {"/students"})
public class StudentsServlet extends HttpServlet {

    public StudentsServlet() {
        this.studentService = DatabaseStudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("students", this.studentService.list());
        request.getRequestDispatcher("/WEB-INF/views/student/students.jsp").forward(request, response);
    }

    private final IStudentService studentService;

}
