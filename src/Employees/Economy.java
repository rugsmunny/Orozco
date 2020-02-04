/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employees;

/**
 *
 * @author admusr
 */
public class Economy extends Employee{
    public Economy(){
        salary = 25000;
        gender = genders.Man;
        age = 50;
        name = "göran";
        System.out.println(getInfo());
    }
}
