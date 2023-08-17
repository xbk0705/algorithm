package com.xiabaike.sensorsdata.algo.mianshi75;

/**
 * https://leetcode.cn/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeAlternately {

    public static void main(String[] args) {

        String word1 = "";
        String word2 = "";
        MergeAlternately mergeAlternately = new MergeAlternately();
        String result = mergeAlternately.mergeAlternately2(word1, word2);
        System.out.printf(result);
    }

    public String mergeAlternately(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < length1 || j < length2) {
            if (i < length1) {
                sb.append(word1.charAt(i++));
            }
            if (j < length2) {
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    public String mergeAlternately2(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length1 || i < length2) {
            if (i < length1) {
                sb.append(word1.charAt(i));
            }
            if (i < length2) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

}
