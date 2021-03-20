package lc337打家劫舍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc337打家劫舍
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/13 上午10:45
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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(true, root);
    }

    private int dfs(boolean flag, TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        if (flag) {
            return Math.max(dfs(!flag, curr.left) + dfs(!flag, curr.right) + curr.val,
                    dfs(flag, curr.right) + dfs(flag, curr.left));
        } else {
            return dfs(!flag, curr.left) + dfs(!flag, curr.right);
        }
    }
}