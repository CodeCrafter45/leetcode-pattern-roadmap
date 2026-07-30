/*
 * Problem: Is Subsequence
 * 
 * Approach:
 * The solution uses a two-pointer technique to check if `s` is a subsequence of `t`:
 * - Initialize two pointers: `p1` for string `s` and `p2` for string `t`.
 * - Traverse both strings:
 *   - If characters at `p1` and `p2` match, increment both pointers.
 *   - Otherwise, increment only `p2` to continue searching in `t`.
 * - At the end, if `p1` has reached the length of `s`, it means all characters of `s` 
 *   were found in order within `t`, so return true. Otherwise, return false.
 * 
 * Complexity:
 * - Time Complexity: O(m + n) → Each character in both strings is checked at most once.
 * - Space Complexity: O(1) → Only two pointers are used, no extra data structures.
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
      int p1 = 0;
      int p2 = 0;

      while(p1<s.length() && p2<t.length()){
        if(s.charAt(p1)==t.charAt(p2)){
            p1++;
            p2++;

        }
        else{
            p2++;
        }
      }

      return p1 == s.length();

        


     
    }
}