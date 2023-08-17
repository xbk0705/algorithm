package com.xiabaike.sensorsdata.algo.mianshi75;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean is = isSubsequence.isSubsequence(s, t);
        System.out.println(is);
    }

    /**
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int si = 0;
        int ti = 0;
        while (si < sc.length && ti < tc.length) {
            if (sc[si] == tc[ti]) {
                si++;
            }
            ti++;
        }
        System.out.println(si + "," + ti);
        return si == sc.length;
    }


}
