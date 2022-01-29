package com.xiabaike.algo.main;

/**
 * 大数相加
 *
 * @author xiabaike <xiabaike@kuaishou.com>
 * Created on 2022-01-24
 */
public class BigNumberAdd {

    public String bigNumberAdd(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int i = char1.length - 1, j = char2.length - 1;

        int temp1 = 0;
        int temp2 = 0;
        int n = 0; // 是否需要进位
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                temp1 = char1[i] - '0';
            } else {
                temp1 = 0;
            }
            if (j >= 0) {
                temp2 = char2[j] - '0';
            } else {
                temp2 = 0;
            }
            int sum = temp1 + temp2 + n;
            int m = sum % 10;
            n = sum / 10;
            result.append(m);
            i--;
            j--;
        }
        if (n != 0) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        BigNumberAdd bigNumberAdd = new BigNumberAdd();
        String result = bigNumberAdd.bigNumberAdd("23", "98");
        System.out.println(result);
    }



}
