/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;
import java.util.*;

class Student {
    private int id;
    private String name;
    private String semester;
    private String courseName;

    
    public Student(int id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Semester: " + semester + " | Course: " + courseName;
    }
}

public class StudentManagement {

    private static List<Student> students = new ArrayList<>();
    private static int studentIdCounter = 1; 

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report, and 5 to Exit program: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createStudent(scanner);
                    break;
                case 2:
                    findAndSortStudent(scanner);
                    break;
                case 3:
                    updateDeleteStudent(scanner);
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    
    public static void createStudent(Scanner scanner) {
        if (students.size() >= 3) {
            System.out.print("Do you want to continue creating students? (Y/N): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter Course Name (Java, .Net, C/C++): ");
        String courseName = scanner.nextLine();

        Student student = new Student(studentIdCounter++, name, semester, courseName);
        students.add(student);
        System.out.println("Student created successfully.");
    }

    
    public static void findAndSortStudent(Scanner scanner) {
        System.out.print("Enter student name (or part of it) to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No students found with the name " + searchName);
        } else {
           
            result.sort(Comparator.comparing(Student::getName));

            System.out.println("Found and Sorted Students:");
            for (Student student : result) {
                System.out.println(student);
            }
        }
    }

    
    public static void updateDeleteStudent(Scanner scanner) {
        System.out.print("Enter the Student ID to find: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToUpdate = student;
                break;
            }
        }

        if (studentToUpdate == null) {
            System.out.println("No student found with ID " + id);
            return;
        }

        System.out.println("Student found: " + studentToUpdate);
        System.out.print("Do you want to update (U) or delete (D) this student? ");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("U")) {
            System.out.print("Enter new Name: ");
            studentToUpdate.setName(scanner.nextLine());
            System.out.print("Enter new Semester: ");
            studentToUpdate.setSemester(scanner.nextLine());
            System.out.print("Enter new Course Name: ");
            studentToUpdate.setCourseName(scanner.nextLine());
            System.out.println("Student information updated successfully.");
        } else if (action.equalsIgnoreCase("D")) {
            students.remove(studentToUpdate);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Invalid option! Returning to main screen.");
        }
    }

    
    public static void generateReport() {
        System.out.println("Student Report (Total Courses per Student):");

        for (Student student : students) {
            System.out.println(student.getName() + " is enrolled in " + student.getCourseName());
        }
    }
}
