/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.departmentstore.ca2.departmentstore;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author maria
 */
public class CA2DepartmentStore {

    public static void main(String[] args) {
        
        EmployeeFileReader reader = new EmployeeFileReader();
        Scanner scanner = new Scanner(System.in);
        
        try {
            ArrayList<Employee> employees =
                    reader.readEmployees("Applicants_Form.txt");
            
            System.out.println("File read correctly");
            System.out.println("Total employees: " + employees.size());
            
            boolean running = true;
            
            while (running) {
                System.out.println("\n==== Department Store Employee Management ====");
                
                for (MenuOption option : MenuOption.values()) {
                    System.out.println(option.getNumber() + " . "
                    + option.getDescription());
                }
                
                System.out.println("Select your option: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Incorrect option.");
                    scanner.nextLine();
                    continue;
                }
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                MenuOption selectedOption = null;
                
                for (MenuOption option : MenuOption.values()){
                    if (option.getNumber() == choice){
                        selectedOption = option;
                        break;
                    }
                }
                
                if (selectedOption == null){
                    System.out.println("Incorrect option");
                    continue;
                }
                
                switch (selectedOption){
                    
                    case SORT:
                        System.out.println("Sorting employees by order alphabetically...");
                        
                        MergeSort sorter = new MergeSort();
                        sorter.mergeSort(employees);
                        
                        System.out.println("\nFirst 20 employees:");
                        
                        int limit = Math.min(20, employees.size());
                        
                        for (int i = 0; i < limit; i++) {
                            System.out.println((i + 1) + " . "
                            + employees.get(i).getName());
                        }
                        break;
                        
                    case SEARCH:
                        System.out.println("Search selected");
                        break;
                        
                    case ADD_RECORDS:
                        System.out.println("Add records selected");
                        break;
                    
                    case CREATE_TREE:
                        System.out.println("Create binary tree selected");
                        break;
                        
                    case EXIT:
                        System.out.println("Closing application now...");
                        running = false;
                        break;
                }
            }
            
        } catch (IOException e){
            System.out.println("Failure reading the file.");
        }
        
        scanner.close();
        
    }
}
