/*
 * Problem: Frequency of Most Frequent Element
 * 
 * Approach:
 * The task is to maximize the frequency of an element by performing at most `k` increment operations:
 * - First, sort the array to ensure elements are in ascending order.
 * - Use a sliding window with two pointers (`left` and `right`) and maintain the running sum of the window.
 * - For each `right`, add `nums[right]` to the sum.
 * - Check if the current window can be converted to all `nums[right]` using at most `k` operations:
 *   - Condition: (nums[right] * window size) - sum ≤ k
 *   - If not satisfied, shrink the window from the left by subtracting `nums[left]` and moving `left` forward.
 * - Update the maximum frequency (`answer`) as the largest valid window size.
 * - Return the maximum frequency found.
 * 
 * Complexity:
 * - Time Complexity: O(n log n) → Sorting dominates the runtime, followed by a linear sliding window.
 * - Space Complexity: O(1) → Only variables for pointers and sum are used.
 */


import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        long sum=0;
        int answer=1;

        for(int right=0; right<nums.length; right++){
            sum+=nums[right];
            while((long)nums[right]*(right-left+1)-sum>k){
                sum-=nums[left];
                left++;
            }

            answer = Math.max(answer,right-left+1);
        }

        return answer;
}
}