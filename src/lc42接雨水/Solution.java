package lc42接雨水;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc42接雨水
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 下午6:08
 * @Version: 1.0
 * <p>
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * 按列来求的话，不要一次想求一个范围，一次求这列能装的就ok了。
 */
public class Solution {
    public int trap(int[] height) {
        Deque<Integer> stk = new LinkedList<>();
        int ans = 0;
        int point = 0;
        while (point < height.length) {
            while (!stk.isEmpty() && height[stk.peek()] < height[point]) {
                int h = stk.peek();
                stk.poll();
                if (stk.isEmpty()) {
                    break;
                }
                ans += (Math.min(height[stk.peek()], height[point]) - height[h]) * (point - stk.peek() - 1);
            }
            stk.push(point++);
        }
        return ans;
    }
}
