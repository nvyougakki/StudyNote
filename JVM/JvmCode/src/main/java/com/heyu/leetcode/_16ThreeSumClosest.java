package com.heyu.leetcode;

import java.util.Arrays;

public class _16ThreeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     *
     * 分析：
     *  先对数组进行排序  [-4, -1, 1, 2]
     *  采用双指针
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        if(nums.length < 3) return result;

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            for(int i = left + 1; i < right; i++) {
                int count = nums[left] + nums[right] + nums[i];

                int del = Math.abs(count - target);
                if(del < min) result = count;
                if(count == target) return count;
                else if(count > target) break;

            }
            left++;
        }
        return result;

    }

    public static void main(String[] args) {
        int res = threeSumClosest(new int[]{-1,2,1,-4}, -3);
        System.out.println(res);
    }
}
