package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/plus-one/
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * EXAMPLE:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] example = { 4, 3, 2, 1 };
        System.out.println(plusOne.ext(example));
    }

    public int[] ext(int[] digits) {
        if (null == digits || digits.length == 0) {
            return new int[0];
        }
        int len = digits.length;
        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int nowIndex = digits[i];
            nowIndex += carry;
            carry = nowIndex / 10;
            digits[i] = nowIndex % 10;
        }
        if (carry == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
