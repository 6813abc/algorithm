package com.cyg.suanfa.algorithm;

/**
 * 平衡二叉树:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author cyg
 * @date 2019/3/29 上午11:10
 **/
public class IsBalanced_Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLength = 1;
        int rightLength = 1;
        leftLength += TreeDepth(root.left);
        rightLength += TreeDepth(root.right);
        if (Math.abs(leftLength - rightLength) > 1) {
            return false;
        }
        return true;
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
}
