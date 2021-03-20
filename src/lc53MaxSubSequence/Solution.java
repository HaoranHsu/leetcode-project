package lc53MaxSubSequence;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc53MaxSubSequence
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 上午11:23
 * @Version: 1.0
 */
public class Solution {
    public int MaxSubArray(int[] nums) {
        /**
         * 不能初始化为0
         */
        int ans = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(num, num + pre);
            ans = Math.max(pre, ans);
        }
        return ans;
    }
}
