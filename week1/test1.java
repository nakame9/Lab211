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

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.println("input:");
        String input = scanner.nextLine();

  
        Countcharacter counter = new Countcharacter(input);

       
        System.out.println("\n--- Result ---");
        System.out.println("Number of words: " + counter.countWords());
        System.out.println("Number of characters (including spaces): " + counter.countCharactersWithSpaces());
        System.out.println("Number of characters (excluding spaces): " + counter.countCharactersWithoutSpaces());
        System.out.println("Number of lines: " + counter.countLines());

        scanner.close();
    }
}
