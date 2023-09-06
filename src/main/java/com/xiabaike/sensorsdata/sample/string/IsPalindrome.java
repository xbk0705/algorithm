package com.xiabaike.sensorsdata.sample.string;

public class IsPalindrome {

    // 输入: s = "A man, a plan, a canal: Panama"
    // 输出：true
    // 解释："amanaplanacanalpanama" 是回文串。
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replace(",", "").replace(":", "").replace(" ", "");
        char[] ch = s.toCharArray();
        int mid = s.length() / 2;
        int index = 0;
        while (index < mid) {
            if (ch[index] != ch[ch.length - index - 1]) {
                return false;
            } else {
                index++;
            }
        }
        return false;
    }


}
