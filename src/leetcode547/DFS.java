package leetcode547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode547
 * @ClassName: DFS
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/8 下午4:59
 * @Version: 1.0
 */
public class DFS {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinceNum = 0;
        int cityNum = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cityNum; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int currCity = queue.poll();
                    visited[currCity] = true;
                    for (int j = 0; j < cityNum; j++) {
                        if (!visited[j] && isConnected[currCity][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
                provinceNum++;
            }
        }
        return provinceNum;
    }

}
