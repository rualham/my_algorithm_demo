package com.ham.my_algorithm;

public class DeleteNode {

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
//        ln1.val = 1;
//        ln2.val = 2;
//        ln3.val = 3;
//        ln4.val = 4;
//        ln5.val = 5;
//        ln6.val = 6;
//        ln7.val = 7;
//        ln8.val = 8;
        deleteNode(ln1, ln2);
        while (ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }

    public static void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null)
            return;
        if (head == deListNode) {
            head = null;
        } else {
// 若删除节点是末尾节点，往后移一个
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }
}
