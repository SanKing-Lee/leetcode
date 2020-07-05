package com.leetcode.Array.Simple;

/**
 * Author: Sean
 * Date: Created In 22:45 2020/7/5
 * Title: 子数组最大平均数（1）
 * Description: 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("max average: " + findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        // method1: 生成一个大小为k的滑动窗口，在原数组上进行滑动，每次滑动步长为1，计算平均值，如果大于上次计算的平均值就更新这个值
        int sum = 0;
        int res = 0;
        // init sum
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
//        average = (double)sum/k;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i-k];
            sum += nums[i];
            res = Math.max(sum, res);
        }
        return (double)res/k;
    }
}
