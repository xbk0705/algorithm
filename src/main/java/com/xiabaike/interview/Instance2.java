package com.xiabaike.interview;

/**
 * 双重校验锁
 */
public class Instance2 {

    private volatile static Object object = null;

    private Instance2() {}

    public static Object getInstance() {
        if (object == null) {
            synchronized (Instance2.class) {
                if (object == null) {
                    object = new Object();
                }
            }
        }
        return object;
    }

}
