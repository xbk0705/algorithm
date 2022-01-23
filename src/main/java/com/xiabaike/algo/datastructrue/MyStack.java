package com.xiabaike.algo.datastructrue;

/**
 * 栈
 */
public class MyStack {

    private int[] data;

    private int length;

    private int top;

    public MyStack(int size) {
        data = new int[size];
        length = size;
        top = -1;
    }

    public void push(int value) {
        if (top < length - 1) {
            data[++top] = value;
        }
    }

    public int pop() {
        return data[top--];
    }

    /**
     * 访问栈顶元素
     * @return
     */
    public int peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == length - 1;
    }

}
