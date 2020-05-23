package com.merjiezo.simple;

/***
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int nowM = 0;
        int nowN = 0;
        // Cache Nums1
        int[] nums1_1 = new int[m];
        for (; nowM < m; nowM++) {
            nums1_1[nowM] = nums1[nowM];
        }
        nowM = 0;
        m -= 1;
        n -= 1;
        int moveTo = 0;
        while (nowM <= m || nowN <= n) {
            if (nowM <= m) {
                if (nowN <= n) {
                    if (nums1_1[nowM] <= nums2[nowN]) {
                        nums1[moveTo] = nums1_1[nowM];
                        nowM += 1;
                    } else {
                        nums1[moveTo] = nums2[nowN];
                        nowN += 1;
                    }
                } else {
                    nums1[moveTo] = nums1_1[nowM];
                    nowM += 1;
                }
            } else {
                nums1[moveTo] = nums2[nowN];
                nowN += 1;
            }
            moveTo += 1;
        }
    }
}
