package com.heyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeNums {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 采用双指针法
     * 先进行排序，然后遍历数组
     * 1、当nums[i]>0时，由于nums[i] <= nums[left] <= nums[right]，直接break
     * 2、去重，遍历重复时候，直接continue
     * 3、left = i + 1; right = length - 1; left < right
     *      |  当sum == 0，执行循环，判断左右边界是否重复，最后left++, right--
     *      |
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeNums(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeNums(new int[]{-2,-1,0,1,1}));
    }
}
