/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avl_tree;

/**
 *
 * @author ACER
 */
public class Student_info {
    private int student_code;
    private String name;
    private String gender;
    private int gpa;

    public Student_info() {
    }

    public Student_info(int student_code, String name, String gender, int gpa) {
        this.student_code = student_code;
        this.name = name;
        this.gender = gender;
        this.gpa = gpa;
    }

    public int getStudent_code() {
        return student_code;
    }

    public void setStudent_code(int student_code) {
        this.student_code = student_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return student_code + " " + name + " " + gender + " " + gpa;
    }
    
}
