package com.xiabaike.algo.datastructrue;

import java.util.Arrays;

/**
 * push时 ，满了，丢弃最早
 * 底层用数组实现，不能链表
 * push  pop 算法复杂度要求 O(1)
 *
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-02-14
 */
public class Stack {

    private int[] data;

    // 栈顶指针
    private int top = 0;

    // 栈底指针
    private int end = 0;

    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity + 1;
        this.data = new int[capacity + 1];
    }

    public boolean isFull() {
        return (top + 1) % capacity == end;
    }

    public boolean isEmpty() {
        return top == end;
    }

    public void push(int value) {
        if (isFull()) {
            end = (end + 1) % capacity;
        }

        data[top] = value;
        top = (top + 1) % capacity;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        top = (top + capacity - 1) % capacity;
        return data[top];
    }

    // 求出当前栈有效的数据的个数
    public int size() {
        return (top + capacity - end) % capacity;
    }

    public void printData() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
//        int value = stack.pop3();
//        System.out.println(value);

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int value = stack.pop();
        System.out.println(value);

        stack.printData();

        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        value = stack.pop();
        System.out.println(value);

        stack.push(7);
        stack.push(7);
        stack.push(7);
        stack.push(7);
        stack.push(7);
        stack.push(7);
        stack.printData();

        value = stack.pop();
        System.out.println(value);
        value = stack.pop();
        System.out.println(value);
        value = stack.pop();
        System.out.println(value);
        value = stack.pop();
        System.out.println(value);
        value = stack.pop();
        System.out.println(value);
        value = stack.pop();
        System.out.println(value);
    }

}
