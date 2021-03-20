package lc1539第k个缺失正整数;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc1539第k个缺失正整数
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 下午9:52
 * @Version: 1.0
 */
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr.length == 0) {
            return k;
        }
        int count = 0;
        int num = 0;
        if (arr[0] != 1) {
            for (int i = 1; i < arr[0] - 1; i++) {
                count++;
                if (count == k) {
                    return arr[0] + i;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                break;
            } else {
                for (int j = 1; j <= arr[i] - arr[i - 1]; j++) {
                    count++;
                    num = arr[i] + j;
                    if (count == k) {
                        return num;
                    }
                }
            }
        }
        return 0;
    }
}
