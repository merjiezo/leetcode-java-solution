package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * EXAMPLE:
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class IsPalindrome {

    public static void main (String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.ext(121));
    }

    public boolean ext(int x) {
        if (x < 0) {
            return false;
        }
        String s1 = "" + x;
        if (0 == x) {
            return true;
        }
        if (s1.length() == 1) {
            return true;
        }

        String[] sArr = s1.split("");
        int len = sArr.length;
        int loop = 0;
        if (s1.length() % 2 == 0) {
            loop = len / 2;
        } else {
            loop = (len - 1) / 2;
        }

        for (int i = 0; i < loop; i++) {
            String str = sArr[i];
            if (!str.equals(sArr[len - i - 1])) {
                return false;
            }
        }
        return true;
    }
}
