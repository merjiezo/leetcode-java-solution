package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * EXAMPLE:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    public static void main (String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = { 1,1,2 };
        int len = removeDuplicates.ext(nums);
        System.out.print("[ ");
        for (int i = 0; i < len; i++) {
            if (i + 1 == len) {
                System.out.print(nums[i] + " ]\n");
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
    }

    public int ext(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int max = nums[len -1];
        int min = nums[0];
        if (max == min) {
            return 1;
        }

        int nowPoint = min;
        int nowIndex = 1;

        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num > nowPoint) {
                nowPoint = num;
                nums[nowIndex] = num;
                nowIndex += 1;
            }
        }

        return nowIndex;
    }
}
