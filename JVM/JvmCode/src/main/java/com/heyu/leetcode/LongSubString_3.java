package com.heyu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongSubString_3 {


    public static int lengthOfLongestSubstring(String s) {
        /**
         * 滑块
         * String  a  b  c  a  b  c  b  b
         * index   s  e                         //s:start e: end
         **/
        if(s == null || "".equals(s)) return 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
//        char lastChar = ' ';
        for(int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while(set.contains(ch)){
                set.remove(s.charAt(j++));
            }
            set.add(ch);
            result = Math.max(result, set.size());

//            lastChar = ch;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pawbwcwwwkew");
        System.out.println(i);
    }

}
