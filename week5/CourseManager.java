import java.util.*;

class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public void inputAll(Scanner sc, Set<String> courseIDs, Set<String> courseNames) {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine().trim();
        if (id.isEmpty() || courseIDs.contains(id)) {
            System.out.println("Invalid or duplicate Course ID!");
            return;
        }

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty() || courseNames.contains(name)) {
            System.out.println("Invalid or duplicate Course Name!");
            return;
        }

        System.out.print("Enter Credits: ");
        int cr = sc.nextInt();
        sc.nextLine(); 
        if (cr <= 0) {
            System.out.println("Credits must be greater than 0!");
            return;
        }

        this.courseID = id;
        this.courseName = name;
        this.credits = cr;
        courseIDs.add(id);
        courseNames.add(name);
    }

    public void display() {
        System.out.println("Course ID: " + courseID + ", Name: " + courseName + ", Credits: " + credits);
    }
}

class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public void inputAll(Scanner sc, Set<String> courseIDs, Set<String> courseNames) {
        super.inputAll(sc, courseIDs, courseNames);
        
        System.out.print("Enter Platform: ");
        this.platform = sc.nextLine().trim();
        if (platform.isEmpty()) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Enter Instructors: ");
        this.instructors = sc.nextLine().trim();

        System.out.print("Enter Note: ");
        this.note = sc.nextLine().trim();
        if (note.isEmpty()) {
            System.out.println("Data input is invalid");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Platform: " + platform + ", Instructors: " + instructors + ", Note: " + note);
    }
}

class OfflineCourse extends Course {
    private String begin;
    private String end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = "";
        this.end = "";
        this.campus = "";
    }

    public void inputAll(Scanner sc, Set<String> courseIDs, Set<String> courseNames) {
        super.inputAll(sc, courseIDs, courseNames);

        System.out.print("Enter Begin Date (YYYY-MM-DD): ");
        this.begin = sc.nextLine().trim();

        System.out.print("Enter End Date (YYYY-MM-DD): ");
        this.end = sc.nextLine().trim();

        if (begin.compareTo(end) >= 0) {
            System.out.println("Data input is invalid: Begin must be before End!");
            return;
        }

        System.out.print("Enter Campus: ");
        this.campus = sc.nextLine().trim();
        if (campus.isEmpty()) {
            System.out.println("Data input is invalid");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Begin: " + begin + ", End: " + end + ", Campus: " + campus);
    }
}

public class CourseManager {
    private List<Course> courses = new ArrayList<>();
    private Set<String> courseIDs = new HashSet<>();
    private Set<String> courseNames = new HashSet<>();

    public void addCourse(Scanner sc, boolean isOnline) {
        Course course = isOnline ? new OnlineCourse() : new OfflineCourse();
        course.inputAll(sc, courseIDs, courseNames);
        courses.add(course);
    }

    public void updateCourse(Scanner sc) {
        System.out.print("Enter Course ID to update: ");
        String id = sc.nextLine();
        for (Course c : courses) {
            if (c.courseID.equals(id)) {
                System.out.println("Updating course...");
                c.inputAll(sc, courseIDs, courseNames);
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public void deleteCourse(Scanner sc) {
        System.out.print("Enter Course ID to delete: ");
        String id = sc.nextLine();
        courses.removeIf(c -> c.courseID.equals(id));
        courseIDs.remove(id);
        System.out.println("Course deleted.");
    }

    public void printCourses(boolean online) {
        for (Course c : courses) {
            if (online && c instanceof OnlineCourse || !online && c instanceof OfflineCourse) {
                c.display();
            }
        }
    }

    public void printAllCourses() {
        for (Course c : courses) {
            c.display();
        }
    }

    public void searchByName(Scanner sc) {
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();
        for (Course c : courses) {
            if (c.courseName.equalsIgnoreCase(name)) {
                c.display();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManager manager = new CourseManager();
        while (true) {
            System.out.println("1. Add Online Course\n2. Add Offline Course\n3. Update Course\n4. Delete Course\n5. Print All Online Courses\n6. Print All Offline Courses\n7. Print All Courses\n8. Search Course\n9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.addCourse(sc, true);
                case 2 -> manager.addCourse(sc, false);
                case 3 -> manager.updateCourse(sc);
                case 4 -> manager.deleteCourse(sc);
                case 5 -> manager.printCourses(true);
                case 6 -> manager.printCourses(false);
                case 7 -> manager.printAllCourses();
                case 8 -> manager.searchByName(sc);
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
