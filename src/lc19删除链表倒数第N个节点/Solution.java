package lc19删除链表倒数第N个节点;


/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc19删除链表倒数第N个节点
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 上午10:22
 * @Version: 1.0
 * <p>
 * 这样不好 应该设一个dummy
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        int cnt = 0;
        ListNode root = head;
        ListNode temp = root;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        if (cnt == n) {
            return root.next;
        } else if (cnt == n + 1) {
            root.next = root.next.next;
            return root;
        }
        for (int i = 1; i <= cnt; i++) {
            temp = temp.next;
            if (i == cnt - n - 1) {
                temp.next = temp.next.next;
                break;
            }
        }
        return root;
    }
}