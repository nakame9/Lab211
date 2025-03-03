import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Worker {
    String id;
    String name;
    int age;
    double salary;
    String location;

    public Worker(String id, String name, int age, double salary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }
}

class SalaryHistory {
    String id;
    double oldSalary;
    double newSalary;
    String changeType;

    public SalaryHistory(String id, double oldSalary, double newSalary, String changeType) {
        this.id = id;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.changeType = changeType;
    }
}

class WorkerManagement {
    private HashMap<String, Worker> workers;
    private ArrayList<SalaryHistory> salaryHistory;
    private Scanner scanner;

    public WorkerManagement() {
        workers = new HashMap<>();
        salaryHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Worker Management System ===");
            System.out.println("1. Add a Worker");
            System.out.println("2. Increase Salary");
            System.out.println("3. Decrease Salary");
            System.out.println("4. Show Adjusted Salary History");
            System.out.println("5. Quit");
            System.out.print("Select an option (1-5): ");
            
            String choice = scanner.nextLine();
            if ("12345".contains(choice) && choice.length() == 1) {
                performFunction(choice);
                if (choice.equals("5")) break;
            } else {
                System.out.println("Invalid option! Please select 1-5.");
            }
        }
    }

    private void performFunction(String choice) {
        switch (choice) {
            case "1": addWorker(); break;
            case "2": increaseSalary(); break;
            case "3": decreaseSalary(); break;
            case "4": showSalaryHistory(); break;
        }
    }

    private void addWorker() {
        System.out.println("\n=== Add New Worker ===");
        System.out.print("Enter worker ID: ");
        String id = scanner.nextLine();

        if (id.isEmpty() || workers.containsKey(id)) {
            System.out.println("Error: ID cannot be empty or duplicate!");
            return;
        }

        System.out.print("Enter worker name: ");
        String name = scanner.nextLine();

        try {
            System.out.print("Enter worker age: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age < 18 || age > 50) {
                System.out.println("Error: Age must be between 18 and 50!");
                return;
            }

            System.out.print("Enter worker salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            if (salary <= 0) {
                System.out.println("Error: Salary must be greater than 0!");
                return;
            }

            System.out.print("Enter work location: ");
            String location = scanner.nextLine();

            workers.put(id, new Worker(id, name, age, salary, location));
            System.out.println("Worker added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric values for age and salary!");
        }
    }

    private void increaseSalary() {
        System.out.println("\n=== Increase Salary ===");
        System.out.print("Enter worker ID: ");
        String id = scanner.nextLine();

        if (!workers.containsKey(id)) {
            System.out.println("Error: Worker ID not found!");
            return;
        }

        try {
            System.out.print("Enter amount to increase: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than 0!");
                return;
            }

            Worker worker = workers.get(id);
            double oldSalary = worker.salary;
            worker.salary += amount;

            salaryHistory.add(new SalaryHistory(id, oldSalary, worker.salary, "Increase"));
            System.out.println("Salary increased successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid amount!");
        }
    }

    private void decreaseSalary() {
        System.out.println("\n=== Decrease Salary ===");
        System.out.print("Enter worker ID: ");
        String id = scanner.nextLine();

        if (!workers.containsKey(id)) {
            System.out.println("Error: Worker ID not found!");
            return;
        }

        try {
            System.out.print("Enter amount to decrease: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than 0!");
                return;
            }

            Worker worker = workers.get(id);
            double oldSalary = worker.salary;
            worker.salary -= amount;

            salaryHistory.add(new SalaryHistory(id, oldSalary, worker.salary, "Decrease"));
            System.out.println("Salary decreased successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid amount!");
        }
    }

    private void showSalaryHistory() {
        System.out.println("\n=== Salary Adjustment History ===");
        if (salaryHistory.isEmpty()) {
            System.out.println("No salary adjustments have been made yet!");
            return;
        }

        for (SalaryHistory record : salaryHistory) {
            Worker worker = workers.get(record.id);
            System.out.println("ID: " + record.id);
            System.out.println("Name: " + worker.name);
            System.out.println("Change Type: " + record.changeType);
            System.out.printf("Old Salary: $%.2f%n", record.oldSalary);
            System.out.printf("New Salary: $%.2f%n", record.newSalary);
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {
        WorkerManagement wm = new WorkerManagement();
        wm.displayMenu();
        System.out.println("Program terminated.");
    }
}