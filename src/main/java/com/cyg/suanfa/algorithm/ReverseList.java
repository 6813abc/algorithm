package com.cyg.suanfa.algorithm;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * @author cyg
 * @date 2019/3/14 下午6:30
 **/
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            //将head的下一个节点保存下来,保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //将head的next指向pre节点
            head.next = pre;
            //将pre节点赋值为head
            pre = head;
            //将head节点换位之前保存下来的next节点
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(reverseList.reverseList(listNode1).val);
    }
}

