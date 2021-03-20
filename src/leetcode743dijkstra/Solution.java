package leetcode743dijkstra;

import java.util.*;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode743dijkstra
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/7 下午10:39
 * @Version: 1.0
 */
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times
        ) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Map<Integer, Integer> dis = new HashMap<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        heap.add(new int[]{0, k});

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dis.containsKey(node)) {
                continue;
            }
            dis.put(node, d);

            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], d1 = edge[1];
                    if (!dis.containsKey(nei)) {
                        heap.add(new int[]{d1 + d, nei});
                    }
                }
            }
        }

        if (dis.size() < n) {
            return -1;
        }
        int minDis = 0;
        for (int cand : dis.values()) {
            minDis = Math.max(minDis, cand);
        }
        return minDis;

    }
}
