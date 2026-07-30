/*
 * Problem: Move Zeroes
 * 
 * Approach:
 * The solution rearranges the array so that all non-zero elements appear first, 
 * followed by zeros, while preserving the relative order of non-zero elements:
 * - Use a pointer `right` to track the position where the next non-zero element 
 *   should be placed.
 * - Traverse the array, and whenever a non-zero element is found, place it at 
 *   `nums[right]` and increment `right`.
 * - After processing all elements, fill the remaining positions from `right` 
 *   to the end of the array with zeros.
 * - This avoids unnecessary swaps and ensures in-place modification.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Single pass through the array plus filling zeros.
 * - Space Complexity: O(1) → In-place rearrangement using only one pointer.
 */

class Solution {
    public void moveZeroes(int[] nums) {
         int right=0;
         for(int i=0; i<nums.length; i++)   {
            if(nums[i]!=0){
                nums[right]= nums[i];
                right++;
            }
         }

         while(right<nums.length){
            nums[right]=0;
            right++;
         }

         
    }
}
    
