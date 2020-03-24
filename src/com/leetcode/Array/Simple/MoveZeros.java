package com.leetcode.Array.Simple;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 23:12 2020/3/3
 * Title: 移动零
 * Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println("Before movement: " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("After movement: " + Arrays.toString(nums));
    }

    private static void moveZeros(int[] nums) {
//        // method1：暴力解法，将每个0和后面的数字进行交换至末尾，时间复杂度O(n^2)，空间复杂度O(1)
//        for(int i = nums.length-1; i >= 0; i--) {
//            if(nums[i] == 0) {
//                for(int j = i, k = i+1; k < nums.length; j++,k++) {
//                    nums[j]^=nums[k];
//                    nums[k]^=nums[j];
//                    nums[j]^=nums[k];
//                }
//            }
//        }
        // method2：双指针法
        int nonZeroIndex = 0, zeroIndex = 0;
        // 找到第一个0的下标
        while(zeroIndex < nums.length && nums[zeroIndex] != 0) zeroIndex++;
        nonZeroIndex = zeroIndex;
        if(zeroIndex > nums.length-1) return;

        while(zeroIndex < nums.length) {
            // 找到下一个不为0的元素
            while (zeroIndex < nums.length && nums[zeroIndex] == 0) zeroIndex++;
            if(zeroIndex > nums.length-1) break;
            // 交换值
            nums[nonZeroIndex++] = nums[zeroIndex++];
        }

        for(int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
