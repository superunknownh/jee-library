package jeelibrary.models;

public class Student {

    public Student(int id, String name, String lastName, String carrer) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.carrer = carrer;
    }
    
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", carrer=" + carrer + '}';
    }

    private int id;
    private String name;
    private String lastName;
    private String carrer;
}
