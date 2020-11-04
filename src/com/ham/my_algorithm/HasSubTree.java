package com.ham.my_algorithm;

/*思路
 *
 * 先从根节点开始判断，
 * 1.如果根节点相同,则从头遍历
 * 2.如果根不同，则从左右两个遍历，任意一个含有B树都可以，如果失败则递归
 * doesTree1HasTree2函数负责递归两个遍历两个树，直到B树为空则返回true其余都是false
 */

public class HasSubTree {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(6);
        TreeNode node10 = new TreeNode(7);
        node8.left = node9;
        node8.right = node10;

//        TreeNode node3 = new Node(3, node5, node6);
//        Node node2 = new Node(2, null, node4);
//        root = new Node(1, node2, node3);
        boolean a = hasSubTree(node1, node8);
        System.out.println("a = " + a);
    }


    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null || root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {  //如果上个节点失败，则继续比较tree1的左右子节点
                result = doesTree1HasTree2(root1.left, root2) || doesTree1HasTree2(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {

        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);

    }
}
