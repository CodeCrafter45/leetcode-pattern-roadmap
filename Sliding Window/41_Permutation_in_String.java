/*
 * Problem: Permutation in String
 * 
 * Approach:
 * The problem requires checking if `s2` contains a substring that is a permutation of `s1`:
 * - Use two frequency arrays of size 26 (for lowercase letters):
 *   - `freq` stores the frequency of characters in `s1`.
 *   - `freqWindow` stores the frequency of characters in the current window of `s2` of length `k = s1.length()`.
 * - First, initialize both arrays for the initial window of `s2`.
 * - Compare the two frequency arrays:
 *   - If they match, return true (a permutation exists).
 * - Slide the window across `s2`:
 *   - Decrement the frequency of the character leaving the window.
 *   - Increment the frequency of the character entering the window.
 *   - Compare arrays again; if they match, return true.
 * - If no match is found after sliding through the entire string, return false.
 * 
 * Complexity:
 * - Time Complexity: O(n * 26) → Each window comparison takes O(26), and there are O(n) windows.
 *   This simplifies to O(n) since 26 is constant.
 * - Space Complexity: O(26) → Two fixed-size frequency arrays are used.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int [] freq = new int[26];
       int [] freqWindow = new int[26];
       int k = s1.length();
       if(s1.length() > s2.length()){
        return false;
}
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
        }

        for(int i=0; i<k; i++){
            freqWindow[s2.charAt(i)-'a']++;
        }
            boolean match=true;
        for(int i=0; i<26; i++){
            if(freq[i] != freqWindow[i]){
                match = false;
                break;
            }
        }
        if(match){
            return true;
        }

        for(int i=k; i<s2.length(); i++){
             freqWindow[s2.charAt(i-k)-'a']--;
             freqWindow[s2.charAt(i)-'a']++;
             match =true;
             for(int j=0; j<26; j++){
            if(freq[j] != freqWindow[j]){
                match = false;
                break;
            }
        }

          if(match){
            return true;
        }
 
            }
        
        
        

        return false;
        
       

      
    }
}