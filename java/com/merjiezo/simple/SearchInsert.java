package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。\
 * 你可以假设数组中无重复元素。
 *
 * EXMAPLE:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class SearchInsert {

    public static void main (String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = { 1, 3, 5, 6 };
        int len = searchInsert.ext(nums, 5);
        System.out.println(len);
    }

    public int ext(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int index = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == target) {
                index = i;
                break;
            }
            if (target < num) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return len;
        }
        return index;
    }
}
