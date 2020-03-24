package com.leetcode.Array.Simple;

import java.util.*;

/**
 * Author: Sean
 * Date: Created In 22:47 2020/3/4
 * Title: 第三大的数
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 7, 3, 7, 6};
        System.out.println(Integer.MAX_VALUE);
        thirdMax(nums);
    }

    public static int thirdMax(int[] nums) {
//        // method1：借助优先队列，很慢
//        PriorityQueue<Integer> numQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        for(int num: nums) {
//            if(!numQueue.contains(num)) {
//                numQueue.add(num);
//            }
//        }
//        if(numQueue.size()<3) return numQueue.remove();
//        for (int i = 0; i < 2; i++)
//            numQueue.remove();
//        return numQueue.remove();
        // method2：遍历三次，找到第三大的数
        Integer max = null, secondMax = null, thirdMax = null;
        for(Integer num:nums) {
            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax)) {
                continue;
            }
            if (max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            }
            else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax==null?max:thirdMax;
    }
}
