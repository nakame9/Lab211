/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.util.Random;
import java.util.Scanner;

public class BubbleSortProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        double inputNumber;
        while (true) {
            System.out.print("Enter a positive decimal number: ");
            if (scanner.hasNextDouble()) {
                inputNumber = scanner.nextDouble();
                if (inputNumber > 0) break;
                else System.out.println("Number must be positive.");
            } else {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.next();
            }
        }

        
        int maxRange = (int) Math.ceil(inputNumber);

        
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxRange) + 1; 
        }

        
        System.out.println("\nUnsorted Array:");
        printArray(array);

        
        bubbleSort(array);

        
        System.out.println("\nSorted Array:");
        printArray(array);

        scanner.close();
    }

    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
