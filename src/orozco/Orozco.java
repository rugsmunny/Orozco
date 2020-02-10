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

        
        boolean running = true;
        Employee programmer1 = new Programmer("1", "Kalle", "Jansson", 12000, Employee.genders.man, "750310", 20200202, Employee.positions.worker);
        Employee programmer2 = new Programmer("2", "Janne", "Jansson", 15000, Employee.genders.woman, "550310", 20200202, Employee.positions.worker);
        Employee programmer3 = new Programmer("3", "Damian", "Jansson", 25000, Employee.genders.man, "650310", 20200202, Employee.positions.worker);
        Employee programmer4 = new Programmer("4", "Dessie", "Jansson", 50000, Employee.genders.nonbinary, "850310", 20200202, Employee.positions.worker);

        Orozco.employees.add(programmer1);
        Orozco.employees.add(programmer2);
        Orozco.employees.add(programmer3);
        Orozco.employees.add(programmer4);

        while (running) {

           
            switch (Menus.choiceMethod(new String[] {"Add employee", "Select employee", "Statistics"}, input, true)) {

                case 1:
                    Menus.clearScreen();
                    Menus.addEmployee(input);
                    break;
                case 2:
                   Menus.clearScreen();
                    Menus.selectEmployee(input);
                    break;
                case 3:
                    Menus.clearScreen();
                    Menus.statistics(input);
                    
                    break;
                case 0:
                    Menus.clearScreen();
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


