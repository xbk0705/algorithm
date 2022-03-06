package com.xiabaike.algo.main;

public class Test2 {

    private static boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!isOver) {
                System.out.println(isOver);
            }
            System.out.println("it's end");
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }

}
