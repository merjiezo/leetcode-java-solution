package com.merjiezo.simple.dp;

/***
 * FROM: https://leetcode-cn.com/problems/house-robber/submissions/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * EXAMPLE:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] prices = { 2, 7, 9, 3, 1 };
        System.out.println(rob.ext(prices));
    }

    public int ext(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] maxArr = new int[len];
        maxArr[0] = nums[0];
        maxArr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            maxArr[i] = Math.max(nums[i] + maxArr[i - 2], maxArr[i - 1]);
        }
        return maxArr[len - 1];
    }
}
