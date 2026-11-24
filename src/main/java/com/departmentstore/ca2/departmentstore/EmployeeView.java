/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;

/**
 *
 * @author maria
 */
public class EmployeeView {
    
    public void displayMenu() {
        
        for (MenuOption option : MenuOption.values()){
            System.out.println(option.getNumber() + " . "
            + option.getDescription());
            
        }
}
    public void displayEmployee(Employee employee){
        System.out.println("Name: " + employee.getName());
        System.out.println("Job Title: " + employee.getManagerType());
        System.out.println("Department: "
        + employee.getDepartment());
    }
}
