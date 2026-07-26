/*
 * Problem: Valid Palindrome
 * 
 * Approach:
 * The solution uses a two-pointer technique to check if the string is a palindrome 
 * while ignoring non-alphanumeric characters and case differences:
 * - Convert the string to lowercase for uniform comparison.
 * - Initialize two pointers: `left` at the start and `right` at the end.
 * - Move the pointers inward:
 *   - Skip characters that are not letters or digits using `Character.isLetterOrDigit`.
 *   - Compare the characters at `left` and `right`. If they differ, return false.
 *   - If they match, move both pointers closer to the center.
 * - If all valid characters match, return true.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is checked at most once.
 * - Space Complexity: O(1) → Only pointers are used, no extra data structures.
 */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;

            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;

    }
}