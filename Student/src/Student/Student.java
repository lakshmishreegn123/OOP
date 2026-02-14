package Student;
public class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private double gpa;
    
    // Constructor
    public Student(String studentId, String name, int age, String email, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }
    
    // Getters and Setters
    public String getStudentId() { return this.studentId; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    public double getGpa() { return this.gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    
    // Display student information
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %-20s | Age: %d | Email: %-25s | GPA: %.2f",
                           this.studentId, this.name, this.age, this.email, this.gpa);
    }
}