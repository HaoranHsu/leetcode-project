package lc752转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc752转盘锁
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/13 下午9:56
 * @Version: 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"},
                "0202");
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        int cnt = 0;
        queue.add("0000");
        Set<String> set = new HashSet<>();
        set.add("0000");
        for (String e : deadends
        ) {
            if (e.equals("0000")) {
                return -1;
            }
            set.add(e);
        }
        while (!queue.isEmpty()) {
            /**
             * 这里有一重sz的循环poll别忘了
             */
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
//                System.out.println(curr);
                if (curr.equals(target)) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    String adj = up(curr, j);
                    if (set.contains(adj)) {
                        continue;
                    } else {
                        queue.add(adj);
                        set.add(adj);
                    }
                }
                for (int k = 0; k < 4; k++) {
                    String adj = down(curr, k);
                    if (set.contains(adj)) {
                        continue;
                    } else {
                        queue.add(adj);
                        set.add(adj);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private String up(String string, int index) {
        char[] chars = string.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] = (char) (chars[index] + 1);
        }
        return new String(chars);
    }

    private String down(String string, int index) {
        char[] chars = string.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] = (char) (chars[index] - 1);
        }
        return new String(chars);
    }
}