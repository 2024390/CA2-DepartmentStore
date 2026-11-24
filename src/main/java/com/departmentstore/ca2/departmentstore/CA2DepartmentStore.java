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
        EmployeeView view = new EmployeeView();
        
        try {
            ArrayList<Employee> employees =
                    reader.readEmployees("Applicants_Form.txt");
            
            ArrayList<Employee> addedEmployees = new ArrayList<>();
            
            System.out.println("File read correctly");
            System.out.println("Total employees: " + employees.size());
            
            boolean running = true;
            
            while (running) {
                System.out.println("------------------------------------------");
                System.out.println(" - Department Store Employee Management - ");
                System.out.println("------------------------------------------");
                view.displayMenu();
                
                
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
                        
                        System.out.println("First 20 employees:");
                        
                        int limit = Math.min(20, employees.size());
                        
                        for (int i = 0; i < limit; i++) {
                            System.out.println((i + 1) + " . "
                            + employees.get(i).getName());
                        }
                        break;
                        
                    case SEARCH:
                        System.out.println("Type employee name: ");
                        String name = scanner.nextLine().trim();
                        
                        if (name.isEmpty()){
                            System.out.println("Please type a name");
                            break;
                        }
                        
                        MergeSort searchSorter = new MergeSort();
                        searchSorter.mergeSort(employees);
                        
                        BinarySearch binarySearch = new BinarySearch();
                        
                        Employee found = binarySearch.search(
                        employees, name, 0, employees.size() - 1);
                        
                        if (found != null){
                            System.out.println("Employee founded!");
                            view.displayEmployee(found);
                        } else {
                            System.out.println("Employee not found");
                        }
                        break;
                        
                    case ADD_RECORDS:
                        System.out.println("=== Add new Employee to the list ===");
                        
                        System.out.println("Type employee name: ");
                        String newName = scanner.nextLine().trim();
                        
                        if (newName.isEmpty()){
                            System.out.println("Please enter a valid name");
                        
                        break;
                        }
                        
                        String[] managerTypes = {
                            "Store Manager",
                            "Senior Manager",
                            "Department Manager",
                            "Team Lead",
                            "Staff"
                        };
                        System.out.println("Select Manager Type: ");
                        for (int i =0; i < managerTypes.length; i++){
                            System.out.println((i + 1) + " . " + managerTypes[i]);
                        }
                        System.out.println("Enter your choice: ");
                        String input = scanner.nextLine();
                        
                        try {
                            int managerChoice = Integer.parseInt(input);
                            
                            if (managerChoice < 1 || managerChoice > managerTypes.length){
                                System.out.println("    Incorrect Manager Type");
                                break;
                        }
                            String selectedManager = managerTypes[managerChoice - 1];
                            
                            System.out.println("Selected Manager Type: "
                            + selectedManager);
                            
                          ArrayList<String> departments = new ArrayList<>();
                          for (Employee employee : employees){
                              String department = employee.getDepartment();
                              
                              if (!departments.contains(department)){
                                  departments.add(department);
                              }
                          }
                          
                            System.out.println("Select any Department: ");
                            
                            for (int i = 0; i < departments.size(); i++){
                                System.out.println((i + 1) + " . " + departments.get(i));
                            }
                            System.out.println("Type department option: ");
                            String departmentInput = scanner.nextLine();
                            
                            try {
                                int departmentChoice = Integer.parseInt(departmentInput);
                                
                                if (departmentChoice < 1 ||
                                        departmentChoice > departments.size()){
                                    System.out.println("Incorrect department choice");
                                    break;
                                }
                                
                                String selectedDepartment = 
                                        departments.get(departmentChoice - 1);
                                System.out.println("Chosen Department: "
                                + selectedDepartment);
                                
                                Employee newEmployee = new Employee(
                                newName, selectedManager, selectedDepartment);
                                
                                employees.add(newEmployee);
                                addedEmployees.add(newEmployee);
                                
                                System.out.println("Employee details added succesfully");
                                System.out.println("Name: " + newEmployee.getName());
                                System.out.println("Manager Type:" + newEmployee.getManagerType());
                                System.out.println("Department: " + newEmployee.getDepartment());
                                
                                System.out.println("=== New team members ===");
                                
                                for (Employee employee : addedEmployees){
                                    System.out.println("Name: " + employee.getName());
                                    System.out.println("Manager Type: " + employee.getManagerType());
                                    System.out.println("Department: " + employee.getDepartment());
                                    System.out.println("========================");
                                }
                            } catch (NumberFormatException e){
                                System.out.println("Please type a correct department number");
                            }
                            
                        } catch (NumberFormatException e){
                            System.out.println("Please type a valid number");
                        }
                        break;
                        
                        
                    
                    case CREATE_TREE:
                        System.out.println("Generating Binary Tree...");
                        
                        BinaryTree tree = new BinaryTree();
                        
                        int total = Math.min(20, employees.size());
                        
                        for (int i =0; i < total; i++){
                            tree.insert(employees.get(i));
                        }
                        
                        System.out.println("Added " + total
                        + " employees into the Binary Tree");
                        
                        tree.displayLevelOrder();
                        System.out.println("Total nodes: " + tree.countNodes());
                        System.out.println("Tree height (levels): " + tree.getHeight());
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
