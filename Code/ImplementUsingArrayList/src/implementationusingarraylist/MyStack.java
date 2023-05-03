/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementationusingarraylist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class MyStack {

//Phiên bản ArrayList
//    ArrayList h;
//
//    MyStack() {
//        h = new ArrayList();
//    }
//
//    boolean isEmpty() {
//        return (h.isEmpty());
//    }
//
//    void push(Object x) {
//        h.add(x);
//    }
//
//    Object pop() {
//        if (isEmpty()) {
//            return (null);
//        }
//        return (h.remove(h.size() - 1));
//    }
//Phiên bản LinkedList
    LinkedList h;

    MyStack() {
        h = new LinkedList();
    }

    boolean isEmpty() {
        return (h.isEmpty());
    }

    void push(Object x) {
        h.add(x);
    }

    Object pop() {
        if (isEmpty()) {
            return (null);
        }
        return (h.removeLast());
    }

}
