package com.merjiezo.simple;

/***
 * FROM：https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 注意：
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * EXAMPLE:
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */
public class ReverseInt {

    public static void main (String[] args) {
        ReverseInt reverseInt = new ReverseInt();
        int res = reverseInt.reverse(123);
        System.out.println(res);
    }

    public int reverse(int x) {
        try {
            boolean reverse = false;
            if (x < 0) {
                x = -x;
                reverse = true;
            }
            String str = "" + x;
            String res = "";
            String[] sArr = str.split("");
            int len = sArr.length;
            for (int i = len - 1; i >= 0; i--) {
                res += sArr[i];
            }
            if (reverse) {
                return 0 - Integer.valueOf(res);
            } else {
                return Integer.valueOf(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
