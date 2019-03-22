package com.leetcode.Array;


import java.util.*;

/**
 * Author: Sean
 * Date: Created In 23:46 2019/3/20
 * Title: 将一个数组代表的数与另一个数相加，将结果以数组的形式表示
 * Description: For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class AddToArrayFormat {
    public static void main(String[] args) {
        int[] A = {1};
        int K = 181;
        // 用来暂时存储K的各位数
        LinkedList<Integer> num = new LinkedList<>();
        // 存储K的长度
        int KLength = 0;
        // 获取K的长度
        do {
            num.addFirst(K % 10);
            K /= 10;
            KLength++;
        } while (KLength < A.length || K != 0);
        // 将A数组和K数组相加
        int carry = 0;
        int resIndex = A.length-1;
        ListIterator<Integer> iter = num.listIterator(KLength);
        while (iter.hasPrevious()) {
            int a = (resIndex >= 0)?A[resIndex]:0;
            int b = iter.previous();
            int sum = a + b + carry;
            if (sum >= 10) {
                carry = 1;
                iter.set(sum % 10);
            } else {
                carry = 0;
                iter.set(sum);
            }
            resIndex--;
        }
        if (carry == 1) {
            num.addFirst(1);
        }
        for (int n : num) {
            System.out.print(n + " ");
        }
    }
}
