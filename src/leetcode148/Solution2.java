package leetcode48;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.rmi.UnexpectedException;
import java.util.List;

/**
 * Copyright (C), 2019-2020, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode_148
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2020/12/29 下午1:56
 * @Version: 1.0
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode testNode = new ListNode(-1);
        testNode.next = new ListNode(5);
        testNode.next.next = new ListNode(3);
        testNode.next.next = new ListNode(4);
        testNode.next.next = new ListNode(0);
        ListNode ans = sortList(testNode);
    }
    public static ListNode sortList(ListNode head){
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            length++;
        }
        ListNode dummyNode = new ListNode(-1, head);
        for(int subLength = 1; subLength < length; subLength <<= 1){
            ListNode prev = dummyNode;
            ListNode curr = dummyNode.next;
            while(curr != null){
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i = 1; i < subLength && curr!=null && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode next = null;
                //这个判断是必要的，因为可能不进入上一个for循环！！导致curr为null时空指针错误。
                if(curr!=null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1,head2);
                prev.next = merged;
                while (prev.next!=null){
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyNode.next;
    }
    private static ListNode merge(ListNode left, ListNode right){
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

    public static class ListNode {
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
