package lc55跳跃游戏;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc55跳跃游戏
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午11:08
 * @Version: 1.0
 */
public class Solution2 {
    public class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
