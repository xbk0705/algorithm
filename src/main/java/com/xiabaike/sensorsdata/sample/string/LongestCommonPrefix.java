package com.xiabaike.sensorsdata.sample.string;

public class LongestCommonPrefix {

    // 输入：strs = ["flower","flow","flight"]
    // 输出："fl"
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        int index = 1;
        while (index < strs.length) {
            while (strs[index].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            index++;
        }
        return pre;
    }

}
