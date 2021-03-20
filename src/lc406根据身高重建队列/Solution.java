package lc406根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc406根据身高重建队列
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/13 下午3:57
 * @Version: 1.0
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] e : people
        ) {
            ans.add(e[1], e);
        }
        return ans.toArray(new int[people.length][2]);


    }
}