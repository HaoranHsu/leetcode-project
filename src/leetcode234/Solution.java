package leetcode234;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode234
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/7 下午8:32
 * @Version: 1.0
 * <p>
 * 重视此道题的递归算法，有详细的讲解。
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new LinkedList<>();
        ListNode root = head;
        while (root != null) {
            list.add(root.val);
            root = root.next;
        }
        while (!list.isEmpty()) {
            if (list.size() > 0 && list.remove(list.size() - 1) != head.val) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
