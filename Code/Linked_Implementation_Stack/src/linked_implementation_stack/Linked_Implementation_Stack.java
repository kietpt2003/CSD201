/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linked_implementation_stack;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Linked_Implementation_Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ArrLength; //giữ độ dài ban đầu
        int n;
        Scanner sc = new Scanner(System.in);
        LinkedStack tmp = new LinkedStack();
        System.out.print("Enter the number of elements that you want to add to the List: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Please input the " + (i + 1) + " element: ");
            tmp.push(sc.nextInt());
        }

        System.out.println("Check Empty: " + tmp.isEmpty());
        System.out.println();

        System.out.println("The element on the top");
        System.out.println(tmp.top());
        System.out.println();

        tmp.pop();
        System.out.println("Top after pop");
        System.out.println(tmp.top());
        System.out.println();
    }
}
