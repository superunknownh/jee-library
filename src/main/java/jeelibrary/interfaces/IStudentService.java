package jeelibrary.interfaces;

import jeelibrary.models.Student;

public interface IStudentService {
    void add(Student student);
    Student[] list();
    Student get(int studentId);
    void update(Student student);
    void delete(int studentId);
}
