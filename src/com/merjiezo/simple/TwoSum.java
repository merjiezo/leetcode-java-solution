package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * EXAMPLE:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static void main (String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] test = { 2, 7, 11, 15 };

        int[] twoSumExt = twoSum.ext(test, 9);
    }

    public int[] ext(int[] nums, int target) {
        int len = nums.length;
        int[] res = {0, 0};
        boolean isDone = false;
        for (int i = 0; i < len - 1; i++) {
            int targetT = 0;
            for (int j = i + 1; j < len; j++) {
                targetT = nums[i] + nums[j];
                if (targetT == target) {
                    res[0] = i;
                    res[1] = j;
                    isDone = true;
                    break;
                }
            }
            if (isDone) {
                break;
            }
        }
        return res;
    }
}
