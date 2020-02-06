/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import Employees.Employee;
import Employees.Programmer;
import java.util.Calendar;
import java.util.Scanner;
import java.util.function.Consumer;

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
        System.out.print(question);
        return input.nextLine();
    }

    public static int questionAndInputInt(String question, Scanner input) {
        System.out.print(question);
        return Integer.parseInt(input.nextLine());
    }

    public static void addEmployee(Scanner input) {

        String question = "\n";
        int choice;
        for (int i = 0; i < Orozco.departments.length; i++) {
            question += i + 1 + ". " + Orozco.departments[i] + "\n";
        }
        question += "\n0. Back\n\nChoice: ";
        choice = choiceMethod(question, Orozco.departments.length, input);
        switch (choice) {
            case 1:
                String name = questionAndInputString("\nName: ", input);
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
                int id = Orozco.employees.size();
                
                int date = questionAndInputInt("\nStart date (YYYYMMDD)\n\n: ", input);
                
                Employee.positions position = null;
                int positionChoice = questionAndInputInt("\nPosition:\n\n1. Worker.\n2. Local manager.\n\nType in your answer: ", input);
                switch (positionChoice) {
                    case 1:
                        position = Employee.positions.worker;
                    case 2:
                        position = Employee.positions.localManager;
                    
                }

                Employee programmer = new Programmer(name, salary, gender, 21, id, date, position);

                Orozco.employees.add(programmer);
                System.out.println("Programmer account added");

                break;
            /* case 2:
             System.out.println("\nAccountant");
             case 3:
             System.out.println("\nEconomy");
             case 4:
             System.out.println("\nNetworkTechnician");
             case 5:
             System.out.println("\nManager");
             case 6:
             System.out.println("\nReceptionist");*/
            default:

        }
    }

    public static void selectEmployee(Scanner input) {
        Employee programmer1 = new Programmer("Kalle", 55555, Employee.genders.man, 21, 0, 20200202, Employee.positions.localManager);
        Employee programmer2 = new Programmer("Jalle", 55555, Employee.genders.man, 21, 1, 20200202, Employee.positions.localManager);
        Employee programmer3 = new Programmer("Alle", 55555, Employee.genders.man, 21, 2, 20200202, Employee.positions.localManager);
        Employee programmer4 = new Programmer("Malle", 55555, Employee.genders.man, 21, 3, 20200202, Employee.positions.localManager);
        
        Orozco.employees.add(programmer1);
        Orozco.employees.add(programmer2);
        Orozco.employees.add(programmer3);
        Orozco.employees.add(programmer4);
//        System.out.println(Orozco.employees);
        Orozco.employees.stream().forEach((Employee e) -> {
            System.out.println(e.getInfo());
            
        });
            
    }

    public static void statistics(Scanner input) {

    }

}
