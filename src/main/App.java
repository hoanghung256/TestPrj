/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author hoang
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int mul = 0;
        for (int i = 0; i < 100; i++) {
            mul *= i;
        }
        
        System.out.println("Sum from 1 to 100 is " + mul);
        
    }
    
}
