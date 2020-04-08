package com.heyu.leetcode;

public class _409LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int res = 0;
        for(int num : arr) {
            res += num / 2 * 2;
            if(res % 2 == 0 && num % 2 == 1) {
                res ++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
