/*
 * Problem: Longest Palindromic Substring
 * 
 * Approach:
 * The task is to find the longest substring in `s` that is a palindrome:
 * - Use a brute-force approach by checking all possible substrings.
 * - For each pair of indices `(i, j)`:
 *   - If the substring length `(j - i + 1)` is greater than the current longest palindrome,
 *     call the helper method `isPalindrome` to check if `s[i..j]` is a palindrome.
 *   - If true, update the longest palindrome substring.
 * - The helper method `isPalindrome` compares characters from both ends (`left` and `right`)
 *   moving inward until either a mismatch is found or the substring is confirmed as a palindrome.
 * - Return the longest palindrome found.
 * 
 * Complexity:
 * - Time Complexity: O(n³) → O(n²) substrings are generated, and each palindrome check takes O(n).
 * - Space Complexity: O(1) → Only variables for indices and substring tracking are used.
 */

class Solution {
    public String longestPalindrome(String s) {
        if(s==null  || s.length()<1) return "";

        String maxPalindrome= "";
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){

                if(j-i+1>maxPalindrome.length()){
                    if(isPalindrome(s,i,j)){
                        maxPalindrome= s.substring(i,j+1);
                    }
                }
            }
        }
       return maxPalindrome;
    }
     


private boolean isPalindrome(String s, int left, int right){
    while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            return false;
        }

        left++;
        right--;
    }

    return true;
}
}

