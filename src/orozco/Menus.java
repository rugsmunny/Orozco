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

    public static int choiceMethod(String question, int numberOfChoices, Scanner input) {
        int choice;
        while (true) {

            System.out.print(question);

            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice == 0 || choice <= numberOfChoices) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError. Please try again.");

            }
        }
    }

    public static String questionAndInputString(String question, Scanner input) {
        while (true){
            System.out.print(question);
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
            System.out.print(question);
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

        String question = "\n";
        int choice;
        for (int i = 0; i < Orozco.departments.length; i++) {
            question += i + 1 + ". " + Orozco.departments[i] + "\n";
        }
        question += "\n0. Back\n\nChoice: ";
        String name = questionAndInputString("\nName: ", input);
        
        String lastName = questionAndInputString("\nLast Name:", input);
        
        int salary = questionAndInputInt("\nSalary: ", input);
        
        int sexChoice = choiceMethod("\nGender: \n1. Man\n2. Woman\n3. NonBinary\n\nAnswer: ", 3, input);
        
        Employee.genders gender = null;
        switch (sexChoice) {
            case 1:
                gender = Employee.genders.man;
            case 2:
                gender = Employee.genders.woman;
            case 3:
                gender = Employee.genders.nonbinary;
        }
        
   
        
        String id = checkForDuplicateId(name + lastName.substring(0, 2));
        String birthDate = questionAndInputString("\nBirth date (YYYYMMDD)\n\n", input);
        int startDate = questionAndInputInt("\nStart date (YYYYMMDD)\n\n: ", input);

        Employee.positions position = null;
        int positionChoice = questionAndInputInt("\nPosition:\n\n1. Worker.\n2. Local manager.\n\nType in your answer: ", input);
        switch (positionChoice) {
            case 1:
                position = Employee.positions.worker;
            case 2:
                position = Employee.positions.localManager;

        }

        choice = choiceMethod(question, Orozco.departments.length, input);
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
        
        employee = questionAndInputString("Type id or name: ", input);
        
            
    }

    public static void statistics(Scanner input) {

    }

}
