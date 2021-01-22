package leetcode461;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode461
 * @ClassName: Solution4
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/22 下午4:47
 * @Version: 1.0
 * r w
 */
public class Solution4 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        while (xor != 0) {
            count++;
            xor = xor & (xor - 1);
        }
        return count;
    }
}
