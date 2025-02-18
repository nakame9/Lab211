

package week1;

import java.util.Random; 

public class linearsearch {
    private int num;
    private int search;
    private int [] array;

public linearsearch(int num, int search) { 
    
this.num = num;
this.search = search;
this.array = new int[num];

}
public void randomarray(){
    Random random = new Random();
    for(int i = 0;i<num;i++){
        array[i]=random.nextInt(num);
    }
}
    public void display(){
        System.out.println("Array:");  
        for(int number : array){
            System.out.println(number +  ""); 
        }
        System.out.println();
    }
    public void displaySearchResult() { 
        int index = -1; 
        for (int i = 0; i < array.length; i++) { 
            if (array[i] == search) { 
                index = i; break; 
            } 
        } if (index != -1) 
        {
            System.out.println("The number " + search + " is found at index " + index + "."); } 
    else { System.out.println("The number " + search + " is not found in the array."); } }
}


