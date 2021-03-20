package leetcode461;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode461
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/21 下午11:20
 * @Version: 1.0
 * r w
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x /= 2;
            y /= 2;
        }
        return count;
    }
}
