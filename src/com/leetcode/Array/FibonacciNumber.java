package com.leetcode.Array;

/**
 * Author: sean
 * Date: Created In 23:17 2019/3/24
 * Title: Fibonacci序列
 * Description: The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * That is,  F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 4;
        int a = 0, b = 1;
        switch(n){
            case 0: break;
            case 1: a = b; break;
            default:{
                int i = 2;
                while(i <= n){
                    int temp = b;
                    b = a+b;
                    a = temp;
                    i++;
                }
            }
        }
        System.out.println(b);
    }
}
