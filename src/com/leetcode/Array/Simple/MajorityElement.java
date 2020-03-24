package com.leetcode.Array.Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Sean
 * Date: Created In 22:07 2020/2/20
 * Title: 找出多数元素
 * Description:给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,2,1,1,1,2,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // method 1：哈希表存储
        // 用于存储每个数字及其对应的出现次数
//        Map<Integer, Integer> mapCount = new HashMap<>();
//        for(int i = 0; i < nums.length; i++) {
        // 更新映射项
//            mapCount.merge(nums[i], 1, Integer::sum);
        // 如果已经达到了多数元素的要求，则返回
//            if(mapCount.getOrDefault(nums[i], 0) > nums.length / 2) {
//                return nums[i];
//            }
//        }
//        return 0;

        // method 2：计数排序的方法，需要考虑的情况太多，包括：负数元素，下标溢出等
//        int maxNum = nums[0], minNum = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            if(nums[i] > maxNum) {
//                maxNum = nums[i];
//            }
//            if(nums[i] < minNum) {
//                minNum = nums[i];
//            }
//        }
////        System.out.println("min: " + minNum + ", max: " + maxNum);
//        int[] count = new int[maxNum-minNum+1];
//        for(int i = 0; i < nums.length; i++) {
//            int index = nums[i]-minNum;
////            System.out.println("index: " + index);
//            count[index]++;
//            if(count[index] > nums.length/2) {
//                return nums[i];
//            }
//        }
//        return 0;

        // method 3：排序，由于多数元素是占据了多于n/2的位置的，所有中间位置的肯定是多数元素
//        Arrays.sort(nums);
//        return (nums[nums.length/2]);
        // method 4：投票算法，维持计数器，抵消非众数和众数
        int count = 0;
        int candidate = -1;
        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }
            count += (num == candidate)?1:-1;
        }
        return candidate;
    }
}
