package com.merjiezo.simple.dp.numarray;

/***
 * FROM: https://leetcode-cn.com/problems/range-sum-query-immutable/submissions/
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * EXAMPLE:
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class FastestNumArray {

    int[] cacheSum;

    public FastestNumArray(int[] nums) {
        if (nums == null) {
            cacheSum = new int[0];
        }
        int len = nums.length;
        cacheSum = new int[len];
        if (len == 0) {
            return;
        }
        cacheSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            cacheSum[i] = cacheSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0? cacheSum[j]: cacheSum[j] - cacheSum[i - 1];
    }
}
