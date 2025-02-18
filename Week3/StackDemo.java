/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;

import java.util.ArrayList;

class MyStack {
    
    private ArrayList<Integer> stackValues;

    
    public MyStack() {
        stackValues = new ArrayList<>();
    }

    
    public void push(int value) {
        stackValues.add(value);
        System.out.println(value + " pushed to stack");
    }

    
    public int pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1; 
        }
        int poppedValue = stackValues.remove(stackValues.size() - 1);
        System.out.println(poppedValue + " popped from stack");
        return poppedValue;
    }

    
    public int get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; 
        }
        return stackValues.get(stackValues.size() - 1);
    }

    
    public boolean isEmpty() {
        return stackValues.isEmpty();
    }
}

public class StackDemo {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        
        System.out.println("Top of stack: " + stack.get());

        
        stack.pop();
        stack.pop();

        
        System.out.println("Top of stack after popping: " + stack.get());

        
        stack.pop();
        
        
        stack.pop();
    }
}
