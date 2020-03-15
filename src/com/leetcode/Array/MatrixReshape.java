package com.leetcode.Array;

import java.util.Arrays;

/**
 * Author: Sean
 * Date: Created In 22:46 2020/3/15
 * Title: 重塑矩阵
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MatrixReshape {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3}, {4}};
        System.out.println(Arrays.deepToString(matrixReshape(nums, 1, 4)));
    }

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        // 无法重塑矩阵的情况
        int numCount = 0;
        for (int[] num : nums) {
            numCount += num.length;
        }
        if (numCount != r*c) {
            return nums;
        }
        int[][] newMatrix = new int[r][c];
        int rowCount = 0, colCount = 0;
        for (int[] num : nums) {
            for (int i : num) {
                if (colCount >= c) {
                    rowCount++;
                    colCount = 0;
                }
                newMatrix[rowCount][colCount++] = i;
            }
        }
        return newMatrix;
    }
}
