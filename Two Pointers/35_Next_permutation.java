/*
 * Problem: Next Permutation
 * 
 * Approach:
 * The task is to rearrange numbers into the lexicographically next greater permutation:
 * - Traverse from right to left to find the first index (`pivotIndex`) where `nums[i] < nums[i+1]`. 
 *   This identifies the pivot where the order can be increased.
 * - If no such pivot exists (array is in descending order), simply reverse the entire array 
 *   to get the smallest permutation.
 * - Otherwise, find the smallest element greater than `nums[pivotIndex]` to the right, 
 *   and swap them.
 * - Finally, reverse the subarray to the right of `pivotIndex` to ensure it is in ascending order, 
 *   giving the next permutation.
 * 
 * Complexity:
 * - Time Complexity: O(n) → One pass to find the pivot, one pass to swap, and one pass to reverse.
 * - Space Complexity: O(1) → In-place rearrangement using only a few variables.
 */

class Solution {
    public void nextPermutation(int[] nums) {
       int pivotIndex= -1;
       for(int i=nums.length-2; i>=0; i--){
         if(nums[i]<nums[i+1]){
            pivotIndex = i;
            break;
         }
       }

       if(pivotIndex==-1){
        int left= 0;
        int right = nums.length-1;
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
            return;
       }

       for(int i=nums.length-1; i>pivotIndex; i--){
            if(nums[i]>nums[pivotIndex]){
            int temp = nums[i];
            nums[i] = nums[pivotIndex];
            nums[pivotIndex] = temp;
            break;
            }
       }

       int left = pivotIndex +1;
       int right = nums.length-1;
       while(left<right){
         int temp = nums[left];
         nums[left] = nums[right];
         nums[right] = temp;
         left++;
         right--;
       }
        
        
             
   

        
       


    }

}
