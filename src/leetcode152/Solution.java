package leetcode152;

/**
 * Copyright (C), 2019-2020, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode152
 * @ClassName: maxProduct
 * @Author: Tristan Shu
 * @CreateDate: 2020/12/29 下午7:41
 * @Version: 1.0
 */
public class Solution {
    public int maxProduct(int[] nums){
        int length = nums.length;
        int maxF = nums[0];
        int minF = nums[0];
        for(int i = 0; i < length; i++){
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i],Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i],Math.min(mn * nums[i], nums[i]));
        }
        return maxF;
    }
}
