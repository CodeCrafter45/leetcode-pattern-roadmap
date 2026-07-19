/*
 * Problem: Product of Array Except Self
 * 
 * Approach:
 * The solution avoids division and computes the product of all elements except self 
 * using prefix and suffix products in two passes:
 * - First pass (Left products): Build an array `answer` where each index stores the 
 *   product of all elements to its left. Initialize `answer[0] = 1` since there are 
 *   no elements before index 0.
 * - Second pass (Right products): Traverse from the end while maintaining a running 
 *   product (`right`) of elements to the right. Multiply each `answer[i]` by `right` 
 *   to incorporate the right-side product, then update `right` by multiplying with 
 *   `nums[i]`.
 * - This way, each position in `answer` contains the product of all elements except itself.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Two linear passes through the array.
 * - Space Complexity: O(1) → Output array does not count as extra space; only a few 
 *   auxiliary variables are used.
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n= nums.length;
      int answer[] = new int[n];
     

      answer[0]= 1;
      for(int i=1; i<n; i++){
        answer[i]= answer[i-1] * nums[i-1];

      }

      int right=1;

      for(int i=n-1; i>=0; i--){
        answer[i]= answer[i] * right;
        right *= nums[i];
      }

        return answer;

    }
}
