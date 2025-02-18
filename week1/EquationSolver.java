/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

/**
 *
 * @author mbban
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EquationSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateSuperlativeEquation(scanner);
                    break;
                case 2:
                    calculateQuadraticEquation(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Calculate Superlative Equation (ax + b = 0)");
        System.out.println("2. Calculate Quadratic Equation (ax^2 + bx + c = 0)");
        System.out.println("3. Exit");
    }

  
    private static void calculateSuperlativeEquation(Scanner scanner) {
        System.out.println("\nCalculate Superlative Equation (ax + b = 0)");

        System.out.print("Enter coefficient A (non-zero): ");
        double a = validateNumber(scanner);
        System.out.print("Enter coefficient B: ");
        double b = validateNumber(scanner);

     
        if (a == 0) {
            System.out.println("Coefficient A cannot be zero in a superlative equation.");
        } else {
            double x = -b / a;
            System.out.println("The solution to the equation is x = " + x);
        }

      
        analyzeNumbers((int) a, (int) b);
    }

    
    private static void calculateQuadraticEquation(Scanner scanner) {
        System.out.println("\nCalculate Quadratic Equation (ax^2 + bx + c = 0)");


        System.out.print("Enter coefficient A (non-zero): ");
        double a = validateNumber(scanner);
        System.out.print("Enter coefficient B: ");
        double b = validateNumber(scanner);
        System.out.print("Enter coefficient C: ");
        double c = validateNumber(scanner);

       
        if (a == 0) {
            System.out.println("Coefficient A cannot be zero in a quadratic equation.");
        } else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                System.out.println("The equation has no real roots.");
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has one solution: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two solutions: x1 = " + x1 + ", x2 = " + x2);
            }
        }

       
        analyzeNumbers((int) a, (int) b, (int) c);
    }

   
    private static double validateNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

   
    private static void analyzeNumbers(int... numbers) {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> squareNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }

            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                squareNumbers.add(num);
            }
        }

       
        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Square numbers: " + squareNumbers);
    }
}
