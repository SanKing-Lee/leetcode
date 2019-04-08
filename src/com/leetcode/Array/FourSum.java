package com.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 23:19 2019/4/8
 * Title: 数组中四个数之和为目标值
 * Description: Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        fourSum(nums, target);
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // one fixed number;
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            // 3Sum problem
            for (int j = i + 1; j < nums.length; j++) {
                int newTarget = target - currValue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[j] == newTarget) {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[left]);
                        tuple.add(nums[right]);
                        if (!res.contains(tuple)) {
                            res.add(tuple);
                        }
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[j] < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return res;
    }
}
