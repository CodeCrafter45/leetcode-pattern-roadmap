/*
 * Problem: Longest Substring Without Repeating Characters
 * 
 * Approach:
 * The problem requires finding the length of the longest substring without duplicate characters:
 * - Use a sliding window with two pointers (`left` and `right`) and a HashSet to track characters.
 * - Traverse the string with `right`:
 *   - If the current character already exists in the set, shrink the window from the left 
 *     until the duplicate is removed.
 *   - Add the current character to the set.
 *   - Update the maximum length as the size of the current window (`right - left + 1`).
 * - Continue until the entire string is processed.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is added and removed from the set at most once.
 * - Space Complexity: O(min(n, a)) → The HashSet stores at most one entry per unique character, 
 *   where `a` is the alphabet size.
 */


import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max=0;
        int left=0;

        for(int right=0; right<s.length(); right++){
             while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
             }
                set.add(s.charAt(right));
                max = Math.max(max,right-left+1);
        }

            return max;

    }
}