/*
 * Problem: Rotate Array
 * 
 * Approach:
 * The optimized solution uses the reversal technique instead of extra space:
 * - First, reverse the entire array. This brings the last `k` elements to the front, 
 *   but in reversed order.
 * - Next, reverse the first `k` elements to restore their correct relative order.
 * - Finally, reverse the remaining `n - k` elements to restore their correct order.
 * - This sequence of reversals achieves the desired rotation in-place without 
 *   additional arrays.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each reversal is linear, and we perform three reversals.
 * - Space Complexity: O(1) → In-place modification using only a few auxiliary variables.
 */

class Solution {
    public void rotate(int[] nums, int k) {
       int n= nums.length;
       k= k%n;

       Reverse(nums,0,n-1);
       Reverse(nums,0,k-1);
       Reverse(nums,k,n-1);
    }

    private void Reverse(int nums[], int left, int right){
        while(left<right){
            int temp= nums[left];
            nums[left]= nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
