/*
 * Problem: Minimum Window Substring
 * 
 * Approach:
 * The task is to find the smallest substring of `s` that contains all characters of `t`:
 * - Build a frequency map of characters in `t`.
 * - Use a sliding window with two pointers (`left` and `right`) and a second map (`window`) 
 *   to track character counts in the current window.
 * - Expand the window by moving `right` and updating counts:
 *   - If the frequency of a character in `window` matches that in `map`, increment `formed`.
 * - When `formed == required` (all characters matched), try shrinking the window from the left:
 *   - Update the minimum length and starting index if the current window is smaller.
 *   - Decrease the count of the character at `left` in `window`. If it falls below the required 
 *     frequency, decrement `formed`.
 *   - Move `left` forward to continue searching for smaller valid windows.
 * - After processing, return the substring of minimum length if found, otherwise return an empty string.
 * 
 * Complexity:
 * - Time Complexity: O(n + m) → Each character in `s` is processed once, and comparisons are constant-time.
 * - Space Complexity: O(n + m) → HashMaps store frequencies of characters in `t` and the current window.
 */


import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
    HashMap<Character, Integer > map = new HashMap<>();
    HashMap<Character, Integer > window = new HashMap<>();
    int left=0;
    int right=0;

    for(char c : t.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
    }

    int reuired = map.size();
    int formed=0;
    int minLength = Integer.MAX_VALUE;
    int start=0;
    while(right<s.length()){
        char c = s.charAt(right);
        if(map.containsKey(c)){
            window.put(c,window.getOrDefault(c,0)+1);

            if(window.get(c).equals(map.get(c))){
                formed++;
            }
        }
        right++;

        while(formed == reuired){
            int currentlength = right-left;
            if(currentlength<minLength){
                minLength=currentlength;
                start = left;
            }

            char leftchar = s.charAt(left);

            if(map.containsKey(leftchar)){
                window.put(leftchar,window.get(leftchar)-1);

                if(window.get(leftchar)<map.get(leftchar)){
                    formed--;
                }
            }

            left++;
    }
    } 
       if(minLength == Integer.MAX_VALUE){
                return "";
            }
            else{
               return s.substring(start,start+minLength);
            }
        
        
      

    }    
        
    

}