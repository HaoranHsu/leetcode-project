package leetcode238;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode238
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/25 下午9:22
 * @Version: 1.0
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[1];
        }
        int len = nums.length;
        int[] right = new int[len];
        int[] left = new int[len];
        int[] ans = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = right[i] * left[i];
        }
        return ans;
    }
}