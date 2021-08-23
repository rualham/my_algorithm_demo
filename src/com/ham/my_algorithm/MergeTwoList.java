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
//        ListNode listNode2 = mergeTwoLists2(listNode, curr1);
//        ListNode listNode2 = mergeTwoLists3(listNode, curr1);
//        ListNode listNode2 = mergeTwoLists5(listNode, curr1);
        ListNode listNode2 = findKthToTail(listNode, 3);
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

    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                preHead.next = list1;
                list1 = list1.next;
            } else {
                preHead.next = list2;
                list2 = list2.next;
            }
            preHead = preHead.next;
        }
        preHead.next = list1 == null ? list2 : list1;
        return pre.next;
    }

    public static ListNode mergeTwoLists4(ListNode list1, ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
//                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
//                head = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        //如果有一个链表为空，另一个链表非空，则应该把非空链表合并到链表尾部。
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }


    public static ListNode mergeTwoLists5(ListNode list1, ListNode list2) {

        ListNode preNode = new ListNode(0);
        ListNode headNode = preNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                headNode.next = list1;
                list1 = list1.next;
            } else {
                headNode.next = list2;
                list2 = list2.next;
            }
            headNode = headNode.next;
        }
        if (list1 != null) {
            headNode.next = list1;
        }

        return preNode.next;

    }

    //
    public static ListNode findKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) return pHead;
        ListNode fast = pHead;
        int i = 0;
        while (i < k) {
            i++;
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
