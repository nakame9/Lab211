import java.util.Scanner;

public class CalculatorBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
                scanner.next(); 
                continue;
            }

            switch (choice) {
                case 1:
                    normalCalculator(scanner);
                    break;
                case 2:
                    bmiCalculator(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }

    
    public static void normalCalculator(Scanner scanner) {
        System.out.println("\n--- Normal Calculator ---");
        double result = 0;
        
        System.out.print("Enter first number: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.next(); 
            return;
        }
        result = scanner.nextDouble();

        while (true) {
            System.out.print("Enter operator (+, -, *, /, ^, =): ");
            String operator = scanner.next();
            
            if (operator.equals("=")) {
                System.out.println("Final Result: " + result);
                return;
            }

            if (!operator.matches("[+\\-*/^]")) {
                System.out.println("Invalid operator! Use only (+, -, *, /, ^).");
                continue;
            }

            System.out.print("Enter next number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next(); 
                continue;
            }
            double num = scanner.nextDouble();

            switch (operator) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    if (num == 0) {
                        System.out.println("Error: Cannot divide by zero!");
                        continue;
                    }
                    result /= num;
                    break;
                case "^":
                    result = Math.pow(result, num);
                    break;
            }
            System.out.println("Current Result: " + result);
        }
    }

    
    public static void bmiCalculator(Scanner scanner) {
        System.out.println("\n--- BMI Calculator ---");

        System.out.print("Enter your weight (kg): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.next(); 
            return;
        }
        double weight = scanner.nextDouble();

        System.out.print("Enter your height (m): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.next(); 
            return;
        }
        double height = scanner.nextDouble();

        if (weight <= 0 || height <= 0) {
            System.out.println("Error: Weight and height must be greater than zero!");
            return;
        }

        double bmi = weight / (height * height);
        System.out.printf("Your BMI: %.2f\n", bmi);

        String status;
        if (bmi < 19) {
            status = "Under-standard";
        } else if (bmi < 25) {
            status = "Standard";
        } else if (bmi < 30) {
            status = "Overweight";
        } else if (bmi < 40) {
            status = "Fat - should lose weight";
        } else {
            status = "Very fat - should lose weight immediately";
        }

        System.out.println("Body Status: " + status);
    }
}
