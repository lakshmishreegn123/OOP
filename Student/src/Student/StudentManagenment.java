package Student;
import java.util.*;
import java.io.*;

public class StudentManagenment {
    private ArrayList<Student> students;
    
    public StudentManagenment() {
        students = new ArrayList<>();
    }
    
    // Add student
    public void addStudent(Student student) {
        // Check if student ID already exists
        if (findStudentById(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists!");
            return;
        }
       
        students.add(student);
        System.out.println("Student added successfully!");
    }
    
    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        System.out.println("\n" + "=".repeat(100));
        System.out.println("ALL STUDENTS");
        System.out.println("=".repeat(100));
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=".repeat(100));
    }
    
    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    // Search students by name (partial match)
    public void searchByName(String searchName) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                results.add(student);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("No students found with name: " + searchName);
        } else {
            System.out.println("\nSearch Results:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
    }
    
    // Delete student
    public void deleteStudent(String id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    
    // Update student information
    public void updateStudent(String id, String name, int age, String email, double gpa) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setEmail(email);
            student.setGpa(gpa);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    
    // Calculate average GPA
    public void calculateAverageGPA() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getGpa();
        }
        double average = sum / students.size();
        System.out.printf("Average GPA: %.2f\n", average);
    }
    
    // Sort students by name
    public void sortByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("Students sorted by name.");
    }
    
    // Sort students by GPA (descending)
    public void sortByGPA() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
        System.out.println("Students sorted by GPA (highest first).");
    }
    
    // Save to file
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getStudentId() + "," + 
                             student.getName() + "," + 
                             student.getAge() + "," + 
                             student.getEmail() + "," + 
                             student.getGpa());
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    
    // Load from file
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            students.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Student student = new Student(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        parts[3],
                        Double.parseDouble(parts[4])
                    );
                    students.add(student);
                }
            }
            System.out.println("Data loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with empty database.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

