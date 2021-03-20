package leetcode207;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode207
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/5 下午4:37
 * @Version: 1.0
 */
public class Solution {
    int[] visited;
    boolean valid = true;
    List<List<Integer>> edge;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int preNum = prerequisites.length;
        visited = new int[numCourses];
        edge = new ArrayList<>(preNum);
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edge.get(info[0]).add(info[1]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int i : edge.get(u)) {
            if (visited[i] == 0) {
                dfs(i);
                if (!valid) {
                    return;
                }
            } else if (visited[i] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;

    }
}
