package jo60骰子;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jo60
 * @ClassName: Solution3
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 下午4:43
 * @Version: 1.0
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        double[] ans = solution3.dicesProbability(2);
        for (double i : ans
        ) {
            System.out.println(i);
        }
    }

    public double[] dicesProbability(int n) {
        if (n < 1) {
            return new double[0];
        }
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i < 7; i++) {
            dp[1][i] = 1.0;
        }
        for (int i = 2; i <= n; i++) {
            int num = 5 * (i - 1) + 1;
            for (int j = (i - 1); j <= 6 * (i - 1); j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j + k] += dp[i - 1][j];
                }
            }
        }
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= n + ans.length - 1; i++) {
            ans[i - n] = dp[n][i] / Math.pow(6, n);
        }
        return ans;
    }
}