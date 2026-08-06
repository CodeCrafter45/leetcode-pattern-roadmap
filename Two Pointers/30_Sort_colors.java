/*
 * Problem: Sort Colors
 * 
 * Approach:
 * This problem is a variation of the Dutch National Flag algorithm:
 * - Use three pointers: `left` for the boundary of 0s, `right` for the boundary of 2s, 
 *   and `mid` to traverse the array.
 * - Traverse while `mid <= right`:
 *   - If `nums[mid] == 0`, swap with `nums[left]`, then increment both `left` and `mid`.
 *   - If `nums[mid] == 1`, simply move `mid` forward.
 *   - If `nums[mid] == 2`, swap with `nums[right]`, then decrement `right` (without incrementing `mid`).
 * - This ensures all 0s are moved to the left, 2s to the right, and 1s remain in the middle.
 * - The algorithm sorts the array in-place without using extra memory.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed at most once.
 * - Space Complexity: O(1) → Sorting is done in-place using only pointers.
 */

class Solution {
    public void sortColors(int[] nums) {
     
            int left=0;
            int right = nums.length-1;
            int mid=0;

            while(mid<=right){
                if(nums[mid]==0){
                    int temp = nums[mid];
                    nums[mid] = nums[left];
                    nums[left] = temp;
                    left++;
                    mid++;
                }
                else if(nums[mid]==1){
                    mid++;
                }
                else if(nums[mid]==2){
                    int temp2 = nums[mid];
                    nums[mid] = nums[right];
                    nums[right] = temp2;
                    right--;
                }

            }
      
   
       }
       }
       
       

       

    

       
        
    
