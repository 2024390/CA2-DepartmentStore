/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maria
 */
public class EmployeeFileReader {
    
    public ArrayList<Employee> readEmployees(String fileName)
            throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        
        List<String> lines = Files.readAllLines(Path.of(fileName));
        
        for (int i = 1; i < lines.size(); i++) {
            
            String[] data = lines.get(i).split(",", -1);
            
            if (data.length == 9){
                
                String name = data[0].trim() + " " + data[1].trim();
                String department = data[5].trim();
                String managerType = data[7].trim();
                
                Employee employee = new Employee(
                name, managerType, department);
                
                employees.add(employee);
            }
        }
        return employees;
    }
}
