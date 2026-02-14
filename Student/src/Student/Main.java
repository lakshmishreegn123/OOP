package Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagenment system = new StudentManagenment();
        Scanner scanner = new Scanner(System.in);
        
        // Load existing data
        system.loadFromFile("students.txt");
        
        while (true) {
            System.out.println("\n*** STUDENT MANAGEMENT SYSTEM ***");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Students by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Calculate Average GPA");
            System.out.println("8. Sort by Name");
            System.out.println("9. Sort by GPA");
            System.out.println("10. Save and Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                	String id=validId(scanner,system);
                    
                    String name = validName(scanner,system);
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();
                    
                    system.addStudent(new Student(id, name, age, email, gpa));
                    break;
                    
                case 2:
                    system.displayAllStudents();
                    break;
                    
                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    Student student = system.findStudentById(searchId);
                    if (student != null) {
                        System.out.println("\n" + student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    system.searchByName(searchName);
                    break;
                    
                case 5:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New GPA: ");
                    double newGpa = scanner.nextDouble();
                    scanner.nextLine();
                    
                    system.updateStudent(updateId, newName, newAge, newEmail, newGpa);
                    break;
                    
                case 6:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    system.deleteStudent(deleteId);
                    break;
                    
                case 7:
                    system.calculateAverageGPA();
                    break;
                    
                case 8:
                    system.sortByName();
                    system.displayAllStudents();
                    break;
                    
                case 9:
                    system.sortByGPA();
                    system.displayAllStudents();
                    break;
                    
                case 10:
                    system.saveToFile("students.txt");
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static String validId(Scanner scanner,StudentManagenment system) {
    	String id;
    	do {
    		System.out.print("Enter Student ID: ");
        	id = scanner.nextLine().trim();
        	if(id.isEmpty()) {
        		System.out.println("the id should not be empty");
        	
        	}
        	else if(system.findStudentById(id)!=null) {
        		System.out.println("user exsits");
        	
        	}
        	else {
        		
        		return id;
        	}
    	}while(true);
    }
    private static String validName(Scanner scanner,StudentManagenment system) {
    	String name;
    	do {
    		System.out.println("Enter your name:");
    		name = scanner.nextLine().trim();
    		if(name.isEmpty()) {
    			System.out.println("The name should not be empty");
    		}
    		else if((name.length()<2)||(name.length()==2 && name.contains(" "))) {
    			System.out.println("should be 2 characters in name");
    		}
    		else if(! name.matches("[a-zA-Z\s]+")) {
    			System.out.println("The name should only contain either characters or names");
    		}
    		else {
    			return name;
    		}
    	}while(true);
    }
    private static int validAge(Scanner scanner,StudentManagenment system) {
    	int age;
    	do {
    		System.out.println("Enter your age:");
    		age = scanner.nextInt();
    		if(age<15||age>100) {
    			System.out.println("the entered age is invalid");
    		}
    		else {
    			return age;
    		}
    	}while(true);
    }
    private static String validEmail(Scanner scanner,StudentManagenment system) {
    	String Email;
    	do {
    		System.out.println("Enter your email:");
    		Email= scanner.nextLine();
    		if(Email.matches("\.[a-zA-Z0-9\! \#\ $\ %\ &\ ' \* \+ \- \/ \= \? \^ \_ \` \{ \| \} \~]*..[.]+.@[-]+[a-zA-Z0-9]+"))
    	}
    }
}