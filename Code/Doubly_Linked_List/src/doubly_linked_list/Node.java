/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doubly_linked_list;

/**
 *
 * @author ACER
 */
public class Node {

    int info;
    Node prev, next;

    Node() {
    }

    Node(int x, Node p, Node q) {
        info = x;
        prev = p;
        next = q;
    }

}
