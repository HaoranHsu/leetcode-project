package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode15
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/20 下午8:32
 * @Version: 1.0
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int MIN_VALUE = 3;
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        int end;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                end = len - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //这里不要忘了end > j
                while (end > j && nums[i] + nums[j] + nums[end] > 0) {
                    end--;
                }
                //这里需要增加：如果指针重合了，肯定找不到答案了，那就跳出循环，减少计算量。
                if (end == j) {
                    break;
                }
                if (nums[i] + nums[j] + nums[end] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[end]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
