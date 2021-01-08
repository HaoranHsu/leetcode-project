package leetcode283;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode283
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/8 下午5:28
 * @Version: 1.0
 * <p>
 * 没有细看多种方法。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 1;
        int length = nums.length;
        while (slow < length && fast < length) {
            if (nums[slow] == 0) {
                while (fast + 1 < length && nums[fast] == 0) {
                    fast++;
                }
                swarp(slow, fast, nums);
            }
            slow++;
            fast++;
        }
    }

    private void swarp(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
