/*
 * Problem: Minimum Size Subarray Sum
 * 
 * Approach:
 * The task is to find the smallest contiguous subarray whose sum is greater than or equal to `target`:
 * - Use a sliding window with two pointers (`left` and `right`).
 * - Expand the window by moving `right` and adding elements to the running sum.
 * - Once the sum becomes greater than or equal to `target`, shrink the window from the left:
 *   - Update the minimum window size (`right - left`) if smaller than the current minimum.
 *   - Subtract the element at `left` from the sum and move `left` forward.
 * - Continue until all elements are processed.
 * - If no valid subarray is found, return 0; otherwise, return the minimum window size.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed at most twice (once by `right`, once by `left`).
 * - Space Complexity: O(1) → Only variables for pointers and sum are used.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minWindow = Integer.MAX_VALUE;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                int currentWindowsize = right - left;
                minWindow = Math.min(minWindow, currentWindowsize);

                sum -= nums[left];
                left++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;

    }
}