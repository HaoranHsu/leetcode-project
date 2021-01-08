package leetcode547;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode547
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/8 下午3:48
 * @Version: 1.0
 * <p>
 * <p>
 * 并查集的答案没有看。
 */
public class Solution {
    int numProvince = 0;
    int numCity;
    int[] visited;

    public int findCircleNum(int[][] isConnected) {
        numCity = isConnected.length;
        visited = new int[numCity + 1];
        for (int i = 0; i < numCity; i++) {
            if (visited[i + 1] == 0) {
                numProvince++;
                dfs(isConnected, i + 1);
            }
            visited[i + 1] = 1;
        }
        return numProvince;
    }

    private void dfs(int[][] isConnected, int CityIndex) {
        for (int j = 0; j < numCity; j++) {
            if (visited[j + 1] == 0 && isConnected[CityIndex - 1][j] == 1) {
                visited[j + 1] = 1;
                dfs(isConnected, j + 1);
            }
        }
    }
}
