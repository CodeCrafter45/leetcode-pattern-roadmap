/*
 * Problem: Maximum Average Subarray I
 * 
 * Approach:
 * The problem requires finding the contiguous subarray of length `k` with the maximum average:
 * - Use a sliding window of fixed size `k`.
 * - First, compute the sum of the initial `k` elements and calculate the average.
 * - Store this as the current maximum average.
 * - Then, slide the window across the array:
 *   - Subtract the element leaving the window (`nums[i-k]`) and add the new element entering (`nums[i]`).
 *   - Update the sum and compute the new average.
 *   - Compare with the current maximum average and update if larger.
 * - Return the maximum average found.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed once in the sliding window.
 * - Space Complexity: O(1) → Only variables for sum and averages are used.
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
       double avg = 0;
       double sum=0;
       for(int i=0; i<k; i++){
        sum += nums[i];
       }

       avg = sum/k;
       double maxAvg =avg;
       maxAvg = Math.max(maxAvg,avg);

       for(int i=k; i<nums.length; i++){
        sum = sum - nums[i-k] + nums[i];
        avg = sum/k;
        maxAvg = Math.max(maxAvg,avg);
       }

        return maxAvg;

      
    }
}