/*
 * Problem: Grumpy Bookstore Owner (Max Satisfied Customers)
 * 
 * Approach:
 * The task is to maximize the number of satisfied customers by choosing a window of `minutes`
 * during which the owner can suppress grumpiness:
 * - First, calculate the baseline satisfied customers (those served when `grumpy[i] == 0`).
 * - Then, use a sliding window of size `minutes` to compute the additional customers that 
 *   could be satisfied if the owner suppresses grumpiness in that window.
 * - Initialize the window sum with the first `minutes` elements where `grumpy[i] == 1`.
 * - Slide the window across the array:
 *   - Add the contribution of the new element entering the window if `grumpy[right] == 1`.
 *   - Subtract the contribution of the element leaving the window if `grumpy[left] == 1`.
 *   - Track the maximum possible additional satisfied customers (`max_window`).
 * - The final answer is `baseline satisfied + max_window`.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is processed once in the sliding window.
 * - Space Complexity: O(1) → Only variables for sums and counts are used.
 */

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
       int satisfied = 0;
       int window = 0;
       int max_window=0;
      
       for(int right=0; right<grumpy.length; right++){
        if(grumpy[right]==0){
            satisfied += customers[right];
        }
       }

       for(int right=0; right<minutes; right++){
        if(grumpy[right]==1){
        window+=customers[right];
        }
       }

      max_window = window;

      for(int right=minutes; right<grumpy.length; right++){
        if(grumpy[right]==1){
            window+=customers[right];
        }
        int left  = right - minutes;
        if(grumpy[left]==1){
            window-=customers[left];
        }
        max_window  = Math.max(window, max_window);
      }

             return max_window + satisfied;
    }
}