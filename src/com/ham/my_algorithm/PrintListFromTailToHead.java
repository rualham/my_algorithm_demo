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
//        TreeNode treeNode = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
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

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //由于重建二叉树的过程会用到很多边界值，所以题目所给的方法的参数是不够用的
        //所以，在下面重载了这个方法，每次传入前序和中序序列以及起始位置
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //这里是判断结束的标志，由于是递归算法，我们不可能一直执行下去，所以需要结束标志
        //下面这两种情况发生一个就会结束
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //首先找到根节点
        TreeNode root = new TreeNode(pre[startPre]);
        //对中序遍历进行查找根节点
        for (int i = startIn; i <= endIn; i++) {
            //找到之后，分别对左子树和右子树进行递归算法，重复此步骤
            if (in[i] == pre[startPre]) {
                //重建二叉树的关键就是找到其中的边界值，边界值在图中已经做了描述
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

 /*  public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
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
