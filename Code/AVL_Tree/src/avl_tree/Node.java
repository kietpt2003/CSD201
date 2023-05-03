/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avl_tree;

/**
 *
 * @author ACER
 */
public class Node {

    Student_info info;
    int height;
    Node left;
    Node right;

    public Node(Student_info info) {
        this.info = info;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public boolean greaterThan(Student_info stu) {
        return this.info.getStudent_code() > stu.getStudent_code();
    }
    
    public boolean lessThan(Student_info stu) {
        return this.info.getStudent_code() < stu.getStudent_code();
    }
    
    public boolean equal(Student_info stu) {
        return this.info.getStudent_code() == stu.getStudent_code();
    }
}
