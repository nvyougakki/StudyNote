package com.heyu.leetcode;

public class LongestPalindrome_5 {


    public static String longestPalindrome(String s) {
        /**
         * 马拉车算法，原问题中最长回文字符窜可能是奇数或偶数个
         * 将字符转化为下面的格式，开始和结束都用字符窜中不存在的字符即可
         * 中间用相同字符将字母隔开
         * 这样最后
         * 原字符：  b a a b a d
         *          0 1 2 3 4 5   2(n+1) = 1/2
         * 现字符： ^ # b # a # a # b # a # d # $
         *  0 1 2 3 4 5 6 7 8 9
         *  index: 5   len :4
         */
        if(null == s || s.length() == 0) return "";
        char[] chars = new char[2 * s.length() + 3];
        int k = 0;
        chars[k++] = '^';

        int index = 0;
        int len = 1;
        for(int i = 0; i < s.length(); i++) {
            chars[k++] = '#';
            chars[k++] = s.charAt(i);
        }
        chars[k++] = '#';
        chars[k++] = '$';
        for(int i = 1; i < chars.length - 1; i++ ) {
            int j = 1;
            while (
//                    j <= Math.min(i - 0, chars.length - 1 - i) &&
                            chars[i - j] == chars[i + j]
            ) {
                j++;
            }
            if(j > len) {
                index = i;
                len = j;
            }
        }
        int start = (index - len) / 2;
        return s.substring(start, start + len - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbb"));
    }
}
