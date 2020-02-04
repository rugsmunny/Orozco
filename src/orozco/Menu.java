/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import java.util.Scanner;

/**
 *
 * @author karim
 */
public class Menu {

  public int choiceMethod(String question, int numberOfChoices, Scanner input) {
        int choice;
        while (true) {

            System.out.println(question);
            
            try {
                choice = Integer.parseInt(input.nextLine());
                if(choice >= 0 && choice <= numberOfChoices){
                   return choice; 
                }
                
            } catch (NumberFormatException e) {

                System.out.println("\nEtt fel uppstod, försök igen. \n");

            }
        }

        

    }
}
