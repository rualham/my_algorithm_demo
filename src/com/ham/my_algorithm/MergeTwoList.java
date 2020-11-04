package com.ham.my_algorithm;

//题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需
//要合成后的链表满足单调不减规则。
public class MergeTwoList {
    public static void main(String[] args) {
        ListNode listNode = GetMyListNode.getListNode();
        ListNode curr1 = new ListNode(3);
        ListNode curr2 = new ListNode(4);
        ListNode curr3 = new ListNode(5);
        ListNode curr4 = new ListNode(6);
        curr1.next = curr2;
        curr2.next = curr3;
        curr3.next = curr4;
        curr4.next = null;
//        ListNode listNode1 = mergeTwoLists1(listNode, curr1);
        ListNode listNode2 = mergeTwoLists2(listNode, curr1);
        System.out.println("listNode2 = " + listNode2);
    }

    //    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    public static ListNode mergeTwoLists1(ListNode list3, ListNode list4) {
        ListNode list1 = list3;
        ListNode list2 = list4;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}
