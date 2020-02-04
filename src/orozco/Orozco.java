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

    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        boolean running = true;

        while (running) {

            choice = Menus.choiceMethod("\n1. Add employee\n2. Select employee\n3. Statistics\n0. Exit\n\nChoice: ", 3, input);
            switch (choice) {

                case 1:
                    Menus.addEmployee(input);
                    break;
                case 2:
                    System.out.println(employees);
                    //Menus.selectEmployee(input);
                    break;
                case 3:
                    Menus.statistics(input);
                    break;
                case 0:
                    System.out.println("\nProgram shut down.");
                    running = false;
                    break;
                default:

            }

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


