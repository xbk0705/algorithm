package com.xiabaike.algo.main;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    private static boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!isOver) {
                List<Boolean> is = new ArrayList<>();
                is.add(isOver);
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
