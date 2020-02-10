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

    //public static String setName() {
    //}
    public static int choiceMethod(String[] choices, Scanner input, boolean back) {
        int choice;
        while (true) {

            String question = "";

            question = listChoices(choices);

            if (back == true) {
                if (choices[0].equals("Add employee")) {
                    question += "\n0. Exit";
                } else {
                    question += "\n0. Back";
                }

            }

            question += "\n\nChoice: ";

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
        if (Orozco.employees.isEmpty()) {
            return id;

        }
        while (true) {

            for (Employee e : Orozco.employees) {
                System.out.println(id + " " + e.id);
                if (e.id.equals(tempid)) {

                    tempid = id;
                    duplicates += 1;
                    tempid += duplicates;
                    break;
                }

            }
            return tempid;
        }
    }

    public static void chooseName(Employee employee, Scanner input) {
        String name;
        while (true) {
            clearScreen();
            name = questionAndInputString("Name", input);
            if (name.length() < 2) {
                continue;
            }
            try {
                Integer.parseInt(name);
            } catch (Exception e) {
                employee.setName(name);
                break;
            }
        }
    }

    public static void chooseLastName(Employee employee, Scanner input) {
        String lastName;
        while (true) {
            clearScreen();
            lastName = questionAndInputString("Last Name", input);
            if (lastName.length() < 2) {
                continue;
            }
            try {
                Integer.parseInt(lastName);
            } catch (Exception e) {
                employee.setLastName(lastName);
                break;
            }
        }
    }

    public static void chooseGender(Employee employee, Scanner input) {
        switch (choiceMethod(new String[]{"Man", "Woman", "NonBinary"}, input, false)) {
            case 1:
                employee.setGender(Employee.genders.man);
                break;
            case 2:
                employee.setGender(Employee.genders.woman);
                break;
            case 3:
                employee.setGender(Employee.genders.nonbinary);
                break;
        }

    }

    public static void choosePosition(Employee employee, Scanner input) {
        switch (choiceMethod(new String[]{"Worker", "Local manager"}, input, false)) {
            case 1:
                employee.setPosition(Employee.positions.worker);
                break;
            case 2:
                employee.setPosition(Employee.positions.localManager);
                break;
        }
    }

    public static void addEmployee(Scanner input) {
        Employee employee = null;
        switch (choiceMethod(Orozco.departments, input, false)) {
            case 1:
                clearScreen();
                employee = new Programmer();

                System.out.println("Programmer account added");

                break;
            case 2:
                clearScreen();
                employee = new Accountant();
                System.out.println("Accountant account added");
                break;

            case 3:
                clearScreen();
                employee = new Economy();
                System.out.println("Economy account added");
                break;

            case 4:
                clearScreen();
                employee = new NetworkTechnician();
                System.out.println("NetworkTechnician account added");
                break;

            case 5:
                clearScreen();
                employee = new Manager();
                System.out.println("Manager account added");
                break;

            case 6:
                clearScreen();
                employee = new Receptionist();
                System.out.println("Receptionist account added");
                break;
        }

        chooseName(employee, input);
        chooseLastName(employee, input);
        chooseGender(employee, input);
        choosePosition(employee, input);
        employee.setSalary(questionAndInputInt("Salary", input));

        employee.setId(checkForDuplicateId(employee.name + employee.lastName.substring(0, 2)).toLowerCase());

        employee.setBirthDate(questionAndInputString("Birth date (YYYYMMDD)", input));
        employee.setStartDate(questionAndInputInt("\nStart date (YYYYMMDD)", input));
        Orozco.employees.add(employee);

    }

    public static void employeeOptions(Employee e, Scanner input) {
        boolean looping = true;
        while (looping) {

            clearScreen();

            switch (choiceMethod(new String[]{"Get all info", "Change Info", "Delete"}, input, true)) {
                case 1:
                    clearScreen();
                    System.out.println(e.getInfo());
                    break;
                case 2:
                    clearScreen();
                    boolean changing = true;
                    while (changing) {
                        switch (choiceMethod(new String[]{"Name", "Last Name", "Gender", "Salary", "Birthdate", "Startdate", "Position"}, input, true)) {
                            case 1:
                                chooseName(e, input);
                                break;
                            case 2:
                                chooseLastName(e, input);
                                break;

                            case 3:
                                chooseGender(e, input);

                            case 4:
                                e.setSalary(questionAndInputInt("Salary", input));
                                break;

                            case 5:
                                choosePosition(e, input);

                            case 6:
                                e.setBirthDate(questionAndInputString("Birth date (YYYYMMDD)", input));
                                break;

                            case 7:
                                e.setStartDate(questionAndInputInt("\nStart date (YYYYMMDD)", input));
                                break;

                            case 0:
                                changing = false;

                        }
                    }

                    break;
                case 3:
                    clearScreen();
                    System.out.println("Are you sure you want to delete this employee?");
                    if (choiceMethod(new String[]{"Yes", "No"}, input, false) == 1) {

                        Orozco.employees.remove(e);
                    }

                case 0:
                    looping = false;
                    break;
            }

        }

    }

    public static void selectEmployee(Scanner input) {
        boolean selectingEmployee = true;
        while (selectingEmployee == true) {
            clearScreen();
            String employee;
            int index = 1;
            for (Employee e : Orozco.employees) {
                System.out.print(String.format("\n%d. %s", index, e.name));
                index++;

            }
            System.out.println("\n0. Back");
            Employee selectedEmployee = null;
            if (!Orozco.employees.isEmpty()) {
                
                String id = questionAndInputString("\nType id or name", input);
                if (id.equals("0")){
                    selectingEmployee = false;
                }
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
            } else {
                System.out.println("No employees exist");
            }

        }

    }



public static void statistics(Scanner input) {
        clearScreen();
        boolean looping = true;
        while (looping == true) {
            switch (Menus.choiceMethod(new String[]{"Gender", "Wages"}, input, true)) {

                case 1:
                    clearScreen();
                    //getGenderCount(Menus.choiceMethod(new String[]{"Men", "Women", "Non Binary"}, input, true));
                    getGenderCount();

                    break;
                case 2:
                    clearScreen();
                    getSalary(Menus.choiceMethod(new String[]{"Highest salary", "Lowest salary", "Average salary"}, input, true));
                    break;
                case 0:
                    looping = false;
            }
        }

    }

//    public static int getGenderStats(){
//        Orozco.employees.stream().collect(Collector.)
//    }
    public static void getGenderCount() {

        Employee.genders gender = null;
        String genDer = null;

        int men = 0;
        int women = 0;
        int nonbinary = 0;

        for (Employee e : Orozco.employees) {
            if (e.gender.equals(Employee.genders.man)) {
                men++;
            }
            if (e.gender.equals(Employee.genders.woman)) {
                women++;
            }
            if (e.gender.equals(Employee.genders.nonbinary)) {
                nonbinary++;
            }
        }

        int total = women + men + nonbinary;

        float menpercent = ((float) men / (float) total) * 100;
        float womenpercent = ((float) women / (float) total) * 100;
        float nonbinarypercent = ((float) nonbinary / (float) total) * 100;

        System.out.println(String.format("Number of men is: %d(%.1f%%)\nNumber of women is: %d(%.1f%%)\nNumber of nonbinary is: %d(%.1f%%)", men, menpercent, women, womenpercent, nonbinary, nonbinarypercent));

    }

    public static void getSalary(int salaryChoice) {
        int salary = 0;

        switch (salaryChoice) {
            case 1:
                for (Employee e : Orozco.employees) {
                    if (salary < e.salary) {
                        salary = e.salary;
                    }

                }
                clearScreen();
                System.out.println("Highest company salary is " + salary);
                break;
            case 2:
                for (Employee e : Orozco.employees) {
                    if (salary == 0 || salary > e.salary) {
                        salary = e.salary;
                    }

                }
                clearScreen();
                System.out.println("Lowest company salary is " + salary);
                break;
            case 3:
                for (Employee e : Orozco.employees) {

                    salary += e.salary;

                }
                clearScreen();
                System.out.println("Average company salary is " + (salary / Orozco.employees.size()));
                break;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
