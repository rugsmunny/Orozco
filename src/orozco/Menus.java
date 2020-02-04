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
                System.out.print("\nName: ");
                String name = input.nextLine();
                System.out.print("\nSalary: ");
                int salary = input.nextInt();
                System.out.println("\nGender: Man - Woman - NonBinary\n\nAnswer: ");
                String sex = input.nextLine().toLowerCase();
                Employee.genders gender = Employee.genders.valueOf(sex);
                int id = Orozco.employees.size();
                System.out.print("\nStart date (YYYYMMDD)\n\n: ");
                int date = input.nextInt();
                System.out.print("\nPosition:\n\n1. Worker.\n2. Local manager.\n\nType in your answer: ");
                Employee.positions position = Employee.positions.valueOf(input.nextLine().toLowerCase());
                
                Employee programmer = new Programmer(name, salary, gender, 21, id, date, position);
                
                Orozco.employees.add(programmer);
                
                
                
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
        System.out.println("");

    }

    public static void statistics(Scanner input) {

    }
    
    
}
