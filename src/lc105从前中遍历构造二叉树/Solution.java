package lc105从前中遍历构造二叉树;

import com.sun.source.tree.Tree;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc105从前中遍历构造二叉树
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/12 上午10:06
 * @Version: 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return patition(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode patition(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        TreeNode curr = new TreeNode(preorder[preStart]);
        int head = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                head = i;
                break;
            }
        }
        curr.left = patition(preorder, inorder, preStart + 1, head - inStart + preStart, inStart, head - 1);
        curr.right = patition(preorder, inorder, head - inStart + preStart + 1, preEnd, head + 1, inEnd);
        return curr;
    }
}