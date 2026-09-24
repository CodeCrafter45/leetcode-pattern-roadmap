/*
 * Problem: Integer to Roman
 * 
 * Approach:
 * The solution uses a greedy strategy to construct the Roman numeral representation:
 * - Store all Roman numeral values in descending order along with their corresponding symbols.
 * - Traverse the values array from largest to smallest.
 * - While the current value can be subtracted from `num`:
 *   - Subtract the value from `num`.
 *   - Append the corresponding Roman symbol to the result.
 * - Continue until `num` becomes 0.
 * - The inclusion of special cases such as 900 (CM), 400 (CD), 90 (XC), 40 (XL),
 *   9 (IX), and 4 (IV) ensures the Roman numeral rules are followed correctly.
 * 
 * Complexity:
 * - Time Complexity: O(1) → The number of Roman symbols is fixed, so the operations are bounded.
 * - Space Complexity: O(1) → Only a StringBuilder and fixed-size arrays are used.
 */
class Solution {
    public String intToRoman(int num) {
        int values[] = { 1000, 900, 500, 400,
                100, 90, 50, 40, 10,
                9, 5, 4, 1 };

        String[] symbols = { "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                ans.append(symbols[i]);
            }
        }

        return ans.toString();
    }
}