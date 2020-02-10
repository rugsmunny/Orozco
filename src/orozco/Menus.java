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
                question += "\n0. Back";
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

            }
            return tempid;
        }
    }

    public static void addEmployee(Scanner input) {

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
                break;
            }
        }

        String lastName = "";
        while (true) {
            clearScreen();
            lastName = questionAndInputString("Last Name", input);
            if (lastName.length() < 2) {
                continue;
            }
            try {
                Integer.parseInt(lastName);
            } catch (Exception e) {
                break;
            }
        }
        clearScreen();
        int salary = questionAndInputInt("Salary", input);
        Employee.genders gender = null;


        clearScreen();

        switch (choiceMethod(new String[]{"Man", "Woman", "NonBinary"}, input, false)) {
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
        clearScreen();
        Employee.positions position = null;
        int positionChoice = choiceMethod(new String[]{"Worker", "Local manager"}, input, false);
        switch (positionChoice) {
            case 1:
                position = Employee.positions.worker;
            case 2:
                position = Employee.positions.localManager;

        }

        switch (choiceMethod(Orozco.departments, input, false)) {
            case 1:
                clearScreen();
                Orozco.employees.add(new Programmer(id, name, lastName, salary, gender, birthDate, startDate, position));

                System.out.println("Programmer account added");

                break;
            case 2:
                clearScreen();
                Orozco.employees.add(new Accountant(id, name, lastName, salary, gender, birthDate, startDate, position));
                System.out.println("Accountant account added");
                break;

            case 3:
                clearScreen();
                Orozco.employees.add(new Economy(id, name, lastName, salary, gender, birthDate, startDate, position));
                System.out.println("Economy account added");
                break;

            case 4:
                clearScreen();
                Orozco.employees.add(new NetworkTechnician(id, name, lastName, salary, gender, birthDate, startDate, position));
                System.out.println("NetworkTechnician account added");
                break;

            case 5:
                clearScreen();
                Orozco.employees.add(new Manager(id, name, lastName, salary, gender, birthDate, startDate, position));
                System.out.println("Manager account added");
                break;

            case 6:
                clearScreen();
                Orozco.employees.add(new Receptionist(id, name, lastName, salary, gender, birthDate, startDate, position));
                System.out.println("Receptionist account added");
                break;

        }
    }

    public static void employeeOptions(Employee e, Scanner input) {
        boolean looping = true;
        while (looping) {

            clearScreen();

            switch (choiceMethod(new String[]{"Get all info", "Chanage Info", "Delete"}, input, true)) {
                case 1:
                    clearScreen();
                    System.out.println(e.getInfo());
                    break;
                case 2:
                    clearScreen();
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
clearScreen();
        String employee;
        int index = 1;
        for (Employee e : Orozco.employees) {
            System.out.print(String.format("\n%d. %s", index, e.name));
            index++;

        }
        Employee selectedEmployee = null;
        if (!Orozco.employees.isEmpty()) {
            String id = questionAndInputString("\nType id or name", input);

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

    public static void statistics(Scanner input) {
clearScreen();
        switch (Menus.choiceMethod(new String[]{"Gender", "Wages"}, input, true)) {

            case 1:
clearScreen();
                getGenderCount(Menus.choiceMethod(new String[]{"Men", "Women", "Non Binary"}, input, true));
                break;
            case 2:
clearScreen();
                getSalary(Menus.choiceMethod(new String[]{"Highest salary", "Lowest salary", "Average salary"}, input, true));
                break;
            case 3:
                break;
        }
    }

//    public static int getGenderStats(){
//        Orozco.employees.stream().collect(Collector.)
//    }
    public static void getGenderCount(int genderChoice) {

        Employee.genders gender = null;
        String genDer = null;
        switch (genderChoice) {
            case 1:
                gender = Employee.genders.man;
                genDer = "men";
                break;
            case 2:
                gender = Employee.genders.woman;
                genDer = "women";
                break;
            case 3:
                gender = Employee.genders.nonbinary;
                genDer = "nonbinaries";
                break;
        }

        int num = 0;
        for (Employee e : Orozco.employees) {

            if (e.gender.equals(gender)) {

                num += 1;

            }

        }
        clearScreen();
        System.out.println("Total number of " + genDer + " is " + num);

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
