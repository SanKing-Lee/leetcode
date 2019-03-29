package com.leetcode.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 23:45 2019/3/24
 * Title: 杨辉三角II
 * Description: Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class PascalTriangleII {
    public static void main(String[] args) {
        int rowIndex = 4;
        int[] pascal = new int[rowIndex+1];
        int i = 0;
        pascal[0] = 1;
        while(i <= rowIndex){
            pascal[i] = 1;
            for(int j = i - 1; j > 0; j--){
                pascal[j]+=pascal[j-1];
            }
            i++;
        }
        for (int p : pascal) {
            System.out.print(p + " ");
        }
    }
}
