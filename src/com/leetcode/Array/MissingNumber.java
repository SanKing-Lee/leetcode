package com.leetcode.Array;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 23:31 2020/3/1
 * Title: 缺失的数字
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 2};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        // method1: 排序后找出和下标不一致的数字
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++) {
//            // 缺失的数字在开头，为0
//            if (i == 0 && nums[i] != 0) {
//                return 0;
//            }
//            // 缺失的数字在中间
//            else if (nums[i] != i) {
//                return i;
//            }
//        }
//        // 缺失的数字在末尾
//        return nums.length;

        // method2: 找出最大的值，从0累加到最大值，用这个值去减数组中的元素，剩下的就是缺失的数字
        // 表示是否出现了0这个元素
        boolean zeroExist = false;
        int max = nums[0];
        int numsSum = 0;
        // 找出最大的值和是否存在0
        for(int num:nums) {
            numsSum += num;
            if(num == 0) {
                zeroExist = true;
            }
            if(num > max) {
                max = num;
            }
        }
        // 如果数组中不存0，则说明缺失了0，返回0
        if(!zeroExist) {
            return 0;
        }
        // 求出0到max的累加和
        int sum = 0;
        for ( int i = 1; i <= max; i++) {
            sum += i;
        }
        // 用累加和减去数组元素之和，剩下的就是缺失的数字
        sum -= numsSum;
        // 缺失的是最后一个数字
        if(sum == 0) {
            return nums.length;
        }
        return sum;
    }
}
