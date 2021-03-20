package leetcode300;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode300
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/14 下午3:36
 * @Version: 1.0
 * 关键在于需要确定一些东西，确定起始点不可行，确定终止点nums[i]必须取到，然后建立动态规划状态转移方程。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int maxLength = 1;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
