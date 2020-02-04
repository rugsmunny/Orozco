/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees;

/**
 *
 * @author karim
 */


public abstract class Employee {
    public String name;
    public int salary;

    public enum genders{
        man,woman,nonbinary
    }
    public enum positions{
        worker, localManager
    }
    public genders gender; 
    public int age;
    public int id;
    public int monthsInDuty;
    public positions position;
    

    public String getInfo(){
        return String.format("Id: %d Name: %s Salary: %d Age: %d Gender: %s Months in duty: %d",id,name, salary,age,gender,monthsInDuty);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonthsInDuty() {
        return monthsInDuty;
    }

    public void setMonthsInDuty(int monthsInDuty) {
        this.monthsInDuty = monthsInDuty;
    }
    
    
    


    public positions getPosition() {
        return position;
    }

    public void setPosition(positions position) {
        this.position = position;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public genders getGender() {
        return gender;
    }

    public void setGender(genders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
   
    
}
