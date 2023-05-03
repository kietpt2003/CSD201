/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        MyHashTable m = new MyHashTable();
        int[] a = {2, 4, 12, 21, 7, 9, 0, 72, 11, 17, 22};
        for (int x : a) {
            m.add(x);
        }
        m.traversal();
    }
}
