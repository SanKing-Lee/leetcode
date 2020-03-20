package com.leetcode.Array;

/**
 * Author: Sean
 * Date: Created In 23:00 2020/3/20
 * Title: 种花问题
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // method1：遍历数组，查看是否能种下所有的花
        int len = flowerbed.length;
        // 只有一个可以种的位置
        if (len == 1 && flowerbed[0] == 0) {
            n--;
            flowerbed[0] = 1;
            return n <= 0;
        }
        // 第一个位置能否种下
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        // 最后一个位置能否种下
        if (flowerbed[len-1] == 0 && flowerbed[len-2] == 0) {
            n--;
            flowerbed[len-1] = 1;
        }
        // 中间是否有可以种的位置
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}
