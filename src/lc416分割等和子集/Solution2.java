package lc416分割等和子集;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc416分割等和子集
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/9 上午11:30
 * @Version: 1.0
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums
        ) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = target; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                if (dp[target]) {
                    return true;
                }
            }
        }

        return dp[target];
    }
}
