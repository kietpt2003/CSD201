/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singly_linked_list;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Singly_Linked_List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 0;
        Scanner sc = new Scanner(System.in);
        MyList x = new MyList();
        System.out.print("Enter the number of elements that you want to add to the List: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Please input the element " + (i + 1) + ": ");
            x.add(sc.nextInt());
        }
        System.out.print("The List: ");
        x.traverse();
        
        System.out.print("Input the information to find: ");
        n = sc.nextInt();
        if (x.search(n) == null) {
            System.out.println("Not Found.");
        } else {
            System.out.println(x.search(n).info);
        }
        
        x.dele(n);
        System.out.print("The List: ");
        x.traverse();
        
        
//        x.clear();
//        System.out.println("List after clearing:");
//        x.traverse();
    }

}
