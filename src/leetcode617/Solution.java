package leetcode617;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode617
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/13 下午11:18
 * @Version: 1.0
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        merge(t1, t2);
        return t1;
    }

    private TreeNode merge(TreeNode root, TreeNode t2) {
        //学会怎么确定终止条件。
        if (root == null) {
            return t2;
        }
        if (t2 == null) {
            return root;
        }
        root.val = root.val + t2.val;
        root.left = merge(root.left, t2.left);
        root.right = merge(root.right, t2.right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
