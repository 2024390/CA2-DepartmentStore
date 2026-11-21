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
    
    public void mergeSort(ArrayList<Employee> employees){
        
        if (employees.size() <= 1){
            return;
        }
        
        int middle = employees.size() / 2;
        
        ArrayList<Employee> left = new ArrayList<>(
        employees.subList(0, middle));
        
        ArrayList<Employee> right = new ArrayList<>(
        employees.subList(middle, employees.size()));
        
        mergeSort(left);
        mergeSort(right);
        
        merge(employees, left, right);
    }
    
    private void merge(ArrayList<Employee> employees,
            ArrayList<Employee> left,
            ArrayList<Employee> right){
        
        int i = 0;
        int j = 0;
        int k =0;
        
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
