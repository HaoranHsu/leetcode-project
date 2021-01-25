package leetcode236;

import java.lang.management.ManagementPermission;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode236
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/25 下午6:18
 * @Version: 1.0
 */
public class Solution {
    TreeNode ans;

    Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p == null || q == null) {
            return p == null ? q : p;
        }
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        //这里不能先判断直接return
//        if(node.val == p.val || node.val == q.val){
//            return true;
//        }
        boolean leftContains = dfs(node.left, p, q);
        boolean rightContains = dfs(node.right, p, q);
        //应该想到这种判断方法直接判断，就不用把true的点全部存起来然后选点了
        if ((leftContains && rightContains) || ((node == p || node == q) && (leftContains || rightContains))) {
            ans = node;
        }
        //应该加在这里的两条
        return leftContains || rightContains || node == q || node == p;
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
