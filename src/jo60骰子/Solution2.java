package jo60骰子;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jo60
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 下午3:55
 * @Version: 1.0
 */
public class Solution2 {
    public double[] dicesProbability(int n) {
        if (n < 1) {
            return new double[0];
        }
        double a = 1.0 / 6.0;
        double[] dp = new double[]{a, a, a, a, a, a};
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
