package leetcode226;


/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode226
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/4 下午10:58
 * @Version: 1.0
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/shou-hua-tu-jie-san-chong-xie-fa-di-gui-liang-chon/ 先序遍历和后序遍历
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    private void inverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        inverse(root.left);
        inverse(root.right);
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
