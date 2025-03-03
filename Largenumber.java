/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week5;

import java.util.Scanner;

public class Largenumber {
    
    
    public static int[] stringToArray(String num) {
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0'; 
        }
        return arr;
    }

  
    public static int[] addLargeNumbers(int[] num1, int[] num2) {
        int maxLen = Math.max(num1.length, num2.length);
        int[] result = new int[maxLen + 1]; 
        int carry = 0, sum, i, j, k;
        
        for (i = num1.length - 1, j = num2.length - 1, k = maxLen; i >= 0 || j >= 0 || carry > 0; k--) {
            sum = carry;
            if (i >= 0) sum += num1[i--];
            if (j >= 0) sum += num2[j--];
            result[k] = sum % 10;
            carry = sum / 10;
        }
        
        return result;
    }


    public static int[] multiplyLargeNumbers(int[] num1, int[] num2) {
        int len1 = num1.length, len2 = num2.length;
        int[] result = new int[len1 + len2]; 
       
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = num1[i] * num2[j];
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10; 
                result[i + j] += sum / 10;    
            }
        }

        return result;
    }

   
    public static void printArrayAsNumber(int[] num) {
        boolean leadingZero = true;
        for (int digit : num) {
            if (leadingZero && digit == 0) continue;
            leadingZero = false;
            System.out.print(digit);
        }
        if (leadingZero) System.out.print("0"); 
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();

        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine();

        int[] num1 = stringToArray(strNum1);
        int[] num2 = stringToArray(strNum2);

      
        int[] sum = addLargeNumbers(num1, num2);
        int[] product = multiplyLargeNumbers(num1, num2);

        System.out.print("Sum: ");
        printArrayAsNumber(sum);

        System.out.print("Product: ");
        printArrayAsNumber(product);

        scanner.close();
    }
}
