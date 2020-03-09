package com.leetcode.Array;

/**
 * Author: Sean
 * Date: Created In 22:53 2020/3/9
 * Title: 最大连续1的个数
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        // method1：遍历整个数组，维护一个连续1的计数值
        int onesCount = 0;
        int maxOnesCount = 0;
        int i = 0;
        while(i < nums.length) {
            while (i < nums.length && nums[i] == 1) {
                onesCount++;
                i++;
            }
            if (onesCount > maxOnesCount) maxOnesCount = onesCount;
            onesCount = 0;
            i++;
        }
        return maxOnesCount;
    }
}
