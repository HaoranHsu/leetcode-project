package leetcode2;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode2
 * @ClassName: Soltuion
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/15 下午4:03
 * @Version: 1.0
 * 边界测试[0] + [0]
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 所以我的方法int会越界
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int sum = 0;
        int weight = 1;
        ListNode root = new ListNode(-1);
        ListNode node = root;
        while (l1 != null && l2 != null) {
            sum += l1.val * weight + l2.val * weight;
            weight *= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum += l1.val * weight;
            weight *= 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum += l2.val * weight;
            weight *= 10;
            l2 = l2.next;
        }
        /**
         * 边界测试[0] + [0] 添加=号
         */
        while (sum >= 0) {
            node.next = new ListNode(sum % 10);
            sum /= 10;
            node = node.next;
            /**
             * 但是>=后无法退出了 所以继续加一下【退出条件】
             */
            if (sum == 0) {
                break;
            }
        }

        return root.next;
    }

    public class ListNode {
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
}
