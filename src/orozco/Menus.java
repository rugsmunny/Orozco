/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import java.util.Scanner;

/**
 *
 * @author admusr
 */


public class Menus {
    
    
    public static int choiceMethod(String question, int numberOfChoices,Scanner input){
        int choice;
        while (true) {

            System.out.print(question);

            try{
                choice = Integer.parseInt(input.nextLine());
                if (choice >= 0 && choice <= numberOfChoices){
                    return choice;
                }
            }catch(NumberFormatException e){
                System.out.println("Choice has to be a number");

            }
        }
    }
    
  
    
    public static void addEmployeeChoices(Scanner input){
        String question = "";
        for (int i = 0; i < Orozco.departments.length; i++){
            question += i  +1+ ". " + Orozco.departments[i]+"\n";
        }
        question += "0. Back";
        choiceMethod(question,Orozco.departments.length-1, input);
        
        
        System.out.print("Name:");
    }
}
