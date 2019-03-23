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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int row = 0;
        while(row < numRows){
            List<Integer> line = new ArrayList<>();
            int i = 0;
            int j = row+1;
            for(int k = 0; k < j; k++){
                if(k == 0 || k == j-1){
                    line.add(1);
                }
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
