package leetcode148;

import java.util.List;

/**
 * Copyright (C), 2019-2020, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode_148
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2020/12/28 下午9:49
 * @Version: 1.0
 * 递归方法。不满足时间复杂度要求。
 */


public class Solution {
    public static void main(String[] args) {
        ListNode testNode = new ListNode(3);
        testNode.next = new ListNode(4);
        testNode.next.next = new ListNode(1);
        ListNode ans = sortList(testNode);
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left,right);
    }
    private static ListNode merge(ListNode left,ListNode right){
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyHead = dummyNode;
        ListNode tempLeft = left;
        ListNode tempRight = right;
        while (tempLeft != null && tempRight != null) {
            if (tempLeft.val <= tempRight.val) {
                dummyNode.next = tempLeft;
                tempLeft = tempLeft.next;
            } else {
                dummyNode.next = tempRight;
                tempRight = tempRight.next;
            }
            dummyNode = dummyNode.next;
        }
        while(tempLeft != null){
            dummyNode.next = tempLeft;
            tempLeft = tempLeft.next;
            dummyNode = dummyNode.next;
        }
        while (tempRight != null){
            dummyNode.next = tempRight;
            tempRight = tempRight.next;
            dummyNode = dummyNode.next;
        }
        return dummyHead.next;
    }

    private static class ListNode {
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
