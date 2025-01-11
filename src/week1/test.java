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

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements : ");
        int num = scanner.nextInt();

        System.out.print("Enter the number to search : ");
        int search = scanner.nextInt();

        linearsearch program = new linearsearch(num, search);
        program.randomarray();
        program.display();
        program.displaySearchResult();

        scanner.close();
    }
}

