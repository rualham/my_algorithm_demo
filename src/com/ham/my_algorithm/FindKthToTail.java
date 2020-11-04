package com.ham.my_algorithm;

public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode = GetMyListNode.getListNode();
        findKthToTail(listNode, 3);
        System.out.println("ln8 = " + findKthToTail(listNode, 3));
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 1) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
