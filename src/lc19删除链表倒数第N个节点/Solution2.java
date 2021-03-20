package lc19删除链表倒数第N个节点;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc19删除链表倒数第N个节点
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 上午11:20
 * @Version: 1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode root = head;
        int depth = dfs(head, n);
        if (depth == n) {
            return root.next;
        }
        return root;
    }

    private int dfs(ListNode curr, int n) {
        if (curr == null) {
            return 0;
        }
        int currCnt = dfs(curr.next, n) + 1;
        if (currCnt == n + 1) {
            curr.next = curr.next.next;
        }
        return currCnt;
    }
}