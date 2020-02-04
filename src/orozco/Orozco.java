/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import Employees.*;
import Employees.Employee.genders;
import Employees.Employee.positions;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author karim
 */
public class Orozco {

    /**
     * @param args the command line arguments
     */
    public static String[] departments = {"Programmer", "Accountant", "Economy", "NetworkTechnician", "Manager", "Receptionist"};

    public ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        boolean running = true;

        while (running) {
            while (true) {

                System.out.print("1. Add employee\n2. Select employee\n3. Statistics\n0. Exit\n\nChoice: ");

                try {
                    choice = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {

                    System.out.println("\nEtt fel uppstod, försök igen. \n");

                    while (running) {
                        choice = Menus.choiceMethod("1. Add employee\n2. Select employee\n3. Statistics\n0. Exit\n\nChoice: ", 3, input);
                        switch (choice) {

                            case 1:
                                Menus.addEmployeeChoices(input);
                            case 2:

                            case 3:

                            case 0:
                                running = false;
                            default:

                        }

                        switch (choice) {
                            case 1:
//                Add employee
                            case 2:
//                Select employee
                            case 3:
//                Statistics
                            case 0:
                                running = false;
                                System.out.println("Program shut down.");
                            default:

                        }


                        /*        
                         Add employee
        
                         Type:
        
                         Accountant - Manager - NetworkTechnician - Programmer - Receptionist - Economy
                
                         - setStartDate 
                         - setDepartment 
                         - setSalary 
                         - setSex 
                         - setAge
                         - setPosition
        
                         Select employee 
        
                         ID - Name:
                 
                         • Update 
                         - setStartDate 
                         - setDepartment 
                         - setSalary 
                         - setSex 
                         - setAge
                         • Show information
                         - getStartDate 
                         - getDepartment 
                         - getSalary 
                         - getSex 
                         - getAge
                         • Remove 
        
                    
                         Statistics
                    
                         sort by: 
                         departe
                         Salary - Years in duty - Age - Sex
                         list:
                         total - per department
                

                         */
                    }

                }

            }
        }
    }
}
