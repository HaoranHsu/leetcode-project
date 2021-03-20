package lc437路径总和;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc437路径总和
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/11 下午7:35
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


class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> preMap = new HashMap<>();
        /***
         * 别忘了。
         */
        preMap.put(0, 1);
        return dfs(root, preMap, 0, sum);
    }

    private int dfs(TreeNode curr, Map<Integer, Integer> preMap, int preVal, int sum) {
        if (curr == null) {
            return 0;
        }
        int corrNum = 0;
        int currVal = preVal + curr.val;

        /**
         * 这两句顺序错的话，sum为0就不对
         */
        corrNum += preMap.getOrDefault(currVal - sum, 0);
        preMap.put(currVal, preMap.getOrDefault(currVal, 0) + 1);

        corrNum += dfs(curr.left, preMap, currVal, sum);
        corrNum += dfs(curr.right, preMap, currVal, sum);

        preMap.put(currVal, preMap.get(currVal) - 1);
        return corrNum;
    }
}