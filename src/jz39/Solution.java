package jz39;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jz39
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/7 下午8:50
 * @Version: 1.0
 */
class TreeNode {
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

}

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int res = dfs(root);
        return res != -1;
    }

    private int dfs(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int lDepth = dfs(curr.left);
        int rDepth = dfs(curr.right);
        if (lDepth == -1 || rDepth == -1) {
            return -1;
        }
        if (Math.abs(lDepth - rDepth) <= 1) {
            return Math.max(lDepth, rDepth) + 1;
        } else {
            return -1;
        }
    }
}