/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

/**
 *
 * @author mbban
 */
import java.util.Scanner;

public class BaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.println("\nChoose the input base:");
            System.out.println("1. Binary (Base 2)");
            System.out.println("2. Decimal (Base 10)");
            System.out.println("3. Hexadecimal (Base 16)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            int inputBaseChoice = scanner.nextInt();
            scanner.nextLine(); 

            
            if (inputBaseChoice == 4) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

           
            if (inputBaseChoice < 1 || inputBaseChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

           
            System.out.println("\nChoose the output base:");
            System.out.println("1. Binary (Base 2)");
            System.out.println("2. Decimal (Base 10)");
            System.out.println("3. Hexadecimal (Base 16)");
            System.out.print("Enter your choice (1/2/3): ");
            int outputBaseChoice = scanner.nextInt();
            scanner.nextLine(); 

           
            if (outputBaseChoice < 1 || outputBaseChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("\nEnter the input value: ");
            String inputValue = scanner.nextLine();

            try {
                int inputBase = (inputBaseChoice == 1) ? 2 : (inputBaseChoice == 2) ? 10 : 16;
                int outputBase = (outputBaseChoice == 1) ? 2 : (outputBaseChoice == 2) ? 10 : 16;

                int decimalValue = Integer.parseInt(inputValue, inputBase);

                String outputValue;
                if (outputBase == 2) {
                    outputValue = Integer.toBinaryString(decimalValue);
                } else if (outputBase == 10) {
                    outputValue = Integer.toString(decimalValue);
                } else {
                    outputValue = Integer.toHexString(decimalValue).toUpperCase();
                }

         
                System.out.println("Converted value in Base " + outputBase + ": " + outputValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input value for the chosen base. Please try again.");
            }
        }

        scanner.close();
    }
}
