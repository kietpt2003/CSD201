/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array_implementation_stack;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Array_Implementation_Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ArrLength; //giữ độ dài ban đầu
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of element for Array a: ");
        ArrayStack tmp = new ArrayStack(sc.nextInt()); //nhập số phần tử ở đây, mặc định 50
        
        for (int i = 0; i < tmp.a.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            tmp.push(sc.next());
        }
        ArrLength = tmp.a.length;

        System.out.println("Input ArrayStack Success!");
        System.out.println("Array:");
        for (int i = 0; i < tmp.a.length; i++) {
                System.out.print(" " + tmp.a[i]);
        }
        System.out.println();

        System.out.println("Check Empty: " + tmp.isEmpty());
        System.out.println();

        System.out.println("Check IsFull: " + tmp.isFull());
        System.out.println();

        System.out.println("The element on the top");
        System.out.println(tmp.top());
        System.out.println();
        
        tmp.pop();
        System.out.println("Top after pop");
        System.out.println(tmp.top());
        System.out.println();
        
        System.out.println("Array not change after pop:");
        for (int i = 0; i < tmp.a.length; i++) {
                System.out.print(" " + tmp.a[i]);
        }
        System.out.println();
        
        //Do hàm pop nó đã đổi top xuống mà push lại dùng top nên khi grow cộng thêm biến mới nó sẽ thêm
        //từ top dưới => chạy thử sẽ thấy nó đổi phần tử cuô của arr cũ thành phần tử mới và cuối dư null
        System.out.println("Grow array a Success!");
        tmp.grow();
        System.out.println("Array:");
        for (int i = 0; i < tmp.a.length; i++) {
            //if (tmp.a[i] != null) { //nếu không muốn thấy null thì gỡ phong ấn này ra
                System.out.print(" " + tmp.a[i]);
            //}
        }
        System.out.println();

        for (int i = 1; i <= tmp.count; i++) {
            System.out.print("Enter element " + (i + ArrLength) + ": ");
            tmp.push(sc.next());
        }
        System.out.println("After push more:");
        for (int i = 0; i < tmp.a.length; i++) {
            //if (tmp.a[i] != null) { //nếu không muốn thấy null thì gỡ phong ấn này ra
                System.out.print(" " + tmp.a[i]);
            //}
        }
        System.out.println();
    }

}
