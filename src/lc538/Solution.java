package lc538;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc538
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/22 下午8:58
 * @Version: 1.0
 * <p>
 * <p>
 * 像这种包含所有大于的数 -> 包含排序 的题，想到中序遍历 -> 反中序遍历。就不用向上return参数，向下传入参数了。
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
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}