package leetcode7;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode7
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/20 下午7:28
 * @Version: 1.0
 * mine
 */
public class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        int ans = 0;
        boolean positive = true;
        if (x < 0) {
            positive = !positive;
            x = -x;
        }
        StringBuilder builder = new StringBuilder();
        while (x > 0) {
            builder.append(x % 10);
            x /= 10;
        }
        try {
            ans = Integer.parseInt(builder.toString());
        } catch (Exception e) {
            return 0;
        }
        if (positive) {
            return ans;
        } else {
            return -ans;
        }
    }
}
