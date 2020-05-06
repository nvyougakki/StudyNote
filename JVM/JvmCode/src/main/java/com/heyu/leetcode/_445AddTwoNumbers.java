package com.heyu.leetcode;

import java.util.Stack;

public class _445AddTwoNumbers {


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode result = null;
        int len1 = 0;
        int len2 = 0;
        while (l1 != null) {
            len1++;
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode lastNode = null;
        int lastAdd = 0;
        for(int i = 0; i < Math.max(len1, len2); i++) {
            int tmpi1 = 0;
            int tmpi2 = 0;
            if(i < len1) {
                tmpi1 = stack1.pop().val;
            }
            if(i < len1) {
                tmpi1 = stack2.pop().val;
            }
            int count = tmpi1 + tmpi2 + lastAdd;
            lastAdd = count/10;
            result = new ListNode(count%10);
            result.next = lastNode;
            lastNode = result;
        }
        if(lastAdd > 0) {
            result = new ListNode(lastAdd);
            result.next = lastNode;
        }
        return result;
    }

}
