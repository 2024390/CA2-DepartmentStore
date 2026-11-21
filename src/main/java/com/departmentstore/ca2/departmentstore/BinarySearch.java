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
    public Employee search(ArrayList<Employee> employees,
            String name, int left, int right) {
        if (left > right){
            return null;
        }
        
        int middle = left + (right - left) / 2;
        int comparison = employees.get(middle).getName()
               .compareToIgnoreCase(name);
        
        if (comparison == 0) {
            return employees.get(middle);
        }
        
        if (comparison > 0) {
            return search(employees, name, left, middle - 1);
        } else {
            return search(employees, name, middle + 1, right);
        }
    }
}

