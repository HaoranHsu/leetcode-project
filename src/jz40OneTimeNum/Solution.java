package jz40OneTimeNum;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jz40OneTimeNum
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 上午10:16
 * @Version: 1.0
 */
public class Solution {
    public int[] FindNumsAppearOnce(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int AandB = 0;
        int m = 1;
        int A = 0, B = 0;
        for (int num : array) {
            AandB ^= num;
        }
        while ((m & AandB) == 0) {
            m <<= 1;
        }
        for (int ann : array) {
            if ((m & ann) == 0) {
                A ^= ann;
            } else {
                B ^= ann;
            }
        }
        return new int[]{A, B};
    }
}
