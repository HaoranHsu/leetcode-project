package leetcode206;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode206
 * @ClassName: Rucursion
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/3 下午1:28
 * @Version: 1.0
 */
public class Rucursion {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
