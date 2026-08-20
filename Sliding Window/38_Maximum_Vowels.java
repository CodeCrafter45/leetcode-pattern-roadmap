/*
 * Problem: Maximum Number of Vowels in a Substring of Given Length
 * 
 * Approach:
 * The problem requires finding the maximum number of vowels in any substring of length `k`:
 * - Use a sliding window of size `k`.
 * - First, count the number of vowels in the initial window of size `k`.
 * - Store this count as the current maximum.
 * - Then, slide the window across the string:
 *   - Subtract the contribution of the character leaving the window.
 *   - Add the contribution of the character entering the window.
 *   - Update the maximum count if the current count is larger.
 * - Return the maximum number of vowels found across all windows.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed once in the sliding window.
 * - Space Complexity: O(1) → Only variables for counts are used.
 */

class Solution {
    public int maxVowels(String s, int k) {
        int vowels =0;
        
        for(int i=0; i<k; i++){
            char ch = s.charAt(i);
            if(ch == 'a'|| ch== 'e'|| ch== 'i' || ch== 'o' || ch == 'u'){
                    vowels++;
            }  
        }
        int maxVowels = vowels;
      
        for(int i=k; i<s.length(); i++){
            char leaving = s.charAt(i-k);
            if(leaving == 'a'|| leaving== 'e'|| leaving== 'i' || leaving== 'o' || leaving == 'u'){
                    vowels--;
            }
            char entering = s.charAt(i);
                 if(entering == 'a'|| entering== 'e'|| entering== 'i' || entering== 'o' || entering == 'u'){
                    vowels++;
            }
            maxVowels = Math.max(maxVowels, vowels);
            }
             return maxVowels;
        }
        
       

       
    }
