package lc33搜索旋转排序数组;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc33搜索旋转排序数组
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午3:52
 * @Version: 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

//    private int searchAns(int[] nums, int i, int peakIndex,int target) {
//        int l = i;
//        int r = peakIndex;
//        int mid = (l+r)/2;
//        while (l<=r){
//            if(nums[mid]>target){
//                r = mid - 1;
//            }else if(nums[mid]<target) {
//                l = mid + 1;
//            }else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && target >= nums[0]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
