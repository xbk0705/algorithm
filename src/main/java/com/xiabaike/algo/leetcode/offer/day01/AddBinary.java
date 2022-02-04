package com.xiabaike.algo.leetcode.offer.day01;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"  输出: "100"
 * 输入: a = "1010", b = "1011"  输出: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int x = a.length() - 1;
        int y = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (x >= 0 && y >= 0) {
            int sum = carry;
            sum += a.charAt(x) - '0';
            sum += b.charAt(y) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
            x--;
            y--;
        }

        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (x >= 0) {
            int sum = carry + a.charAt(x--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (y >= 0) {
            int sum = carry + b.charAt(y--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary("1010", "1011");
        System.out.println(result);
    }

}
