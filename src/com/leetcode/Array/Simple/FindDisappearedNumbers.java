package com.leetcode.Array.Simple;

import java.util.*;

/**
 * Author: Sean
 * Date: Created In 22:50 2020/3/6
 * Title: 找到所有消失的数字
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,7,3,2,1};
        System.out.println(findDisappeardNumbers(nums).toString());
    }

    public static List<Integer> findDisappeardNumbers(int[] nums) {
        // method1：哈希表
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> missingNumbers = new LinkedList<>();
//        for (int num: nums) {
//            map.putIfAbsent(num, 1);
//        }
//        for(int i = 1; i < nums.length + 1; i++) {
//            if(map.getOrDefault(i, 0) == 0) {
//                missingNumbers.add(i);
//            }
//        }
//        return missingNumbers;
        // method2：排序法
//        Arrays.sort(nums);
//        List<Integer> missingNumbers = new LinkedList<>();
//        int dueNum = 1, i = 0;
//        while (i < nums.length) {
//            // 当前数字缺失
//            if (dueNum < nums[i]) {
//                missingNumbers.add(dueNum++);
//            }
//            // 当前数字存在
//            if (dueNum == nums[i]) {
//                // 数字重复了
//                while (i < nums.length && dueNum == nums[i]) {
//                    i++;
//                }
//                dueNum++;
//            }
//        }
//        // 末尾数字缺失
//        while (dueNum <= nums.length) {
//            missingNumbers.add(dueNum++);
//        }
//        return missingNumbers;
//        // method3：利用返回的数组进行去重、添加缺失数字
//        // 期望和
//        List<Integer> missingNumbers = new LinkedList<>();
//        // 去重
//        for (int num: nums) {
//            if (!missingNumbers.contains(num)) {
//                missingNumbers.add(num);
//            }
//        }
//        int removeIndex = missingNumbers.size();
//        // 添加缺失的数字
//        for (int i = 1; i < nums.length + 1; i++) {
//            if (!missingNumbers.contains(i)) {
//                missingNumbers.add(i);
//            }
//        }
//        // 移除原有的数字
//        missingNumbers.subList(0, removeIndex).clear();
//        return missingNumbers;
        // method4：将存在数字对应的索引上的数字标为负值
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i]<0?-nums[i]:nums[i];
            index--;
            nums[index] = nums[index]<0?nums[index]:-nums[index];
        }
        List<Integer> disappearedNumbers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappearedNumbers.add(i+1);
            }
        }
        return disappearedNumbers;
    }
}
