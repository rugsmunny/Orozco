/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import Employees.*;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author admusr
 */
public class Menus {
    
    
    
    public static String listChoices(String[] choices){
        String question = "";
        for (int i = 0; i < choices.length; i++) {
            question += "\n" + (i +1) +". " +choices[i];
                
        }
        return question;
    }

    public static int choiceMethod(String[] choices, Scanner input) {
        int choice;
        while (true) {
            
            String question = "";
            
            question = listChoices(choices);
            
            

            question += "\n\nchoice:";
            System.out.print(question);

            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice == 0 || choice <= choices.length) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError. Please try again.");

            }
        }
    }

    public static String questionAndInputString(String question, Scanner input) {
        while (true){
            System.out.print("\n"+question+": ");
            try{
                return input.nextLine();
            }
            catch(Exception e){
                System.out.println(e);
            } 
        }
    }

    public static int questionAndInputInt(String question, Scanner input) {
        while (true){
            System.out.print("\n"+question+": ");
            try{
                return Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                System.out.println(e);
            } 
        }
        
        
    }
    
    public static String checkForDuplicateId(String id){
        int duplicates = 0;
        String tempid = id; 
        int index;
        while (true){
            index = 0;
            for (Employee e : Orozco.employees){
                index += 1;
                if (e.id.equals(tempid)){
                    
                    tempid = id;
                    duplicates += 1;
                    tempid += duplicates;
                    break;
                }
                if (index == Orozco.employees.size()){
                    return tempid;
                }
                
                
            }
        }
    }

    public static void addEmployee(Scanner input) {


        int choice;

        String name = questionAndInputString("Name", input);
        
        String lastName = questionAndInputString("Last Name", input);
        
        int salary = questionAndInputInt("Salary", input);
        Employee.genders gender = null;
   
        switch (choiceMethod(new String[] {"Man","Woman","NonBinary"}, input)) {
            case 1:
                gender = Employee.genders.man;
                break;
            case 2:
                gender = Employee.genders.woman;
                break;
            case 3:
                gender = Employee.genders.nonbinary;
                break;
        }
        
   
        
        String id = checkForDuplicateId((name + lastName.substring(0, 2)).toLowerCase());
        String birthDate = questionAndInputString("Birth date (YYYYMMDD)", input);
        int startDate = questionAndInputInt("\nStart date (YYYYMMDD)", input);

        Employee.positions position = null;
        int positionChoice = choiceMethod(new String[] {"Worker", "Local manager"} , input);
        switch (positionChoice) {
            case 1:
                position = Employee.positions.worker;
            case 2:
                position = Employee.positions.localManager;

        }

        choice = choiceMethod(Orozco.departments, input);
        switch (choice) {
            case 1:
               
                Orozco.employees.add(new Programmer(id,name,lastName, salary, gender, birthDate, startDate, position));

                
                System.out.println("Programmer account added");
               

                break;
            case 2:
                Orozco.employees.add(new Accountant(id,name,lastName, salary, gender, birthDate, startDate, position));
                break;

             case 3:
                Orozco.employees.add(new Economy(id,name,lastName, salary, gender, birthDate, startDate, position));
                break;

             case 4:
                Orozco.employees.add(new NetworkTechnician(id,name,lastName, salary, gender, birthDate, startDate, position));
                break;

             case 5:
                Orozco.employees.add(new Manager(id,name,lastName, salary, gender, birthDate, startDate, position));
                break;

             case 6:
                Orozco.employees.add(new Receptionist(id,name,lastName, salary, gender, birthDate, startDate, position));
                break;

        }
    }

    public static void selectEmployee(Scanner input) {
    
        String employee;
        int index = 0;
        for(Employee e : Orozco.employees){
            System.out.println(String.format("%d. %s", index + 1,e.id));
            index++; 
            
        }
        Employee selectedEmployee;
        String id = questionAndInputString("Type id or name", input);
        for (Employee e: Orozco.employees){
            if (id.equals(e.id)){
                selectedEmployee = e;
                break;
            }
            
            
        }
        
            
    }

    public static void statistics(Scanner input) {

    }

}
