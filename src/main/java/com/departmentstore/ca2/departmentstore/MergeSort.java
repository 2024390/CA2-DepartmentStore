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
public class MergeSort {
    
    // Sorts employee names from A to Z
    public void mergeSort(ArrayList<Employee> employees){
        
        // It stop splitting when the list has one or no employee
        if (employees.size() <= 1){
            return;
        }
        
        int middle = employees.size() / 2;
        
        // Separate the list into two halves 
        ArrayList<Employee> left = new ArrayList<>(
        employees.subList(0, middle));
        
        ArrayList<Employee> right = new ArrayList<>(
        employees.subList(middle, employees.size()));
        
        mergeSort(left);
        mergeSort(right);
        
        // Incorporate the sorted halves
        merge(employees, left, right);
    }
    
    private void merge(ArrayList<Employee> employees,
            ArrayList<Employee> left,
            ArrayList<Employee> right){
        
        int i = 0;
        int j = 0;
        int k =0;
    
        // Compares employee names and puts them in order
    while (i < left.size() && j < right.size()){
        if (left.get(i).getName().compareToIgnoreCase(
        right.get(j).getName()) <= 0) {
            
            employees.set(k, left.get(i));
            i++;
        } else {
            employees.set(k, right.get(j));
            j++;
        }
        
        k++;
    }
    // Add the remaining employees in either half
    while (i < left.size()){
        employees.set(k, left.get(i));
        i++;
        k++;
    }
    while (j < right.size()) {
        employees.set(k, right.get(j));
        j++;
        k++;
    }    
    }
    
}
