package com.xiabaike.sensorsdata.algo.mianshi75;

/**
 *
 */
public class GcdOfStrings {

    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int min = Math.min(length1, length2);
        String result = null;
        for (int i = min; i >= 1; i--) {
            if (length1 % i ==0 && length2 % i == 0) {
                String sub = str1.substring(0, i);
                if (check(str1, sub) && check(str2, sub)) {
                    result = sub;
                }
            }
        }
        return result;
    }

    private static boolean check(String str, String sub) {
        int l = str.length() / sub.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < l; i++) {
            sb.append(sub);
        }
        return str.equals(sb.toString());
    }

}
