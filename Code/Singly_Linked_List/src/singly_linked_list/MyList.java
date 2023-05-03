/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singly_linked_list;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class MyList {
    int n = 0;
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {  //Clear the List
        head = tail = null;

    }

    void add(int x) { //Add to the List
        if (isEmpty()) {
            head = tail = new Node(x, null);
            System.out.println("The List is empty. Add Success!");
        } else {
            Node q = new Node(x, null);
            tail.next = q; //next sẽ trỏ qua node q(q trỏ null)
            tail = q; //xong tail mới trỏ qua Node q
            n++;
            System.out.println("Add Success!");
        }
    }

    void traverse() { //Print out the List
        Node p = head;
        while (p != null) {
            System.out.print("  " + p.info);
            p = p.next;
        }
        System.out.println();
        System.out.println("Print Success!");
    }

    Node search(int x) {
        Node p = head;
        Node tmp = null;
        while (p != null) {
            if (p.info == x) {
                tmp = p; //lưu lại giá trị hiện tại của p
                p = p.next; //p trỏ qua cái tiếp theo
            }
            p = p.next;

        }
        return tmp;
    }

    void dele(int x) {
        int size = n, p = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the position that you want to delete: ");
        p = sc.nextInt();
        if (p > n || p < 1) {
            System.out.println("The position that you input does not exist.");
        }
        if (p == 1) {
            Node tmp = head;
            head = head.next;
            tmp.next = null;
            System.out.println("Delete Success!");
        } else {
            Node previous = head;
            int count = 1;
            while (count < p - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = current.next;
            current.next = null;
            System.out.println("Delete Success!");
        }
    }
}