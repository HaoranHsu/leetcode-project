package lc55跳跃游戏;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc55跳跃游戏
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午10:38
 * @Version: 1.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == true && nums[j] >= (i - j)) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}