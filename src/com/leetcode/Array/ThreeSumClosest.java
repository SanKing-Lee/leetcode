package com.leetcode.Array;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 23:32 2019/4/4
 * Title: 求数组中和最接近目标的三个数
 * Description: Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 初始化左指针、右指针
        int left = 0;
        int right = nums.length - 1;
        // 将返回结果初始化为第一个数、第二个数、最后一个数的求和
        int res = nums[0] + nums[1] + nums[right];
        // 初始化和与目标值的差距
        int minDistance = Math.abs(target - res);
        // 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 获取左指针和右指针
            left = i + 1;
            right = nums.length - 1;
            // 在以当前这个数为核心不变的情况下寻找到一个最接近目标的三个数之和
            while (left < right) {
                // 获得这三个数的和
                int sum = nums[i] + nums[left] + nums[right];
                // 获得它们与目标值的差距
                int distance = Math.abs(target - sum);
                // 如果这个差距比最小差距小，则更新结果和最小差距
                if (minDistance > distance) {
                    minDistance = distance;
                    res = sum;
                }
                // 如果和大于目标值，则减小和，通过减小右指针
                if (sum > target) {
                    right--;
                } else if (sum < target) {  // 和小于运目标值，增大和，通过增大左指针
                    left++;
                } else {                    //  和与目标值相等，肯定是最小的差距了，直接返回目标值
                    return target;
                }
            }
        }
        return res;
    }
}
