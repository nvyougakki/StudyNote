package com.heyu.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeIntervals_56 {


    public static int[][] merge(int[][] intervals) {
        List<int[]> ints = Arrays.asList(intervals);
        //根据左区间排序
        Collections.sort(ints, Comparator.comparingInt((a) -> a[0]));
        List<int[]> result = new ArrayList<>();
        int start = ints.get(0)[0];
        int end = ints.get(0)[1];
        for(int[] tmp : ints) {
            //有交集
            if(end >= tmp[0]) {
                end = Math.max(end, tmp[1]);
            }
            else {
                result.add(new int[]{start, end});
                start = tmp[0];
                end = tmp[1];

            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{1,4},new int[]{4,5}/*, new int[]{2,6}*/};
        int[][] result = merge(arr);
        Arrays.asList(result).forEach(a -> System.out.println("[" + a[0] + "," + a[1] + "],"));
    }

}
