package com.leetcode.Array.Simple;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 22:39 2020/3/24
 * Title: 三个数的最大乘积
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, -5};
        System.out.println(maximumProduct(nums));
    }

    private static int maximumProduct(int[] nums) {
        // method1: 排序
        Arrays.sort(nums);
        int len = nums.length;
        // 两个最小的负数乘最大的正数或者最大的三个数相乘即为最大乘积
        return Math.max(
                nums[0]*nums[1]*nums[len-1],
                nums[len-1]*nums[len-2]*nums[len-3]
        );
    }
}
