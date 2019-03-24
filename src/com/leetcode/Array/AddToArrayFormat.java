package com.leetcode.Array;

import sun.security.krb5.internal.tools.Klist;

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
        int[] A = {9,9,9,9,9,0,8,8,8,8,8};
        int K = 181;
        // 结果数组
        LinkedList<Integer> num = new LinkedList<>();
        // 用来记录A的index
        int len = A.length - 1;
        int carry = 0;
        // 获取K的长度
        do {
            // 如果a的下标小于了0，说明a数组遍历完了，更前面的数就变成了0
            int a = (len >= 0) ? A[len]:0;
            // 如果b不够长，那么它就会变成0，0对10取模还是0
            int b = K%10;
            // 获得每位相加之后的和
            int sum = a+b+carry;
            // 如果相加大于10，将进位设置为1
            if(sum >= 10){
                carry = 1;
                num.addFirst(sum%10);
            }
            // 否则将进位设置为0
            else{
                carry = 0;
                num.addFirst(sum);
            }
            // 更新len和k
            len--;
            K/=10;
        } while (len >= 0 || K != 0);
        // 如果两个数都被遍历完了，carry仍然等于1，说明它们产生了最高位的进位
        // 在结果前面加上一个1
        if(carry == 1){
            num.addFirst(1);
        }
        for(int a :num){
            System.out.print(a + " ");
        }
    }
}
