package leetcode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode207
 * @ClassName: BFS
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/6 上午10:41
 * @Version: 1.0
 */
public class BFS {
    List<ArrayList<Integer>> edges;
    int visited = 0;
    int[] inNum;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        inNum = new int[numCourses];
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inNum[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inNum[i] == 0) {
                queue.offer(i);
            }
        }
        //先上面offer进去*第一轮*的，再while循环拿出Queue中的元素
        while (!queue.isEmpty()) {
            visited++;
            int tempNode = queue.poll();
            for (int node : edges.get(tempNode)) {
                //这句话不能放在下句的后面！
                inNum[node]--;
                if (inNum[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        return numCourses == visited;
    }
}