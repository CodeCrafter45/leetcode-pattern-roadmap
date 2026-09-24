/*
 * Problem: Zigzag Conversion
 * 
 * Approach:
 * The task is to rearrange the characters of a string in a zigzag pattern across
 * a given number of rows and then read the rows sequentially.
 * - Handle edge cases:
 *   - If `numRows <= 1` or the string length is less than or equal to `numRows`,
 *     return the original string.
 * - Compute the zigzag cycle length:
 *   - `increment = 2 * (numRows - 1)`
 * - Traverse row by row:
 *   - For each row, jump through the string using the cycle length.
 *   - Add the vertical characters directly to the result.
 *   - For middle rows (neither first nor last), also calculate and add the
 *     diagonal character within the same cycle using:
 *     `intermediateIndex = j + increment - 2 * i`
 * - Append all selected characters to the result and return the final string.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is visited at most once.
 * - Space Complexity: O(n) → StringBuilder stores the transformed string.
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int increment = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {

            for (int j = i; j < s.length(); j += increment) {
                res.append(s.charAt(j));

                int intermediateIndex = j + increment - 2 * i;
                if (i > 0 && i < numRows - 1 && intermediateIndex < s.length()) {
                    res.append(s.charAt(intermediateIndex));
                }
            }

        }
        return res.toString();
    }
}