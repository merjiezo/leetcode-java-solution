package com.merjiezo.simple;

import com.merjiezo.utils.ListNode;

/***
 * FROM: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * EXAMPLE:
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main (String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode lt1 = l1;
        ListNode lt2 = l2;
        lt1.next = new ListNode(2);
        lt1 = lt1.next;
        lt1.next = new ListNode(4);

        lt2.next = new ListNode(3);
        lt2 = lt2.next;
        lt2.next = new ListNode(4);

        mergeTwoLists.ext(l1, l2);
    }

    public ListNode ext(ListNode l1, ListNode l2) {
        if (null == l1) { return l2; }
        if (null == l2) { return l1; }

        ListNode lt1 = l1;
        ListNode lt2 = l2;

        ListNode resL = null;
        if (lt1.val == lt2.val) {
            resL = new ListNode(lt1.val);
            lt1 = lt1.next;
        } else {
            if (lt1.val > lt2.val) {
                resL = new ListNode(lt2.val);
                lt2 = lt2.next;
            } else {
                resL = new ListNode(lt1.val);
                lt1 = lt1.next;
            }
        }
        ListNode loopPoint = resL;

        while(null != lt1 || null != lt2) {

            if (lt1 == null && lt2 != null) {
                loopPoint.next = new ListNode(lt2.val);
                lt2 = lt2.next;
            } else if (lt2 == null && lt1 != null) {
                loopPoint.next = new ListNode(lt1.val);
                lt1 = lt1.next;
            } else if (lt1.val == lt2.val) {
                loopPoint.next = new ListNode(lt1.val);
                lt1 = lt1.next;
            } else {
                if (lt1.val > lt2.val) {
                    loopPoint.next = new ListNode(lt2.val);
                    lt2 = lt2.next;
                } else {
                    loopPoint.next = new ListNode(lt1.val);
                    lt1 = lt1.next;
                }
            }
            loopPoint = loopPoint.next;
        }

        return resL;
    }
}
