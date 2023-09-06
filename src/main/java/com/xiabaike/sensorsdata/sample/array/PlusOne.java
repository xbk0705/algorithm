package com.xiabaike.sensorsdata.sample.array;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    // 输入：digits = [4,3,2,1]
    // 输出：[4,3,2,2]
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int add = 1;
        int nineNum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                nineNum++;
            }
            int num = digits[i] + add;
            if (num >= 10) {
                add = 1;
                list.add(num - 10);
            } else {
                add = 0;
                list.add(num);
            }
        }
        if (nineNum == digits.length) {
            list.add(1);
        }

        int[] newNums = new int[list.size()];
        int i = 0;
        for (int m = list.size() - 1; m >= 0; m--) {
            newNums[i++] = list.get(m);
        }
        return newNums;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }

}
