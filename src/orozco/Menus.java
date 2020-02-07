/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orozco;

import Employees.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author admusr
 */
public class Menus {

    public static String listChoices(String[] choices) {
        String question = "";
        for (int i = 0; i < choices.length; i++) {
            question += "\n" + (i + 1) + ". " + choices[i];

        }
        return question;
    }

    public static int choiceMethod(String[] choices, Scanner input,boolean back) {
        int choice;
        while (true) {

            String question = "";

            question = listChoices(choices);
            question += "\n0. Back";
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
        String inputString;
        while (true) {
            System.out.print("\n" + question + ": ");
            try {
                inputString = input.nextLine();
                if (!inputString.equals("")) {
                    return inputString;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static int questionAndInputInt(String question, Scanner input) {
        while (true) {
            System.out.print("\n" + question + ": ");
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static String checkForDuplicateId(String id) {
        int duplicates = 0;
        String tempid = id;
        int index;
        if (Orozco.employees.isEmpty()) {
            return id;
        }
        while (true) {
            index = 0;
            for (Employee e : Orozco.employees) {
                index += 1;
                if (e.id.equals(tempid)) {

                    tempid = id;
                    duplicates += 1;
                    tempid += duplicates;
                    break;
                }
                if (index == Orozco.employees.size()) {
                    return tempid;
                }

            }
        }
    }

    public static void addEmployee(Scanner input) {

        String name;
        while (true) {

            name = questionAndInputString("Name", input);
            try {
                Integer.parseInt(name);
            } catch (Exception e) {
                break;
            }
        }

        String lastName;
        while (true) {

            lastName = questionAndInputString("Last Name", input);
            try {
                Integer.parseInt(lastName);
            } catch (Exception e) {
                break;
            }
        }

        int salary = questionAndInputInt("Salary", input);
        Employee.genders gender = null;

        switch (choiceMethod(new String[]{"Man", "Woman", "NonBinary"}, input,false)) {
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
        int positionChoice = choiceMethod(new String[]{"Worker", "Local manager"}, input,false);
        switch (positionChoice) {
            case 1:
                position = Employee.positions.worker;
            case 2:
                position = Employee.positions.localManager;

        }

        switch (choiceMethod(Orozco.departments, input,false)) {
            case 1:

                Orozco.employees.add(new Programmer(id, name, lastName, salary, gender, birthDate, startDate, position));

                System.out.println("Programmer account added");

                break;
            case 2:
                Orozco.employees.add(new Accountant(id, name, lastName, salary, gender, birthDate, startDate, position));
                break;

            case 3:
                Orozco.employees.add(new Economy(id, name, lastName, salary, gender, birthDate, startDate, position));
                break;

            case 4:
                Orozco.employees.add(new NetworkTechnician(id, name, lastName, salary, gender, birthDate, startDate, position));
                break;

            case 5:
                Orozco.employees.add(new Manager(id, name, lastName, salary, gender, birthDate, startDate, position));
                break;

            case 6:
                Orozco.employees.add(new Receptionist(id, name, lastName, salary, gender, birthDate, startDate, position));
                break;

        }
    }

    public static void employeeOptions(Employee e, Scanner input) {
        boolean looping = true;
        while (looping) {

            switch (choiceMethod(new String[]{"Get all info", "Chanage Info", "Delete"}, input,true)) {
                case 1:
                    System.out.println(e.getInfo());
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Are you sure you want to delete this employee?");
                    if(choiceMethod(new String[] {"Yes","No"}, input, false) == 1){
                        
                        Orozco.employees.remove(e);
                    }
                    
                    
                    
                case 0:
                    looping = false;
                    break;
            }

        }

    }

    public static void selectEmployee(Scanner input) {

        Employee programmer1 = new Programmer("1", "Kalle" , "Jansson", 12000, Employee.genders.man, "750310", 20200202, Employee.positions.worker);
        Employee programmer2 = new Programmer("2", "Janne" , "Jansson", 12000, Employee.genders.man, "550310", 20200202, Employee.positions.worker);
        Employee programmer3 = new Programmer("3", "Damian" , "Jansson", 12000, Employee.genders.man, "650310", 20200202, Employee.positions.worker);
        Employee programmer4 = new Programmer("4", "Dessie" , "Jansson", 12000, Employee.genders.man, "850310", 20200202, Employee.positions.worker);
       
        
        Orozco.employees.add(programmer1);
        Orozco.employees.add(programmer2);
        Orozco.employees.add(programmer3);
        Orozco.employees.add(programmer4);
//        System.out.println(Orozco.employees);
        Orozco.employees.stream().forEach((Employee e) -> {
            System.out.println(e.getInfo());
            
        });
            

        String employee;
        int index = 0;
        for (Employee e : Orozco.employees) {
            System.out.println(String.format("%d. %s", index + 1, e.id));
            index++;

        }
        Employee selectedEmployee = null;
        if (!Orozco.employees.isEmpty()) {
            String id = questionAndInputString("Type id or name", input);

            try {

                selectedEmployee = Orozco.employees.get(Integer.parseInt(id) - 1);
            } catch (Exception ex) {
                for (Employee e : Orozco.employees) {
                    if (id.equals(e.id)) {
                        selectedEmployee = e;
                        break;
                    }
                }
            }
            if (selectedEmployee != null) {
                employeeOptions(selectedEmployee, input);
            }
        }
        else{
            System.out.println("No employees exist");
        }


    }

    public static void statistics(Scanner input) {

    }

}
