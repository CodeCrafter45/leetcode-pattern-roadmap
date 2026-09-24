
/*
 * Problem: Longest Palindrome
 * 
 * Approach:
 * The task is to determine the maximum length of a palindrome that can be built
 * using the characters of the given string.
 * - Use a HashMap to count the frequency of each character.
 * - For every character frequency:
 *   - Add the largest even contribution to the palindrome length
 *     using `frequency - (frequency % 2)`.
 *   - If a character has an odd frequency, mark that an odd-count
 *     character exists.
 * - After processing all frequencies:
 *   - If at least one character has an odd frequency, place one such
 *     character in the center of the palindrome and add 1 to the length.
 * - Return the maximum possible palindrome length.
 * 
 * Complexity:
 * - Time Complexity: O(n) → One pass to count characters and one pass to process frequencies.
 * - Space Complexity: O(n) → HashMap stores the frequency of unique characters.
 */
import java.util.HashMap;

class Solution {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int length = 0;

        boolean hasOdd = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character key : map.keySet()) {
            int frequency = map.get(key);

            length += frequency - (frequency % 2);

            if (frequency % 2 != 0) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            return length + 1;
        } else {
            return length;
        }

    }

}
