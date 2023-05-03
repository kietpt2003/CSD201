/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package implementationusingarraylist;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Array_Implementation_Stack { //dùng để đổi từ Dec sang Bin

    /**
     * @param args the command line arguments
     */
    public static void decToBin(int k) {
        MyStack s = new MyStack();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2)); //giữ phần dư đầu tiên => ra cuối
            k = k / 2; //chia lấy phần nguyên để xử lí tiếp
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()); //lấy sô từ trên cùng xong giảm top xuống từ từ để lấy số kế tiếp
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number in Decimal to change Binary: ");
        num = sc.nextInt();
        decToBin(num);
        System.out.println();

    }

}
