/*
 * Problem: Reverse Words in a String
 * 
 * Approach:
 * The task is to reverse the order of words in a given string while removing extra spaces:
 * - Start from the end of the string and skip trailing spaces.
 * - Identify each word by finding its boundaries (`end` to `i`).
 * - Append the word to a `StringBuilder`, adding a space if it’s not the first word.
 * - Continue moving left until all words are processed.
 * - Return the constructed string, which contains words in reverse order with single spaces.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is visited once while scanning and appending.
 * - Space Complexity: O(n) → The `StringBuilder` stores the reversed string.
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;

        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            if(i<0){
                break;
            }
             int end=i;
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
           

            if(sb.length()>0){
                sb.append(" ");
            }

            for(int j=i+1; j<=end; j++){
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }
}