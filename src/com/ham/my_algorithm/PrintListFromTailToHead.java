package com.ham.my_algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//1、从尾到头打印链表
//2、用两个栈实现队列
//3、根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。

public class PrintListFromTailToHead {
    static Stack<Integer> in = new Stack<Integer>();
    static Stack<Integer> out = new Stack<Integer>();
    // 缓存中序遍历数组每个值对应的索引
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static void main(String[] args) {
        TreeNode listNode1 = reConstructBinaryTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode treeNode = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
//        ListNode listNode2 = GetMyListNode.getListNode();
//        ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
//        printListFromTailToHead(listNode);
        push(1);
        push(2);
        push(3);
        try {
            pop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
//            System.out.println(listNode.val);
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }


    public static void push(int node) {
        in.push(node);
    }

    public static void pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        while (!out.empty()) {
            System.out.println("out.peek() = " + out.peek());
            System.out.println("out.pop() = " + out.pop());
        }
//        return out.pop();
    }

/*    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }*/

    /*public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);//前序的第一个数定为根
        int len = pre.length;
        //当只有一个数的时候
        if (len == 1) {
            root.left = null;
            root.right = null;
            return root;
        }
        //找到中序中的根位置
        int rootval = root.val;
        int i;
        for (i = 0; i < len; i++) {
            if (rootval == in[i])
                break;
        }
        //创建左子树
        if (i > 0) {
            int[] pr = new int[i];
            int[] ino = new int[i];
            for (int j = 0; j < i; j++) {
                pr[j] = pre[j + 1];
            }
            for (int j = 0; j < i; j++) {
                ino[j] = in[j];
            }
            root.left = reConstructBinaryTree(pr, ino);
        } else {
            root.left = null;
        }
        //创建右子树
        if (len - i - 1 > 0) {
            int[] pr = new int[len - i - 1];
            int[] ino = new int[len - i - 1];
            for (int j = i + 1; j < len; j++) {
                ino[j - i - 1] = in[j];
                pr[j - i - 1] = pre[j];
            }
            root.right = reConstructBinaryTree(pr, ino);
        } else {
            root.right = null;
        }
        return root;
    }*/
}
