package jeelibrary.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jeelibrary.interfaces.IStudentService;
import jeelibrary.models.Student;
import jeelibrary.utils.DatabaseManager;

public class DatabaseStudentService implements IStudentService {

    private DatabaseStudentService() {
        this.databaseManager = new DatabaseManager(DatabaseManager.Database.MYSQL);
    }

    public static DatabaseStudentService getInstance() {
        if (instance == null) {
            instance = new DatabaseStudentService();
        }
        return instance;
    }

    @Override
    public void add(Student student) {
        try {
            Connection connection = this.databaseManager.getConnection();
            String query = String.format("INSERT INTO %s (id, name, lastName, carrer) VALUES(?, ?, ?, ?)", this.databaseManager.getTable());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getCarrer());
            preparedStatement.execute();
            connection.close();
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public Student[] list() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = this.databaseManager.getConnection();
            String query = String.format("SELECT id, name, lastName, carrer FROM %s", this.databaseManager.getTable());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String carrer = rs.getString("carrer");
                Student student = new Student(id, name, lastName, carrer);
                students.add(student);
            }
            connection.close();
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
            return new Student[0];
        }
        return students.toArray(new Student[students.size()]);
    }

    @Override
    public Student get(int studentId) {
        Student student = null;
        try {
            Connection connection = this.databaseManager.getConnection();
            String query = String.format("SELECT id, name, lastName, carrer FROM %s WHERE id = ?", this.databaseManager.getTable());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            if (preparedStatement.execute()) {
                ResultSet rs = preparedStatement.getResultSet();
                rs.next();
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String carrer = rs.getString("carrer");
                student = new Student(id, name, lastName, carrer);
            }
            connection.close();
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
            return null;
        }
        return student;
    }

    @Override
    public void update(Student student) {
        try {
            Connection connection = this.databaseManager.getConnection();
            String query = String.format("UPDATE %s SET name = ?, lastName = ?, carrer = ? WHERE id = ?", this.databaseManager.getTable());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getCarrer());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.execute();
            connection.close();
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public void delete(int studentId) {
        try {
            Connection connection = this.databaseManager.getConnection();
            String query = String.format("DELETE FROM %s WHERE id = ?", this.databaseManager.getTable());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.execute();
            connection.close();
        } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private final DatabaseManager databaseManager;
    
    private static DatabaseStudentService instance;
    
}
