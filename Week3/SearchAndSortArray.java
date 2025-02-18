/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.util.Random;
import java.util.Scanner;

public class SearchAndSortArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter a positive decimal number (upper limit for random array elements): ");
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

       
        System.out.println("Enter the number you want to search for: ");
        int searchNum = scanner.nextInt();

        
        
        System.out.println("Unsorted array:");
        printArray(arr);

        
        quickSort(arr, 0, arr.length - 1);

        
        System.out.println("Sorted array:");
        printArray(arr);

        
        int index = binarySearch(arr, searchNum);

        
        if (index != -1) {
            System.out.println("The number " + searchNum + " is found at index: " + index);
        } else {
            System.out.println("The number " + searchNum + " was not found in the array.");
        }
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

    
    public static int binarySearch(int[] arr, int searchNum) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == searchNum) {
                return mid; 
            }
            if (arr[mid] < searchNum) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return -1; 
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
