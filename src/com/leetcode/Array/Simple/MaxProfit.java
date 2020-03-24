package com.leetcode.Array.Simple;

/**
 * Author: Sean
 * Date: Created In 0:19 2019/3/30
 * Title: 购买和出售货物的最好时机
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class MaxProfit {
    public static void main(String[] args){
        int[] prices = {2,1,4};
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]);
            int p = prices[i] - minPrice;
            maxProfit = Math.max(p, maxProfit);
        }
        System.out.println(maxProfit);
    }
}
