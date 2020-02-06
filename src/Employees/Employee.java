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
    public String lastName;
    public int salary;
     
    public genders gender; 

    public String id;
    public int startDate;
    public String birthDate;
    public positions position;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    public enum genders{
        man,woman,nonbinary
    }
    public enum positions{
        worker, localManager
    }
   
    

    public String getInfo(){
        return String.format("Id: %s Name: %s Salary: %d Birthdate: %s Gender: %s Months in duty: %d",id,name, salary,birthDate,gender,startDate);
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
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

      public Employee(String id,String name,String lastName, int salary, genders gender, String birthDate, int startDate, positions position) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
        this.startDate = startDate;
        this.position = position;
        
        
    }
    
    
   
    
}
