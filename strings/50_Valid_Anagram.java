/*
 * Problem: Valid Anagram
 * 
 * Approach:
 * The task is to check if two strings `s` and `t` are anagrams (contain the same characters with the same frequency):
 * - First, check if the lengths of `s` and `t` are different. If so, return false immediately.
 * - Use an integer array `count[26]` to track character frequencies (assuming lowercase English letters).
 * - Traverse both strings simultaneously:
 *   - Increment the count for each character in `s`.
 *   - Decrement the count for each character in `t`.
 * - After traversal, if all values in `count` are zero, the strings are anagrams; otherwise, return false.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character in both strings is processed once.
 * - Space Complexity: O(1) → Fixed-size array of 26 for character counts.
 */  

class Solution {
    public boolean isAnagram(String s, String t) {
      
      if(s.length()!=t.length()){
        return false;
      }
      int count[] = new int[26];

      for(int i=0; i<s.length(); i++){
        count[s.charAt(i)-'a']++;
        count[t.charAt(i)-'a']--;
      }

      for(int n : count){
        if(n!=0){
            return false;
        }
      }

      return true;
        
    }
}
