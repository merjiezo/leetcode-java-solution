package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/remove-element/
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * EXAMPLE:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main (String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = { 0,1,2,2,3,0,4,2 };

        int len = removeElement.ext(nums, 2);
        System.out.print("[ ");
        for (int i = 0; i < len; i++) {
            if (i + 1 == len) {
                System.out.print(nums[i] + " ]\n");
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
    }

    public int ext(int[] nums, int val) {
        int valNum = 0;
        if (null == nums && nums.length == 0) {
            return valNum;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int compareNum = nums[i];
            if (compareNum != val) {
                valNum = i + 1;
                continue;
            }

            int index = findIndexCanChangeNum(nums, val, i + 1);
            if (-1 != index) {
                nums[i] = nums[i] + nums[index];
                nums[index] = nums[i] - nums[index];
                nums[i] = nums[i] - nums[index];
                valNum = i + 1;
            } else {
                break;
            }
        }

        return valNum;
    }

    private int findIndexCanChangeNum (int[] nums, int val, int stat) {
        int res = -1;
        int len = nums.length;
        for (int i = len - 1; i > stat - 1; i--) {
            if (nums[i] != val) {
                res = i;
                break;
            }
        }
        return res;
    }
}
