package lc98验证二叉搜索树;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc98验证二叉搜索树
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午8:38
 * @Version: 1.0
 * <p>
 * <p>
 * 不行。。。
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root)[0] == 1;
    }

    private long[] dfs(TreeNode curr) {
        if (curr == null) {
            // tree min max
            return new long[]{1, Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] infoL = dfs(curr.left);
        long[] infoR = dfs(curr.right);

        boolean currIsTree = true;
        currIsTree = currIsTree && (curr.val > infoL[2]) && (curr.val < infoR[1]) && (infoL[0] == 1) && (infoR[0] == 1);

        long minVal = Math.min(curr.val, Math.min(infoL[1], infoR[1]));
        long maxVal = Math.max(curr.val, Math.min(infoR[2], infoL[2]));
        if (currIsTree == true) {
            return new long[]{1, minVal, maxVal};
        } else {
            return new long[]{0, minVal, maxVal};
        }
    }
}