package leetcode238;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode238
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/25 下午10:14
 * @Version: 1.0
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[1];
        }
        int len = nums.length;
        int[] ans = new int[len];
        int tempRight = 1;
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int j = len - 2; j >= 0; j--) {
            tempRight = tempRight * nums[j + 1];
            ans[j] = ans[j] * tempRight;
        }
        return ans;
    }
}
