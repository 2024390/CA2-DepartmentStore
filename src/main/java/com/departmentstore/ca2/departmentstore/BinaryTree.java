/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.ca2.departmentstore;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author maria
 */
public class BinaryTree {
    
    private TreeNode root;
    
    public BinaryTree(){
        root = null;
    }
    
    // Insert employees into the tree from left to right
    public void insert(Employee employee){
        TreeNode newNode = new TreeNode(employee);
        
        if (root == null){
            root = newNode;
            return;
        }
        
        // Queue is for find the next availbale position
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            
            TreeNode current = queue.remove();
            
            if (current.getLeft() == null){
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }
            
            if (current.getRight() == null){
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
        }
        
        // Shows all the employees level by level 
        public void displayLevelOrder(){
            if (root == null){
                System.out.println("The tree is empty");
                return;
                
            }
           
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            
            System.out.println("=== Staff in Level Order ===");
            
            while (!queue.isEmpty()){
                TreeNode current = queue.remove();
                System.out.println(
                "Name: " + current.getEmployee().getName()
                + " === Manager Type: " + current.getEmployee().getManagerType()
                + " === Department: " + current.getEmployee().getDepartment());
                
                if (current.getLeft() != null){
                    queue.add(current.getLeft());
                }
                
            if (current.getRight() != null){
                queue.add(current.getRight());
            }
            
            
        }
        
    }
        // Repeated counts the total nodes in the tree
        public int countNodes(){
            return countNodes(root);
        }
        
        private int countNodes(TreeNode node){
            if (node == null){
                return 0;
            }
            
            return 1 + countNodes(node.getLeft())
                    + countNodes(node.getRight());
        }
        
            // Repeated calculates the heigh of the tree
            public int getHeight(){
                return getHeight(root);
            }
            private int getHeight(TreeNode node){
                if (node == null){
                    return 0;
                }
                int leftHeight = getHeight(node.getLeft());
                int rightHeight = getHeight(node.getRight());
                
                return 1 + Math.max(leftHeight, rightHeight);
            }
        }


