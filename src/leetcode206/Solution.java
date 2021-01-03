package leetcode206;


/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode206
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/3 上午12:46
 * @Version: 1.0
 */
public class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }
}
