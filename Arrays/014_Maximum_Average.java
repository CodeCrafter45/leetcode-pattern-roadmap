/*
 * Problem: Maximum Average Subarray I
 * * Approach:
 * Solved using the Sliding Window technique. We first compute the sum of the initial 
 * window of size `k`. We then slide the window across the array from index `k` to the end. 
 * At each step, the window's sum is updated in O(1) time by subtracting the element that 
 * left the window (`nums[i - k]`) and adding the new element that entered it (`nums[i]`). 
 * A running maximum average (`maxAvg`) is maintained throughout the process.
 * * Complexity:
 * - Time Complexity: O(n) - Single linear scan across the array.
 * - Space Complexity: O(1) - Constant auxiliary space utilized.
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {

        
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

      
        for (int i = k; i < nums.length; i++) {

           
            sum = sum - nums[i - k] + nums[i];

            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }
}