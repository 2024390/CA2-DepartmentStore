/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;

/**
 *
 * @author maria
 */
public enum MenuOption {
    
    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_RECORDS(3, "Add Employee Records"),
    CREATE_TREE(4, "Create Binary Tree"),
    EXIT(5, "Exit");
    
    private final int number;
    private final String description;
    
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }
    
    public int getNumber() {
        return  number;
    }
    
    public String getDescription(){
        return description;
    }
}
