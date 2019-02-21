package jeelibrary.services;

import java.util.ArrayList;
import jeelibrary.interfaces.IStudentService;
import jeelibrary.models.Student;

public class MemoryStudentService implements IStudentService {

    private MemoryStudentService() {
    }

    public static MemoryStudentService getInstance() {
        if (instance == null) {
            instance = new MemoryStudentService();
        }
        return instance;
    }

    @Override
    public void add(Student student) {
        DATABASE.add(student);
    }

    @Override
    public Student[] list() {
        Student[] students = new Student[DATABASE.size()];
        for (int i = 0; i < DATABASE.size(); i++) {
            students[i] = DATABASE.get(i);
        }
        return students;
    }

    @Override
    public Student get(int id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == id) {
                return DATABASE.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == student.getId()) {
                DATABASE.get(i).setName(student.getName());
                DATABASE.get(i).setLastName(student.getLastName());
                DATABASE.get(i).setCarrer(student.getCarrer());
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            if (DATABASE.get(i).getId() == id) {
                DATABASE.remove(i);
            }
        }
    }
    
    private static final ArrayList<Student> DATABASE = new ArrayList<>();
    static {
        DATABASE.add(new Student(223230, "Nadezhda Paulina", "Gaona Sosa", "Ingenieria en Software"));
        DATABASE.add(new Student(223237, "Hugo", "Sánchez Landaverde", "Ingenieria en Software"));
    }
    
    private static MemoryStudentService instance;
 }
