package leetcode221;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode221
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/22 下午4:53
 * @Version: 1.0
 *r w
 *
 * 本来想的是dp是左上角和右下角两个位置的函数，但是题目求最大值即可，所以不用这么精确！仅仅dp是右下角的函数即可。
 *
 * 基于此解法进一步！：空间复杂度：O(mn)O(mn)，其中 mm 和 nn 是矩阵的行数和列数。创建了一个和原始矩阵大小相同的矩阵 dp。由于状态转移方程中的 dp(i, j)dp(i,j) 由其上方、左方和左上方的三个相邻位置的 dpdp 值决定，因此可以使用两个一维数组进行状态转移，空间复杂度优化至 O(n)O(n)。
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int count = 0;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 0 ? 0 : 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                count = Math.max(count, dp[i][j]);
            }
        }
        return count * count;
    }
}