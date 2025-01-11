/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

/**
 *
 * @author mbban
 */
public class Countcharacter {
   
    private String text;

   
    public Countcharacter(String text) {
        this.text = text;
    }

    
    public int countWords() {
        return text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
    }

    
    public int countCharactersWithSpaces() {
        return text.length();
    }

   
    public int countCharactersWithoutSpaces() {
        return text.replaceAll("\\s", "").length();
    }

   
    public int countLines() {
        return text.isEmpty() ? 0 : text.split("\n").length;
    }
}


