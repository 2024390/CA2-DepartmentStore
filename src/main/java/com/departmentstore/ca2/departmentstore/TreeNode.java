/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;

/**
 *
 * @author maria
 */
public class TreeNode {
    
    // Stores the employee data and child left and right position
    private Employee employee;
    private TreeNode left;
    private TreeNode right;
    
    // Start a new node with an employee and no child nodes
    public TreeNode(Employee employee){
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
    
    // It gives access to the employee data and child references
    public Employee getEmployee(){
        return employee;
    }
    
    public TreeNode getLeft(){
        return left;
    }
    
    public TreeNode getRight(){
        return right;
    }
    
    // Name the left and right child nodes
    public void setLeft(TreeNode left){
        this.left = left;
    }
    
    public void setRight(TreeNode right){
        this.right = right;
    }
}
