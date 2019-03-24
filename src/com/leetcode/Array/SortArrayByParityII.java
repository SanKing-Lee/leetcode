package com.leetcode.Array;


/**
 * Author: Sean
 * Date: Created in 2019/3/22 22:22
 * Title: 根据奇数偶数排序
 * Description: Given an array A of non-negative integers,
 * half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 * Version: 0.1
 * Update Histroy:
 * [Author][Date][Version] What has been done;
 */

public class SortArrayByParityII {
    public static void main(String[] args){
        int[] A = {4,7,2,5,3,6,8,9};
        int[] res = new int[A.length];
        int index = 0, oddIndex = 0, evenIndex = 1;
        while(index < A.length){
            if(A[index] %2 == 0){
                res[oddIndex] = A[index];
                oddIndex += 2;
            }
            else{
                res[evenIndex] = A[index];
                evenIndex += 2;
            }
            index++;
        }
        for(int a : res){
            System.out.print(a + " ");
        }
    }
}
