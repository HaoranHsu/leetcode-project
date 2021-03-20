package leetcode46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode46
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/7 下午9:38
 * @Version: 1.0
 */
public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        for (int num : nums
        ) {
            level.add(num);
        }
        partition(nums.length, 0, level);
        return ans;
    }

    private void partition(int len, int index, List<Integer> level) {
        if (index == len - 1) {
            ans.add(new ArrayList<>(level));
            return;
        }
        for (int i = index; i < len; i++) {
            Collections.swap(level, i, index);
            partition(len, index + 1, level);
            Collections.swap(level, i, index);
        }
    }

//
//    private void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
