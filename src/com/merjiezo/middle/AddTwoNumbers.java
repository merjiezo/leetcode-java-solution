package com.merjiezo.middle;

import com.merjiezo.utils.ListNode;

/***
 * FROM: https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * EXAMPLE:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main (String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        System.out.println(addTwoNumbers.ext(test));
    }

    public ListNode ext(ListNode l1, ListNode l2) {
        int l1Length = 0;
        int l2Length = 0;
        ListNode lt1 = l1;
        ListNode lt2 = l2;
        while(lt1 != null) {
            lt1 = lt1.next;
            l1Length += 1;
        }
        while(lt2 != null) {
            lt2 = lt2.next;
            l2Length += 1;
        }
        String resNodeStr = null;
        if (l1Length >= l2Length) {
            resNodeStr = addOneToAnother (l1, l2);
        } else {
            resNodeStr = addOneToAnother (l2, l1);
        }
        System.out.println(resNodeStr);
        String[] resNodeStrArr = resNodeStr.split("");
        ListNode resLinkNode = new ListNode(Integer.valueOf(resNodeStrArr[0]));
        ListNode nowNode = resLinkNode;
        for (int i = 1; i < resNodeStrArr.length; i++) {
            nowNode.next = new ListNode(Integer.valueOf(resNodeStrArr[i]));
            nowNode = nowNode.next;
        }
        return resLinkNode;
    }

    private String addOneToAnother (ListNode l1, ListNode l2) {
        String res = "";
        ListNode nowNode1 = l1;
        ListNode nowNode2 = l2;

        int addMore = 0;
        while(nowNode1 != null) {
            int val = 0;
            if (null != nowNode2) {
                val = nowNode1.val + nowNode2.val + addMore;
            } else {
                val = nowNode1.val + addMore;
            }
            addMore = 0;
            if (val >= 10) {
                res += String.valueOf(val % 10);
                addMore = 1;
            } else {
                res += String.valueOf(val);
            }
            if (null != nowNode2) {
                nowNode2 = nowNode2.next;
            }
            nowNode1 = nowNode1.next;
        }
        if (addMore != 0) {
            res += String.valueOf(addMore);
        }
        return res;
    }

}
