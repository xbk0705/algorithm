package com.xiabaike.sensorsdata.algo.mianshi75;

import java.util.HashMap;
import java.util.Map;

public class ReverseVowels {

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String s = "hello";
        String result = reverseVowels.reverseVowels(s);
        System.out.printf(result);
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('A', 0);
        map.put('E', 0);
        map.put('I', 0);
        map.put('O', 0);
        map.put('U', 0);
        while (left < right) {
            if (map.containsKey(chars[left]) && map.containsKey(chars[right])) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
                continue;
            }
            if (!map.containsKey(chars[left])) {
                left++;
            }
            if (!map.containsKey(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }

}
