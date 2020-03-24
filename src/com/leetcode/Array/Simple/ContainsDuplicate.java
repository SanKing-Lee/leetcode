package com.leetcode.Array.Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Sean
 * Date: Created In 23:21 2020/2/22
 * Title: 数组中是否存在重复元素
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 2, 4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        // method 1：利用map存储所有数组中的元素出现的次数，时间复杂度O(n), 空间复杂度O(n)
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int num: nums) {
//            count.merge(num, 1, Integer::sum);
//            if (count.getOrDefault(num, 0) > 1) {
//                return true;
//            }
//        }

        // method 2: 通过排序，将相等的元素放到相邻的位置上，判断是否有相邻相同的元素
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;
    }
}
