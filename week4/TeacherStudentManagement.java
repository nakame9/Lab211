/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

import java.util.*;

class Person {
    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    
    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    
    public void inputAll(Scanner scanner) {
        while (true) {
            System.out.print("Enter ID (6 digits): ");
            id = scanner.nextLine();
            if (id.matches("\\d{6}")) break;
            System.out.println("Data input is invalid.");
        }

        while (true) {
            System.out.print("Enter Full Name (Alphabet and spaces only): ");
            fullName = scanner.nextLine();
            if (fullName.matches("[a-zA-Z ]+")) break;
            System.out.println("Data input is invalid.");
        }

        while (true) {
            System.out.print("Enter Phone Number (12 digits): ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{12}")) break;
            System.out.println("Data input is invalid.");
        }

        while (true) {
            System.out.print("Enter Year of Birth (Before current year): ");
            yearOfBirth = scanner.nextInt();
            if (yearOfBirth < Calendar.getInstance().get(Calendar.YEAR)) break;
            System.out.println("Data input is invalid.");
        }
        scanner.nextLine(); 

        while (true) {
            System.out.print("Enter Major (Max 30 characters): ");
            major = scanner.nextLine();
            if (major.length() <= 30) break;
            System.out.println("Data input is invalid.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + fullName + " | Phone: " + phoneNumber +
               " | Year of Birth: " + yearOfBirth + " | Major: " + major;
    }
}


class Teacher extends Person {
    private int yearsInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearsInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    @Override
    public void inputAll(Scanner scanner) {
        super.inputAll(scanner);
        int age = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth;

        while (true) {
            System.out.print("Enter Years in Profession (0 to " + (age - 1) + "): ");
            yearsInProfession = scanner.nextInt();
            if (yearsInProfession >= 0 && yearsInProfession < age) break;
            System.out.println("Data input is invalid.");
        }
        scanner.nextLine(); 

        while (true) {
            System.out.print("Enter Contract Type (Long/Short): ");
            contractType = scanner.nextLine();
            if (contractType.equalsIgnoreCase("Long") || contractType.equalsIgnoreCase("Short")) break;
            System.out.println("Data input is invalid.");
        }

        while (true) {
            System.out.print("Enter Salary Coefficient (>= 0): ");
            salaryCoefficient = scanner.nextDouble();
            if (salaryCoefficient >= 0) break;
            System.out.println("Data input is invalid.");
        }
        scanner.nextLine(); 
    }

    public int getYearsInProfession() {
        return yearsInProfession;
    }

    @Override
    public String toString() {
        return super.toString() + " | Years in Profession: " + yearsInProfession + 
               " | Contract: " + contractType + " | Salary Coefficient: " + salaryCoefficient;
    }
}


class Student extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    @Override
    public void inputAll(Scanner scanner) {
        super.inputAll(scanner);

        while (true) {
            System.out.print("Enter Year of Admission (Between " + yearOfBirth + " and Current Year): ");
            yearOfAdmission = scanner.nextInt();
            if (yearOfAdmission >= yearOfBirth && yearOfAdmission <= Calendar.getInstance().get(Calendar.YEAR)) break;
            System.out.println("Data input is invalid.");
        }

        while (true) {
            System.out.print("Enter Entrance English Score (0 - 100): ");
            entranceEnglishScore = scanner.nextInt();
            if (entranceEnglishScore >= 0 && entranceEnglishScore <= 100) break;
            System.out.println("Data input is invalid.");
        }
        scanner.nextLine(); 
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    @Override
    public String toString() {
        return super.toString() + " | Year of Admission: " + yearOfAdmission + 
               " | English Score: " + entranceEnglishScore;
    }
}


public class TeacherStudentManagement {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Enter Teachers");
            System.out.println("2. Print Teachers (Sorted by Years in Profession Descending)");
            System.out.println("3. Enter Students");
            System.out.println("4. Print Students (Sorted by Year of Admission Ascending)");
            System.out.println("5. Search Person by Name (Sort by Year of Birth Descending)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    enterTeachers(scanner);
                    break;
                case 2:
                    printTeachersSorted();
                    break;
                case 3:
                    enterStudents(scanner);
                    break;
                case 4:
                    printStudentsSorted();
                    break;
                case 5:
                    searchPerson(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    private static void enterTeachers(Scanner scanner) {
        System.out.print("Enter number of teachers: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Teacher teacher = new Teacher();
            teacher.inputAll(scanner);
            teachers.add(teacher);
        }
    }

    private static void printTeachersSorted() {
        teachers.sort(Comparator.comparingInt(Teacher::getYearsInProfession).reversed());
        teachers.forEach(System.out::println);
    }

    private static void enterStudents(Scanner scanner) {
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.inputAll(scanner);
            students.add(student);
        }
    }

    private static void printStudentsSorted() {
        students.sort(Comparator.comparingInt(Student::getYearOfAdmission));
        students.forEach(System.out::println);
    }

    private static void searchPerson(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().toLowerCase();
        List<Person> foundPeople = new ArrayList<>();

        for (Teacher teacher : teachers) if (teacher.fullName.toLowerCase().contains(name)) foundPeople.add(teacher);
        for (Student student : students) if (student.fullName.toLowerCase().contains(name)) foundPeople.add(student);

        foundPeople.sort(Comparator.comparingInt(p -> -p.yearOfBirth)); 

        if (foundPeople.isEmpty()) System.out.println("No person found.");
        else foundPeople.forEach(System.out::println);
    }
}
