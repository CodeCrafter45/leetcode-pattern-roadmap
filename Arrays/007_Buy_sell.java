/*
 * Problem: Best Time to Buy and Sell Stock
 * * Approach: 
 * This is a classic Dynamic Programming / Greedy approach (Kadane's-like logic).
 * Instead of checking every pair of days, we maintain the minimum price seen so far (`mini`) 
 * and calculate the potential profit if we sell on the current day (`prices[i]`).
 * We track the maximum profit encountered throughout the loop.
 * * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant space used.
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