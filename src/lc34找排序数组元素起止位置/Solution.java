package lc34找排序数组元素起止位置;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc34找排序数组元素起止位置
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午7:17
 * @Version: 1.0
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int leftIndex = -1;
        int rightIndex = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                rightIndex = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }

        if (leftIndex == -1) {
            return new int[]{-1, -1};
        }
        while (leftIndex >= 0 && nums[leftIndex] == target) {
            leftIndex--;
        }
        while (rightIndex < nums.length && nums[rightIndex] == target) {
            rightIndex++;
        }
        return new int[]{++leftIndex, --rightIndex};
    }
}