package leetcode236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode236
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/25 下午8:56
 * @Version: 1.0
 * 想通过son找到parent，这里采用的是hashmap。判断是否出现过，采用hashtable。
 */
public class Solution2 {
    Map<Integer, TreeNode> tree = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p);
            p = tree.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = tree.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            tree.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            tree.put(root.right.val, root);
            dfs(root.right);
        }
        return;
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
