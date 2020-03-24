package com.leetcode.Array.Simple;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 23:13 2020/2/21
 * Title: 旋转数组
 * Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        // method 1: 暴力求解，时间复杂度O(n*k)，空间复杂度O(1)
//        // 移动k次
//        for (int i = 0; i < k; i++) {
//            // 每次移动一个数字
//            int temp = nums[nums.length-1];
//            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
//            nums[0] = temp;
//        }

        // method 2: 反转法，先将整个数组反转，然后分别反转前k个元素和后n-k个元素
        //           时间复杂度O(n)，空间复杂度O(1)
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }

}
