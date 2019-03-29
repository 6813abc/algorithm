package com.cyg.suanfa.algorithm;

/**
 * 二叉树的深度:
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * 递归
 *
 * @author cyg
 * @date 2019/3/29 上午10:27
 **/
public class TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = 1;
        int rightLength = 1;
        leftLength += TreeDepth(root.left);
        rightLength += TreeDepth(root.right);
        return leftLength >= rightLength ? leftLength : rightLength;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode6.left = treeNode7;
        TreeDepth treeDepth = new TreeDepth();
        System.out.println(treeDepth.TreeDepth(treeNode1));
    }
}
