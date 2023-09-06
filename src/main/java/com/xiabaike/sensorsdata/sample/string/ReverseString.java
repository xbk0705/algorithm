package com.xiabaike.sensorsdata.sample.string;

public class ReverseString {

    // 输入：s = ["h","e","l","l","o"]
    // 输出：["o","l","l","e","h"]
    public void reverseString(char[] s) {
        int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left++, right++);
        }
    }

    private static void swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }

    public void reverseString3(char[] s) {
        if (s == null || s.length == 1) return;
        reverseStringHelper(s, 0, s.length - 1);
    }

    private static void reverseStringHelper(char[] s, int left, int right) {
        if (left >= right) return;

        swap(s, left, right);
        reverseStringHelper(s, left++, right--);
    }

}
