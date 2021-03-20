package lc95不同的二叉搜索树;

import java.util.ArrayList;
import java.util.List;

import leetcode226.Solution.TreeNode;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc95不同的二叉搜索树
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/9 下午1:06
 * @Version: 1.0
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int l, int r) {
        List<TreeNode> allTreews = new ArrayList<>();
        if (l > r) {
            allTreews.add(null);
            return allTreews;
        }
        for (int i = l; i < r + 1; i++) {
            List<TreeNode> leftTrees = generate(l, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, r);

            for (TreeNode lNode : leftTrees
            ) {
                for (TreeNode rNode : rightTrees
                ) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    allTreews.add(root);
                }
            }
        }
        return allTreews;
    }
}