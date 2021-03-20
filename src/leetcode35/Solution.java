package leetcode35;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode35
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/15 下午1:07
 * @Version: 1.0
 * <p>
 * 记住这个模版。
 */
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
//    public static void main(String[] args) {
//        searchInsert(new int[]{0,1,2,3,4},2);
//    }
}
