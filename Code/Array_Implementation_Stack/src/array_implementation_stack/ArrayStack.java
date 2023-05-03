/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package array_implementation_stack;

import java.util.EmptyStackException;

/**
 *
 * @author ACER
 */
public class ArrayStack {

    protected Object[] a;
    int top, max;
    int count; //dùng để đếm sau khi grow
    public ArrayStack() {
        this (50); //số lượng phần tử mặc định, nếu cho nhỏ hơn số phần tử nhập vào thì nó tự tăng, nếu lớn hơn thì mấy phần tử dư là null
    }

    public ArrayStack(int max1) {
        max = max1;
        a = new Object[max];
        top = -1; //để -1 để khi thêm vô là thêm vào a[0] vì trong push có ++top
    }

    protected boolean grow() {
        int max1 = max + max / 2; //tăng max thêm một nửa
        count = max1 - max;
        Object[] a1 = new Object[max1]; //tạo một array object a1 vs số lượng max1 sau khi đã tăng
        if (a1 == null) {
            return (false);
        }
        for (int i = 0; i <= top; i++) {
            a1[i] = a[i]; //gán giá trị của array a vô array a1
        }
        a = a1; //cho array a thành a1 => tăng thành công
        return (true);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void clear() {
        top = -1;
    }

    public void push(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        a[++top] = x;
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (a[top]);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = a[top]; //giữ lại giá trị của thằng trên cùng
        top--; //giảm top xuống 1 sẽ ra thằng top bên dưới nhưng không xóa được thằng top trên kia nhưng dùng để trá hình được, vì dùng biến top
               //để xử lí nên top bây h đã đổi sang top dưới
        return x;
    }

}
