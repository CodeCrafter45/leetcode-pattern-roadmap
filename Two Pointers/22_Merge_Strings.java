/*
 * Problem: Merge Strings Alternately
 * 
 * Approach:
 * The solution uses a two-pointer technique to merge two strings alternately:
 * - Initialize two pointers `p1` and `p2` for `word1` and `word2`, and an index `k` 
 *   for the merged character array.
 * - Traverse both strings simultaneously, appending one character from each in turn.
 * - If one string is longer, append the remaining characters after the other string 
 *   is exhausted.
 * - Finally, convert the merged character array back into a string and return it.
 * 
 * Complexity:
 * - Time Complexity: O(m + n) → Each character from both strings is processed once.
 * - Space Complexity: O(m + n) → A new character array is created to store the merged result.
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {

        char mergeString[] = new char[word1.length()+word2.length()];
        int p1 = 0;
        int p2 = 0;
        int k=0;

        while(p1<word1.length() && p2<word2.length()){
            mergeString[k] = word1.charAt(p1);
            p1++;
            k++;
            mergeString[k] = word2.charAt(p2);
            p2++;
            k++;
        }

        while(p1<word1.length()){
            mergeString[k] = word1.charAt(p1);
            p1++;
            k++;
        }
        while(p2<word2.length()){
            mergeString[k] = word2.charAt(p2);
            p2++;
            k++;
        }
         
       
        word1 = new String(mergeString);
        return word1;
       

         
        

    }
}