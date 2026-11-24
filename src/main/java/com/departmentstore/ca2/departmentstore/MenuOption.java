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
    
    // Available options in the main menu 
    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_RECORDS(3, "Add Employee Records"),
    CREATE_TREE(4, "Create Binary Tree"),
    EXIT(5, "Exit");
    
    // It keeps each option number and description
    private final int number;
    private final String description;
    
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }
    
    // Getters used to show the menu options
    public int getNumber() {
        return  number;
    }
    
    public String getDescription(){
        return description;
    }
}
