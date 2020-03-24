package com.leetcode.Array.Simple;

import java.util.Arrays;
import java.util.Stack;

/**
 * Author: Sean
 * Date: Created In 23:04 2020/3/16
 * Title: 最短无序子数组
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }

    private static int findUnsortedSubarray(int[] nums) {
//        // method1: 排序之后对比数组
//        int[] numsDuplicate = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(numsDuplicate);
//        int begin = 0, end = 0;
//        int i = 0;
//        // 找到第一个不同的地方，也就是无序子数组的开始
//        while (i < nums.length && nums[i] == numsDuplicate[i]) {
//            i++;
//        }
//        // 如果整个数组都是有序的
//        if (i == nums.length) {
//            return 0;
//        }
//        begin = i;  // 记录无序数组开始的地方
//        boolean isOrdered = false;  // 维护是否后续的子序列都是有序的
//        while (i < nums.length) {
//            // 遇到了一个相同的元素
//            if (numsDuplicate[i] == nums[i]) {
//                // 如果此时不是已经有序的，则可能是刚进入有序的部分，更新end
//                if (!isOrdered) {
//                    isOrdered = true;
//                    end = i;
//                }
//                // 如果已经有序了，则说明在之前就进入了有序的部分，不更新end
//            }
//            // 遇到了不同的元素，将end重置为0，isOrdered重置为false
//            else {
//                end = 0;
//                isOrdered = false;
//            }
//            i++;
//        }
//        // 如果end为0，说明后续的子序列都是无序的，否则是包括了有序的
//        return end==0?nums.length-begin:end-begin;
        // method2：借用栈寻找无序数组的边界
        Stack<Integer> bound = new Stack<>();
        int begin = nums.length, end = 0;
        // 正序遍历，找到无序子数组的开始
        for (int i = 0; i < nums.length; i++) {
            while (!bound.isEmpty() && nums[i] < nums[bound.peek()]) {
                begin = Math.min(begin, bound.pop());
            }
            bound.push(i);
        }
        bound.clear();
        // 逆序遍历，找到无序子数组的结束
        for (int i = nums.length-1; i >= 0; i--) {
            while (!bound.isEmpty() && nums[i] > nums[bound.peek()]) {
                end = Math.max(end, bound.pop());
            }
            bound.push(i);
        }
        return (end - begin > 0) ? end-begin + 1:0;
    }
}
