package com.leetcode.Array.Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Sean
 * Date: Created In 23:17 2020/2/29
 * Title: 指定范围内是否包含相同元素
 * Description: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 *              使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ContainsNearbyDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicates(nums, k));
    }

    public static boolean containsNearbyDuplicates(int[] nums, int k) {
        // method 1: 暴力穷举法，时间复杂度O(n^2)，空间复杂度O(0)
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j] && j-i <= k) {
//                    return true;
//                }
//            }
//        }
//        return false;

        // method 2: 暴力穷举的优化，时间复杂度O(n*k)，空间复杂度O(0)
//        for (int i = 0; i < nums.length; i++) {
//            // 只对当前元素的后面k个元素进行搜索
//            for (int j = i+1; j <= i+k && j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
        // method 3: 哈希表，整数值作为键，下标作为值，时间复杂度O(n)，空间复杂度O(n)
        Map<Integer, Integer> dupMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dupIndex = dupMap.getOrDefault(nums[i], -1);
            // 如果该元素不存在，则将其放入哈希表中
            if (dupIndex == -1) {
                dupMap.put(nums[i], i);
            }
            // 如果该元素存在，且重复范围在k以内，则返回true
            else if (i-dupIndex <= k) {
                return true;
            }
            // 如果该元素存在，但是超出了范围，则更新该元素在哈希表中的位置
            else {
                dupMap.put(nums[i], i);
            }
        }
        return false;
    }
}
