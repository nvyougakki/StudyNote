package com.heyu.leetcode;

public class _11MaxArea {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，
     * 每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        /**
         * 解题思路，采用双指针法
         * 首先将两个指针指向开始和末尾
         * 然后将更小的那边慢慢像中心靠拢
         * 直到开始指针>=末尾指针
         * arr  1, 8, 6, 2, 5, 4, 8, 3, 7
         * +---------- step1 ---------------
         * +  start = 0    end = 8
         * +  1 < 7 , 则start++
         * +--------------------------------
         *
         * 为什么双指针是对的，能取到最大值
         * 小边向中心靠拢：后续的值有可能大于当前最大值
         * 大边向中心靠拢：由于取最短边，如果是大边向中心靠拢，因为取最短边，所以下一步取到的值永远都小于等于当前值
         *
         * 比如：当start是0， end是8；则H = 1 * 8 = 8
         * 这种时候，其实已经取到了当1这个数的时候所能取到的最大值
         */
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while((end - start) >= 1) {
            int numStart = height[start];
            int numEnd = height[end];
            result = Math.max((end - start) * Math.min(numStart, numEnd), result);
            int i = numEnd >= numStart ? start++ : end--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
