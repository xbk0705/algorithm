package com.xiabaike.interview;

/**
 * 静态内部类
 */
public class Instance3 {

    private static INSTANCE instance = new INSTANCE();

    public static Object getInstance() {
        return instance.object;
    }

    private static class INSTANCE {
        Object object = new Object();
    }

}
