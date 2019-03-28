package com.cyg.suanfa.algorithm;

/**
 * 二叉树的镜像:
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * <p>
 * 递归交换左右子数
 *
 * @author cyg
 * @date 2019/3/28 下午9:18
 **/
public class Mirror {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public void mirror(TreeNode root) {
        TreeNode treeNode;
        if (root != null) {
            treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode3.right = treeNode7;
        Mirror mirror = new Mirror();
        mirror.mirror(treeNode1);
    }
}
