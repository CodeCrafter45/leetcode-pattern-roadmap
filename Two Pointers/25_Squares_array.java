/*
 * Problem: Squares of a Sorted Array
 * 
 * Approach:
 * The solution uses a two-pointer technique to build the result in sorted order:
 * - Initialize `left` at the start and `right` at the end of the array, with `k` pointing 
 *   to the last index of the result array.
 * - Compare the squares of `nums[left]` and `nums[right]`.
 * - Place the larger square at position `k` in the result array, then move the corresponding 
 *   pointer inward and decrement `k`.
 * - Continue until all elements are processed.
 * - This works because the largest square must come from either end of the array.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed once.
 * - Space Complexity: O(n) → A new array is created to store the squared values in sorted order.
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
       int nums2[]= new int[nums.length];
       int left=0;
       int right=nums.length-1;
       int k=nums.length-1;

       while(left<=right){
        if(nums[left]*nums[left] > nums[right]*nums[right]){
            nums2[k] = nums[left]*nums[left];
            k--;
            left++;
        }
        else{
            nums2[k] = nums[right]*nums[right];
            k--;
            right--;
        }
       }

       return nums2;

    
        

        
    }
}