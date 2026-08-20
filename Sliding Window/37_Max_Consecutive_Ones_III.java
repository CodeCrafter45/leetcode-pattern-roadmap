/*
 * Problem: Max Consecutive Ones III
 * 
 * Approach:
 * The problem requires finding the longest subarray containing only 1s after flipping 
 * at most `k` zeros:
 * - Use a sliding window with two pointers (`left` and `right`).
 * - Traverse the array with `right`:
 *   - If `nums[right] == 0`, increment the zero count.
 *   - While the zero count exceeds `k`, shrink the window from the left:
 *     - If `nums[left] == 0`, decrement the zero count.
 *     - Move `left` forward.
 * - At each step, calculate the window size (`right - left + 1`) and update the maximum length.
 * - Return the maximum length found.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed at most twice (once by `right`, once by `left`).
 * - Space Complexity: O(1) → Only variables for pointers and counts are used.
 */


class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int maxone=0;
        int zeros=0;

        for(int right=0; right<nums.length; right++){
           if(nums[right]==0){
                zeros++;
           }

           while(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
           }

           maxone = Math.max(maxone,right-left+1);
        }

            return maxone;

      

          

        


        
    }
}