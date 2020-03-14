package com.leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Sean
 * Date: Created In 23:21 2020/3/14
 * Title: 数组中的k-diff数对
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FindPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 1, 5};
        System.out.println(findPairs(nums, 0));
    }

    private static int findPairs(int[] nums, int k) {
//        // method1：利用哈希表
//        if (k < 0) {
//            return 0;
//        }
//        int count = 0, zeroCount = 0;
//        Set<Integer> numSet = new HashSet<>(nums.length);
//        Set<Integer> duplicateSet = new HashSet<>(nums.length);
//        for (int num: nums) {
//            if (numSet.contains(num) && !duplicateSet.contains(num)) {
//                duplicateSet.add(num);
//                zeroCount++;
//            }
//            numSet.add(num);
//        }
//        for (int num: numSet) {
//            if (numSet.contains(num+k)) {
//                count++;
//            }
//        }
//        return k==0?zeroCount:count;
        // method2：利用排序加遍历
        if (k < 0) {
            return 0;
        }
        int count = 0;
        int forthIndex = 0, prev = 0x7fffffff;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[forthIndex] > k) {
                if (++forthIndex != i) i--;
            }
            else if (nums[i] - nums[forthIndex] == k) {
                count++;
            }
        }
        return count;
    }
}
