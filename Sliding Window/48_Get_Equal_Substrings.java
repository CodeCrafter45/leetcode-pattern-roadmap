/*
 * Problem: Equal Substring Within Budget
 * 
 * Approach:
 * The task is to find the longest substring where the cost of converting `s` into `t` 
 * does not exceed `maxCost`:
 * - Use a sliding window with two pointers (`left` and `right`) to track the current substring.
 * - For each character at `right`, calculate the cost of converting `s[right]` to `t[right]` 
 *   using `Math.abs(s.charAt(right) - t.charAt(right))` and add it to the running cost.
 * - If the cost exceeds `maxCost`, shrink the window from the left:
 *   - Subtract the cost of converting `s[left]` to `t[left]`.
 *   - Move `left` forward until the total cost is within the budget.
 * - At each step, update the maximum length of the valid window (`right - left + 1`).
 * - Return the maximum length found.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed at most twice (once by `right`, once by `left`).
 * - Space Complexity: O(1) → Only variables for pointers and cost are used.
 */

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int cost=0;
        int maxlen=0;
        for(int right=0; right<s.length(); right++){
              cost+=Math.abs(s.charAt(right)-t.charAt(right));

             while(cost>maxCost){
                cost-= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
             }
             maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;
    }
}