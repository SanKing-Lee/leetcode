package com.leetcode.Array.Simple;

import javax.management.loading.MLet;

/**
 * Author: Sean
 * Date: Created In 23:10 2020/7/7
 * Title: 图片平滑器
 * Description: 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/image-smoother 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ImageSmoother {
    public static void main(String[] args) {
        int[][] test = {{2,3,4}, {5,6,7}, {8,9,10}, {11,12,13},{14,15,16}};
        int[][] result = imageSmoother(test);
        for (int[] row: result) {
            for (int num: row) {
                System.out.print(num+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] imageSmoother(int[][] M) {
        // method1:暴力求解，遍历每个像素点周围的像素，如果不存在就跳过
        // 遍历行
        int[][] result=new int[M.length][];
        for (int i = 0; i < M.length; i++) {
            // 遍历列
            result[i] = new int[M[i].length];
            for (int j = 0; j < M[i].length; j++) {
                // 求周围像素的和
                int sum = 0;
                // 周围有多少个像素
                int count = 0;
                // 行偏移量
                for (int x = -1; x <= 1; x++) {
                    // 列偏移量
                    for (int y = -1; y <= 1; y++) {
                        // 行坐标
                        int a = i+x;
                        // 列坐标
                        int b = j+y;
                        if (a >= 0 && a < M.length && b >= 0 && b < M[i].length) {
                            sum += M[a][b];
                            count++;
                        }
                    }
                }
                result[i][j] = (int)(Math.floor(((double)sum/count)));
            }
        }
        return result;
    }
}
