package leetcode461;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode461
 * @ClassName: Solution3
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/22 下午4:34
 * @Version: 1.0
 * r w
 */
public class Solution3 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        //不应该是 > 。
        while (xor != 0) {
            if (xor % 2 == 1) {
                count++;
            }
            xor = xor >>> 1;
        }
        return count;
    }
}
