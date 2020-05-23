package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode cacheNode = head;
        ListNode nowNode = head.next;
        while (null != nowNode) {
            if (nowNode.val == cacheNode.val) {
                cacheNode.next = nowNode.next;
            } else {
                cacheNode = cacheNode.next;
            }
            nowNode = nowNode.next;
        }
        return head;
    }
}
