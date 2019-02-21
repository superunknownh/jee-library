package jeelibrary.servlets.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeelibrary.interfaces.IStudentService;
import jeelibrary.services.DatabaseStudentService;

@WebServlet(name = "DeleteStudentServlet", urlPatterns = {"/students/delete"})
public class DeleteStudentServlet extends HttpServlet {

    public DeleteStudentServlet() {
        this.studentService = DatabaseStudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/jee-library/students");
    }

    private final IStudentService studentService;

}
