package com.ham.my_algorithm;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = GetMyListNode.getListNode();
//        System.out.println("listNode = " + listNode);
//        System.out.println("listNode = " + reverseList(listNode));
        System.out.println("listNode = " + reverseList3(listNode));

        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        // head = reverse1(head);
//        head = reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    /*
     * 206. 反转链表 反转一个单链表。
     *
     * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 递归法
     */
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode new_head = reverseList3(next);
        next.next = head;
        head.next = null;
        return new_head;
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;

        }
        return pre;
    }

   static class Node {
        private int Data;// 数据域
        private Node Next;// 指针域

        public Node(int Data) {
            // super();
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }
}
}
