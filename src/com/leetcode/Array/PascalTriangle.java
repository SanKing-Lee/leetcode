package com.leetcode.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sean
 * Date: Created in 2019/3/22 22:42
 * Title: 杨辉三角
 * Description: 用二维list存储杨辉三角，根据输入确定行数
 * Version: 0.1
 * Update Histroy:
 * [Author][Date][Version] What has been done;
 */

public class PascalTriangle {
    public static void main(String[] args){
        int numRows = 10;
        // 用来存储结果的list
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int row = 0;
        // 根据每一行的情况进行不同的处理
        while(row < numRows){
            // 存储每一行的数组
            List<Integer> line = new ArrayList<>();
            // 存储每一行数组的开头的index和结尾的index，因为每一行的开头和结尾都是1
            int i = 0;
            int j = row+1;
            // 对每一行的数组进行遍历
            for(int k = 0; k < j; k++){
                // 如果当前处于开头或结尾，就把1加入的这个位置
                // 第一行和第二行只有这种情况，因为它们只有开头和结尾
                if(k == 0 || k == j-1){
                    line.add(1);
                }
                // 如果不是处于开头或者结尾，则需要根据上一行数组相应的值来确定
                else{
                    line.add(res.get(row-1).get(k-1) + res.get(row-1).get(k));
                }
            }
            res.add(line);
            row++;
        }
        for(List<Integer> line:res){
            for(int a:line){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
