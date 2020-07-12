package com.heyu.leetcode.offer;

public class _6ReversePrint {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {
        int[] ints = null;
        return addVal(head, 0);
    }

    public static int[] addVal(ListNode head, int index) {
        int[] res = null;
        if(head.next != null) {
            res = addVal(head.next, index++);
        } else {
            res = new int[index + 1];
        }
        res[index] = head.val;
        return res;
    }
}


