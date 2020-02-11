/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees;

import BonusFolder.AnnualBonusChart;
import BonusFolder.WorkingHolidayBonus;

/**
 *
 * @author admusr
 */

public class Programmer extends Employee implements AnnualBonusChart, WorkingHolidayBonus{

    public Programmer() {
        
    

    }
    
    @Override
     public void setSalary(int salary) {
        this.salary = salary;
        this.bonus = this.salary*annualBonus+this.salary*workingHolidayBonus;
        
    }
     
     @Override
    public String getInfo(){
        return String.format("\nId: %s\n Name: %s\n Last Name: %s\n Salary: %d - Bonus: %.2f\n Date of birth: %s\n Gender: %s\n Department: %s\n Position: %s\n Start date: %d\n",id,name,lastName,salary,bonus,birthDate,gender,getClass().getName(),position,startDate);
    }

   
}
