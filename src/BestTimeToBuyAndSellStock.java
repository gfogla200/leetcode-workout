

/*
*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*
* */

import java.util.HashMap;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] nums) {

        if (nums.length <= 1)
            return 0;

        int max_profit = 0;
        int d2b = -1;
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] < nums[j]) {

                if (d2b == -1 || nums[d2b] > nums[i]) {

                    int profit = cal_profit(nums, i);
                    if (max_profit < profit){
                        max_profit = profit;
                        d2b = i;
                    }
                }
            }
        }

        return max_profit;

//        int minprice = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minprice)
//                minprice = prices[i];
//            else if (prices[i] - minprice > maxprofit)
//                maxprofit = prices[i] - minprice;
//        }
//        return maxprofit;

    }

    public static int cal_profit(int[] nums, int d2b){
        int profit = 0;
        for(int i = d2b+1; i<nums.length;i++){
            if (profit < (nums[i] - nums[d2b]))
                profit = nums[i] - nums[d2b];
        }
        return profit;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{2,1,2,1,0,1,2};
        System.out.println(maxProfit(arr));
    }
}
