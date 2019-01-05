package com.merjiezo.simple.dp;

/***
 * FROM: https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * EXAMPLE:
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 解释：
 * 1: -
 * 2: -- | ——
 * 3: --- | ——- | -——
 * 公式: n = f(n) + f(n - 2)
 */
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.ext(20));
    }

    public int ext(int n) {
        int numRes = 0;
        int numAddNew = 0;
        int numAbove = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                numRes = 1;
            } else if (i == 1) {
                numRes += 1;
            }
            numRes += numAddNew;
            numAddNew = numAbove;
            numAbove = numRes;
        }
        return numRes;
    }
}
