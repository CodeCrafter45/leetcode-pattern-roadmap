
/*
 * Problem: Longest Common Prefix
 * 
 * Approach:
 * The task is to find the longest common prefix among all strings in the array:
 * - Sort the array of strings lexicographically.
 * - After sorting, the common prefix of the entire array must be the common prefix 
 *   of the first and last strings (since they are the most different).
 * - Compare characters of the first (`s1`) and last (`s2`) strings one by one:
 *   - Increment index while characters match.
 *   - Stop when a mismatch occurs or the end of either string is reached.
 * - Return the substring from the first string up to the matched index.
 * 
 * Complexity:
 * - Time Complexity: O(n log n + m) → Sorting takes O(n log n), and comparing 
 *   the first and last strings takes O(m), where `m` is the length of the shortest string.
 * - Space Complexity: O(1) → Only variables for indices and substrings are used.
 */

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
       Arrays.sort(strs);
       String s1= strs[0];
       String s2=strs[strs.length-1];
       int ind=0;
       while(ind<s1.length() && ind<s2.length()){
        if(s1.charAt(ind)==s2.charAt(ind)){
        ind++;
       }
       else{
        break;
       }
       }
       return s1.substring(0,ind);
}
}
