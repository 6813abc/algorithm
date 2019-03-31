package com.cyg.suanfa.algorithm;

/**
 * 二叉树的下一个结点:
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author cyg
 * @date 2019/3/31 下午8:10
 **/
public class GetNext {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //1.当该节点的右节点不为空时,右节点的一直沿着左节点找下去就是下一个点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
            //2.1.当该节点的右节点为空时,如果该节点为根节点,那么无下一个节点
        } else if (pNode.next == null) {
            return null;
            //2.2.当该节点的右节点为空时,如果该节点为其父节点的左节点,那么下一个节点就是父节点
        } else if (pNode.next.left == pNode) {
            return pNode.next;
            //2.3.当该节点的右节点为空时,如果该节点为其父节点的右节点且位于根节点的左子树,那么根节点为下一个节点
        } else if (pNode.next.right == pNode) {
            //记录根节点的左节点或者右节点
            TreeLinkNode treeLinkNode = new TreeLinkNode(1);
            while (pNode.next != null) {
                treeLinkNode = pNode;
                pNode = pNode.next;
            }
            //2.4.当该节点的右节点为空时,如果该节点为其父节点的右节点且位于根节点的右子树,那么无下一个节点
            if (pNode.left == treeLinkNode) {
                return pNode;
            }
        }
        return null;
    }
}
