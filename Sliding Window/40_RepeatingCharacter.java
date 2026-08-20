/*
 * Problem: Longest Repeating Character Replacement
 * 
 * Approach:
 * The problem requires finding the length of the longest substring that can be formed 
 * by replacing at most `k` characters so that all characters in the substring are the same:
 * - Use a sliding window with two pointers (`left` and `right`) and a HashMap to track 
 *   the frequency of characters in the current window.
 * - For each character at `right`, update its frequency and track the maximum frequency 
 *   of any character in the window.
 * - If the window size minus the maximum frequency exceeds `k`, shrink the window from the left 
 *   (reduce the frequency of the leaving character).
 * - At each step, update the maximum length of the valid window (`right - left + 1`).
 * - Return the maximum length found.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed once by `right` and at most once by `left`.
 * - Space Complexity: O(26) → The HashMap stores frequencies of at most 26 uppercase letters.
 */


import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int maxFrequency=0;
        int maxLength=0;

        for(int right=0; right<s.length(); right++){

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch,0)+1);

            maxFrequency = Math.max(maxFrequency, map.get(ch));
            while(right-left+1 - maxFrequency>k){
                char leaving = s.charAt(left);
                map.put(leaving, map.get(leaving)-1);
                left++;
            }
                maxLength = Math.max(maxLength, right-left+1);
        }
     return maxLength;

        
    }
}