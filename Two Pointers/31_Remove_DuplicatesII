/*
 * Problem: Remove Duplicates from Sorted Array II
 * 
 * Approach:
 * The problem requires modifying the sorted array in-place so that each element 
 * appears at most twice:
 * - Use a pointer `write` to track the position where the next valid element should be placed.
 * - Start from index 2 (since the first two elements are always allowed).
 * - For each element at index `i`, compare it with the element at `write - 2`.
 *   - If they are different, it means the current element can be included.
 *   - Place it at `nums[write]` and increment `write`.
 * - At the end, `write` represents the new length of the array with duplicates removed.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is checked once.
 * - Space Complexity: O(1) → In-place modification using only one pointer.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
      int write=2;
      for(int i=2; i<nums.length; i++){
        if(nums[i]!=nums[write-2]){
            nums[write] = nums[i];
            write++;
        }
      }

        return write;

       
    }
}