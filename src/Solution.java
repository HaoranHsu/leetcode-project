/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: PACKAGE_NAME
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/2/18 下午7:08
 * @Version: 1.0
 */
public class Solution {
    public static int getBiggestDifference(int[] ints) {
        if (ints == null || ints.length < 2) {
            return -1;
        }
        int len = ints.length;
        //diff代表ints[i]-ints[i+1]
        int[] diff = new int[len - 1];
        for (int i = 1; i < len; i++) {
            diff[i - 1] = ints[i - 1] - ints[i];
        }
        return getBiggestSubSeq(diff);
    }

    public static int getBiggestSubSeq(int[] array) {
        int sum = 0;
        int max = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            sum += array[i];
            if (sum <= 0) {
                sum = 0;
            } else {
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
