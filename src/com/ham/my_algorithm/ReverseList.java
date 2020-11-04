package com.ham.my_algorithm;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = GetMyListNode.getListNode();
        reverseList(listNode);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
