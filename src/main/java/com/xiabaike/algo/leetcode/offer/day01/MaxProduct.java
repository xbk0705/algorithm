package com.xiabaike.algo.leetcode.offer.day01;

import java.util.Arrays;

/**
 * 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。
 * 如果不存在这样的两个单词，返回 0 。
 *
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 */
public class MaxProduct {

    public int maxProduct(String[] words) {
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() < o2.length()) {
                return 1;
            } else {
                return 0;
            }
        });

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 1; j < words.length; j++) {
                boolean is = isContain(words[i], words[j]);
                if (!is) {
                    int ji =  words[i].length() * words[j].length();
                    max = Math.max(max, ji);
                }
            }
        }
        return max;
    }

    private static boolean isContain(String str1, String str2) {
        String duan;
        String chang;
        if (str1.length() > str2.length()) {
            duan = str2;
            chang = str1;
        } else {
            duan = str1;
            chang = str2;
        }
        int num = duan.length();
        for (int i = 0; i < num; i++) {
            char ch = duan.charAt(i);
            if (chang.contains(String.valueOf(ch))) {
                return true;
            }
        }
        return false;
    }

    public int maxProduct2(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        String[] strings = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        MaxProduct maxProduct = new MaxProduct();
        int result = maxProduct.maxProduct2(strings);
        System.out.println(result);
    }

}
