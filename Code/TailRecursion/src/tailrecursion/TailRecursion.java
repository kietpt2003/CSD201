/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tailrecursion;

/**
 *
 * @author ACER
 */
public class TailRecursion {

    /**
     * @param args the command line arguments
     */
    static void tail(int n) {
        if (n > 0) {
            System.out.print(n + "  ");
            tail(n - 1);
        }
    }

    static void nonTail(int i) {
        if (i > 0) {
            tail(i - 1);
            System.out.print(i + "");
            tail(i - 1);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        tail(10);
        System.out.println();
        nonTail(10);

    }

}
