package leetcode215;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode215
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/12 下午9:25
 * @Version: 1.0
 */
public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        //直接返回k-1下标的元素即可
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }
}
