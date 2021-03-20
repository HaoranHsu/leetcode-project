package lc62不同路径;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc62不同路径
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/9 下午4:23
 * @Version: 1.0
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int cnt = 0;
        int[][] ways = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            ways[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            ways[1][i] = 1;
        }
//        ways[2][2] = 2;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                for (int k = 1; k <= i; k++) {
                    ways[i][j] += ways[k][j];
                }
            }
        }
        return ways[m][n];
    }
}
