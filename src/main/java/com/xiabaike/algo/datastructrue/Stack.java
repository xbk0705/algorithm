package com.xiabaike.algo.datastructrue;

/**
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-02-14
 */
public class Stack {

    private int[] data;

    // 栈顶指针
    private int top = -1;

    // 栈底指针
    private int end = -1;

    private int capacity;

    private int size = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push2(int value) {
        if (isFull()) {
            top++;
            top = top % size;
        } else {
            top++;
            size++;
        }
        data[top] = value;
        return true;
    }

    // 入栈
    public boolean push(int value) {
        if (top == capacity - 1) {
            // 满了
            top = 0;
            end = 1;
        } else {
            if (isFull()) {
                end++;
            }
            top++;
        }
        data[top] = value;
        return true;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value;
        if (isFull()) {
            if (top - 1 < 0) {
                top = size - 1;
                value =  data[top];
            } else {
                value =  data[top--];
            }
        } else {
            value = data[top--];
        }
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
//        int value = stack.pop();
//        System.out.println(value);

        stack.push2(0);
        stack.push2(1);
        stack.push2(2);
        stack.push2(3);
        int size = stack.getSize();
        System.out.println(size);
        int value = stack.pop();
        System.out.println(value);
        size = stack.getSize();
        System.out.println(size);

        stack.push2(3);
        stack.push2(4);
        stack.push2(5);
        stack.push2(6);
        stack.push2(7);
        value = stack.pop();
        System.out.println(value);
        size = stack.getSize();
        System.out.println(size);

        stack.push2(7);
        stack.push2(7);
        stack.push2(7);
        stack.push2(7);
        stack.push2(7);
        stack.push2(7);
        size = stack.getSize();
        System.out.println(size);
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
