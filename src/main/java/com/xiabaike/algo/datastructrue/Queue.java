package com.xiabaike.algo.datastructrue;

/**
 * @Author xiabaike
 * @Date 2019/3/10 15:31
 */
public class Queue {

    private int[] data;

    private int length = 10;

    private Integer head;

    private Integer tail;

    public Queue(){
        data = new int[length];
        head = null;
        tail = null;
    }

    public void enqueue(int num) {
        if(tail == null) {
            tail = 0;
            head = 0;
        }
        data[tail] = num;
        tail = (tail + 1) % length;
    }

    public Integer dequeue() {
        if(head == null) {
            return null;
        }
        int num = data[head];

        head = (head + 1) % length;
        if(head > tail) {
            head = null;
            tail = null;
        }

        return num;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(1);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
