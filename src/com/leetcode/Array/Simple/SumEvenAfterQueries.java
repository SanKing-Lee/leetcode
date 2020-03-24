package com.leetcode.Array.Simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean
 * Date: Created In 23:06 2019/3/20
 * Title: 插入之后的偶数和
 * Description: We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
 * Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        // 数组偶数之和
        int evenSum = 0;
        // 计算初始状态下的偶数之和
        for (int a : A) {
            if (a % 2 == 0) {
                evenSum += a;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            // 用以保存将要被改变的那个数之前的值
            int preVal = A[queries[i][1]];
            // 如果将要改变之前的那个数是一个偶数，那就把它从偶数和里面减去
            // 如果将要改变之前的那个数是一个奇数，则无需操作，因为它本身对偶数和也没有影响
            // 如果在改变之后仍然为一个偶数，那就把它加回来，否则就不加回来
            if (preVal % 2 == 0) {
                evenSum -= preVal;
            }
            // 如果在改变之后仍然是一个偶数或者从奇数变为了偶数，那就把它加到偶数和之中去
            if((A[queries[i][1]] += queries[i][0])%2 == 0){
                evenSum += A[queries[i][1]];
            };
            // 加入到结果数组中
            res.add(evenSum);
        }
        System.out.println(res.toString());
    }
}
