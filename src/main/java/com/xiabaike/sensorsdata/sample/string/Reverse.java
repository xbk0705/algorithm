package com.xiabaike.sensorsdata.sample.string;

public class Reverse {

    // 输入：x = 123
    // 输出：321
    public int reverse(int x) {
        long re = 0;
        while (x != 0) {
            re = re * 10 + x % 10;
            x = x / 10;
        }
        return  (int) re == re ? (int) re : 0;
    }

}
