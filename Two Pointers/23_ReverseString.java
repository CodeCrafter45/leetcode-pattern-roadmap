/*
 * Problem: Reverse a String
 * 
 * Approach:
 * The solution uses a two-pointer technique to reverse the string in-place:
 * - Initialize `left` at the start and `right` at the end of the character array.
 * - Swap the characters at `left` and `right`.
 * - Increment `left` and decrement `right` to move inward.
 * - Continue until the pointers meet or cross, ensuring all characters are reversed.
 * - This avoids extra memory usage since the reversal happens directly on the input array.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is swapped once.
 * - Space Complexity: O(1) → In-place reversal using only temporary variables.
 */

class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int right= s.length-1;

        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}