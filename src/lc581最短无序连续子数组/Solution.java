package lc581最短无序连续子数组;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc581
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/13 下午12:38
 * @Version: 1.0
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int l = 0, r = temp.length - 1;
        while (l <= nums.length - 1 && nums[l] == temp[l]) {
            l++;
        }
        while (r >= 0 && nums[r] == temp[r]) {
            r--;
        }
        return r >= l ? r - l + 1 : 0;
    }
}
