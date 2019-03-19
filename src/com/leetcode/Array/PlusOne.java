package com.leetcode.Array;

/**
 * Author: Sean
 * Date: Created In 0:03 2019/3/17
 * Title: plusone
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class PlusOne {
    public void plusOne() {
        int[] digits = {9};
        int carry = 1;
        int i = digits.length - 1;
        while (i >= 0) {
            int sum = digits[i] + carry;
            if (sum < 10) {
                carry = 0;
                digits[i] = sum;
                break;
            } else {
                carry = 1;
                digits[i] = sum % 10;
            }
            i--;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            print(res);
        } else {
            print(digits);
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
