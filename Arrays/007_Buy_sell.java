/*
 * Problem: Best Time to Buy and Sell Stock
 * * Personal Note: 
 * This one was a bit tricky at first! I had to look at the solution and break it down 
 * line by line to fully grasp it. Realized it's a fundamental Dynamic Programming / Greedy problem.
 * * Logic:
 * Track the lowest buying price seen so far, and calculate the maximum profit 
 * possible by selling at the current day's price.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int mini= prices[0];
        int profit=0;

        for(int i=1; i<prices.length; i++){
            int cost= prices[i]- mini;
            profit= Math.max(profit,cost);
            mini = Math.min(prices[i],mini);
        }
    return profit;
    }
}