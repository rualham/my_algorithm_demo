package com.ham.my_algorithm;

import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {
    public static class Node<E> {
        E data;//数据
        int weight;//权重
        Node leftChild;//左子节点
        Node rightChild;//右子节点

        public Node(E data, int weight) {
            super();
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[" + weight + ",data=" + data + "]";
        }
    }

    public static void main(String[] args) {
        sort(new int[]{4, 1, 5, 6, 8, 7, 9});
        List<Node> nodes = new ArrayList<>();
        //把节点加入至list中
        nodes.add(new Node("a", 10));
        nodes.add(new Node("b", 15));
        nodes.add(new Node("c", 12));
        nodes.add(new Node("d", 3));
        nodes.add(new Node("e", 4));
        nodes.add(new Node("f", 13));
        nodes.add(new Node("g", 1));
        //进行哈夫曼树的构造
        Node root = createTree(nodes);
        //打印哈夫曼树
        printTree(root);

        int[] a = new int[]{};
        int[] b = {2, 5, 6, 9, 8, 7, 10};
//        sort(b);
        System.out.println("b = " + b);
    }


    private static Node createTree(List<Node> nodes) {
        //如果节点node列表中含有2个和2个以上的节点
        while (nodes.size() > 1) {
            //什么是最小的，list表进行排序，增序的方式
            sort(nodes);//排序方式是增序的
            Node left = nodes.get(0);//权重最小的
            Node right = nodes.get(1);//权重第二小的
            //生成一个新的节点(父节点)，父节点的权重为两个子节点的之和
            Node parent = new Node(null, left.weight + right.weight);
            //树的连接，让子节点与父节点进行连接
            parent.leftChild = left;
            parent.rightChild = right;
            nodes.remove(0);//删除最小的
            nodes.remove(0);//删除第二小的
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //递归打印哈夫曼树（先左子树，后右子树打印）
    private static void printTree(Node root) {
        System.out.println(root.toString());
        if (root.leftChild != null) {
            System.out.print("left:");
            printTree(root.leftChild);
        }
        if (root.rightChild != null) {
            System.out.print("right:");
            printTree(root.rightChild);
        }
    }

    /**
     * 冒泡排序，用于对节点进行排序（增序排序）
     *
     * @param nodes
     */

    public static void sort(List<Node> nodes) {
        if (nodes.size() <= 1) return;
        /*循环数组长度的次数*/
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size() - 1 - i; j++) {
                if (nodes.get(j + 1).weight < nodes.get(j).weight) {
                    Node temp = nodes.get(j + 1);
                    nodes.set(j + 1, nodes.get(j));
                    nodes.set(j, temp);
                }
            }
        }
        return;
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("i = " + a[i]);

        }
    }
}
