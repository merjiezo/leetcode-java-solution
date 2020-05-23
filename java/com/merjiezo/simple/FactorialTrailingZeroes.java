package com.merjiezo.simple;

/***
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FactorialTrailingZeroes {

    // 25: 2 | 50: 2 | 75: 2 | 100: 2
    // 125: 3 | 150: 2 | 175: 2 | 200: 2
    // 225: 2 | 250: 3 | 275: 2 |300: 2
    // 325: 2 | 350: 2 | 375: 3 | 400: 2
    // 425: 2 | 450: 2 | 475: 2 | 500: 3
    // 525: 2 | 550: 2 | 575: 2 | 600: 2
    // 625: 4 |
    public static int trailingZeroes(int n) {
        int len = 0;
        while (n > 0) {
            n /= 5;
            len += n;
        }
        return len;
    }

    public static void main (String[] args) {
        System.out.print(trailingZeroes(70));
    }
}
