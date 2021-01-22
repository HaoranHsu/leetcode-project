package leetcode461;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode461
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/22 下午4:26
 * @Version: 1.0
 * r w
 */
public class Solution2 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
