/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.departmentstore.ca2.departmentstore;

import java.util.ArrayList;
import java.io.IOException;
/**
 *
 * @author maria
 */
public class CA2DepartmentStore {

    public static void main(String[] args) {
        
        EmployeeFileReader reader = new EmployeeFileReader();
        
        try {
            ArrayList<Employee> employees =
                    reader.readEmployees("Applicants_Form.txt");
            
            System.out.println("File read correctly");
            System.out.println("Total employees: " + employees.size());
            
            for (Employee employee : employees) {
                
                System.out.println(
                employee.getName() + " | "
                + employee.getManagerType() + " | "
                + employee.getDepartment());
            }
        } catch (IOException e){
            System.out.println("Error reading the file.");
        }
    }
}
