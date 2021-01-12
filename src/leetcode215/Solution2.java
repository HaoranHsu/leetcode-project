package leetcode215;

import java.util.PriorityQueue;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode215
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/12 下午11:29
 * @Version: 1.0
 */
public class Solution2 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
