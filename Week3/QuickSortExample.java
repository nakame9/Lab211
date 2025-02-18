/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.util.Random;
import java.util.Scanner;

public class QuickSortExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter a positive decimal number (this will be the upper limit for the array values): ");
        double input = scanner.nextDouble();

        
        if (input <= 0) {
            System.out.println("Please enter a positive decimal number.");
            return;
        }

        
        int upperLimit = (int) input;

        
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

       
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(upperLimit);  
        }

        
        System.out.println("Unsorted array:");
        printArray(arr);

        
        quickSort(arr, 0, arr.length - 1);

       
        System.out.println("Sorted array:");
        printArray(arr);
    }

    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); 
            quickSort(arr, pivotIndex + 1, high);  
        }
    }

   
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
       
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
