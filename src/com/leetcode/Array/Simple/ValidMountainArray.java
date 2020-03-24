package com.leetcode.Array.Simple;

/**
 * Author: Sean
 * Date: Created In 23:28 2019/3/20
 * Title: 有效山峰数组
 * Description: Given an array A of integers, return true if and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]     A[i] > A[i+1] > ... > A[B.length - 1]
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ValidMountainArray {
    public static void main(String[] args) {
        int[][] A = {{2, 1}, {3, 5, 5}, {0, 3, 2, 1}};
        for (int[] a : A) {
            System.out.println(a.toString());
            System.out.println(validMountainArray(a));
        }
    }

    public static boolean validMountainArray(int[] A) {
        // 如果长度小于3，那么就直接返回false
        if (A.length < 3) {
            return false;
        }
        // 将山峰初始化为第一个数
        int peak = 0;
        // 遍历数组找到山峰
        for (int i = 1; i < A.length; i++) {
            // 到达了山峰，开始走下坡了
            if (A[peak] > A[i]) {
                break;
            }
            // 找到了两个相等的值，说明不是山峰数组
            else if (A[peak] == A[i]) {
                return false;
            }
            // 如果山峰的值小于下一个，说明还在走上坡
            else if (A[peak] < A[i]) {
                peak = i;
            }
        }
        // 山峰出现在了末尾或者出现在了开头
        if (peak == A.length - 1 || peak == 0) {
            return false;
        }
        int j = peak;
        // 遍历山峰后面的数，如果有大于等于山峰的就返回false
        for (int i = peak + 1; i < A.length; i++) {
            if (A[j] <= A[i]) {
                return false;
            }
            j++;
        }
        return true;
    }
}
