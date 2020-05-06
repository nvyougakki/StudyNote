package com.heyu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        start(result, n, new StringBuffer(), 0, 0);
        return result;
    }

    public static void start(List<String> result, int max, StringBuffer curr, int left, int right){

        if(curr.length() == max * 2){
            result.add(curr.toString());
            return;
        }
        if(left < max) {
            curr.append("(");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
