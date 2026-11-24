/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;
import java.util.ArrayList;
/**
 *
 * @author maria
 */
public class BinarySearch {
    
    // It looks for an employee by name in a sorted list
    public Employee search(ArrayList<Employee> employees,
            String name, int left, int right) {
        
        // It stops the searching when the name is not found
        if (left > right){
            return null;
        }
        
        int middle = left + (right - left) / 2;
        
        // Match the names without considering uppercase or lowercase
        int comparison = employees.get(middle).getName()
               .compareToIgnoreCase(name);
        
        if (comparison == 0) {
            return employees.get(middle);
        }
        
        // Repeated searching from the left or right half 
        if (comparison > 0) {
            return search(employees, name, left, middle - 1);
        } else {
            return search(employees, name, middle + 1, right);
        }
    }
}

