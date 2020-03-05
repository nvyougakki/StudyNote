package com.heyu.leetcode;

/**
 * @ClassName TwoArrayMedian4
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/27 21:17
 */
public class _4TwoArrayMedian {

    /**
     *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *  请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
        你可以假设 nums1 和 nums2 不会同时为空。
        示例 1:
         nums1 = [1, 3]
         nums2 = [2]

        则中位数是 2.0
         示例 2:

         nums1 = [1, 2]
         nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5

     分析：
     偶数个切割
     index:  0  1  2   3  4   5   6
     nums1:  3  5  6 | 8  9            cut1：3
     nums2:  1  3  5 | 7  10  11  12   cut2：3
     普通方法：
        将两个数组组合排序得到：
            1 3 3 5 5 6 | 7 8 9 10 11 12  中位数是(6 + 7)/2
            但是不符合时间复杂度要求
        时间复杂福O(log(m+n))意味着需要二分法查询
     二分法：
        假设k1 = nums1.length; k2 = nums2.length
        则有cut1 + cut2 = (k1 + k2)/2
        换种思考方式，相当于求数组中(k1 + k2)/2位置上的数
        由普通方法可知，两个数组相当于一个数组切割成两份
        当左边的最大值小于右边的最小值，则确定中位数
        假如是偶数个，则是相等的两份
        切割线左边数量=切割线右边数量，cut的值代表左边的切割数量

        偶数个切割，
         index:  0  1  2   3  4   5   6
                       L1  R1
         nums1:  3  5  6 | 8  9            cut1：3
         nums2:  1  3  5 | 7  10  11  12   cut2：3
                       L2  R2
        奇数个切割：
         index:  0  1  2   3  4   5   6
                       L1  R1
         nums1:  3  5  6 | 8  9   15       cut1：3
         nums2:  1  3  5 | 7  10  11  12   cut2：3
                       L2  R2
                1 3 3 5 5 6 7 8 9 10 11 12  15  中位数就是7

         index:  0  1  2  3  4  5   6
         L1  R1
         nums1:  1  2                         cut1：2
         nums2:  1  3  5  7  8  9           cut2：4
         L2  R2



     * @Description //TODO
     * @Date 21:17 2019/11/27
     * @Param
     * @return
     **/

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //将更小的数组放在前面
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        //切割左右两边的和
        int len = nums1.length + nums2.length;
        //切割值，为切割线左边的数量
        int cut1 = 0;
        int cut2 = 0;

        //切割范围
        int cutL = 0;
        int cutR = nums1.length;

        while(cut1 <= nums1.length){
            cut1 = (cutR - cutL)/2 + cutL;
            cut2 = len/2 - cut1;
            System.out.println("cut1:" +  cut1 + ",cut2:" + cut2);
//            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
//            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
//            double R1 = cut1 == 0 ? Integer.MAX_VALUE : nums1[cut1];
//            double R2 = cut2 == 0 ? Integer.MAX_VALUE : cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if(L1 > R2) {
                cutR = cut1 - 1;
            } else if(L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if( len % 2 == 0 ) {
                     return (Math.max(L1, L2) + Math.min(R1,R2))/2;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{7,8}, new int[]{3,4,5,6}));
    }

}
