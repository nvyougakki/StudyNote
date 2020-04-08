package com.heyu.leetcode;

import java.util.Arrays;

public class _40GetLeastNumbers {

    public static int getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int res = 0;
        for(int i = 0; i < k; i++) {
            res += arr[i];
        }
        return res;
    }

}
