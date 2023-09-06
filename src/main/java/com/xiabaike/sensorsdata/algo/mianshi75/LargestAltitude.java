package com.xiabaike.sensorsdata.algo.mianshi75;

public class LargestAltitude {

    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {

        int max = 0;
        int pre = 0;
        for (int i = 1; i < gain.length; i++) {
            pre = pre + gain[i];
            max = Math.max(pre, max);
        }
        return max;
    }
}
