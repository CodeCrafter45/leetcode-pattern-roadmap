/*
 * Problem: Detect Capital Use
 * 
 * Approach:
 * The task is to check if a word uses capital letters correctly:
 * - Valid cases are:
 *   1. All letters are uppercase (e.g., "USA").
 *   2. All letters are lowercase (e.g., "leetcode").
 *   3. Only the first letter is uppercase and the rest are lowercase (e.g., "Google").
 * - Use built-in string methods:
 *   - `toUpperCase()` to check if the word is fully uppercase.
 *   - `toLowerCase()` to check if the word is fully lowercase.
 *   - `substring(1).toLowerCase()` to check if all characters except the first are lowercase.
 * - Return true if any of these conditions are satisfied; otherwise, return false.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed once in the string comparisons.
 * - Space Complexity: O(1) → Only constant extra space is used.
 */


class Solution {
    public boolean detectCapitalUse(String word) {
        
        if(word.equals(word.toUpperCase())){
            return true;
        }
        else if(word.equals(word.toLowerCase())){
            return true;
        }
        else if(word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }
        else{
            return false;
        }
    }
}