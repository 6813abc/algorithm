package com.cyg.suanfa.algorithm;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路: 建立两个链表,p先跑k的节点,
 * 当p跑到最后的时候,q就到倒数第k个节点
 *
 * @author cyg
 * @date 2019/3/13 下午4:59
 **/
public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }
}
