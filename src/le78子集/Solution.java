package le78子集;

import java.util.*;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: le78子集
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/12 下午10:24
 * @Version: 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            dfs(nums, 0, i, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int index, int length, List<Integer> level, List<List<Integer>> ans) {
        if (level.size() == length) {
            ans.add(new ArrayList<>(level));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            level.add(nums[i]);
            /**
             * 下面不是index+1！
             */
            dfs(nums, i + 1, length, level, ans);
            level.remove(level.size() - 1);
        }
    }
}