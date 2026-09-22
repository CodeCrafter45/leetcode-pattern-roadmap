/*
 * Problem: Buddy Strings
 * 
 * Approach:
 * The task is to check if two strings `s` and `goal` can be made equal by swapping exactly two characters in `s`:
 * - First, check if the lengths of `s` and `goal` are different. If so, return false immediately.
 * - If `s` equals `goal`, then the strings are already identical:
 *   - In this case, check if there is at least one duplicate character in `s`. 
 *     If yes, swapping those duplicates keeps the string unchanged, so return true.
 *     Otherwise, return false.
 * - If `s` and `goal` differ:
 *   - Traverse both strings and record the indices where characters differ.
 *   - If there are more than 2 mismatches, return false.
 *   - If there are exactly 2 mismatches, check if swapping those two characters in `s` makes it equal to `goal`.
 *     If yes, return true; otherwise, return false.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is checked once.
 * - Space Complexity: O(n) → A HashSet is used to check duplicates when `s == goal`.
 */

import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
           return false;
               }
        if(s.equals(goal)){
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                if(!set.add(c)){
                    return true;
                }
            }

            return false;
        }
         int maxmiss=0;
         int first=0;
         int second=0;
         for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(maxmiss==0){
                 first=i;
                }
                else{
                    second=i;
                }
                maxmiss++;

                if(maxmiss>2){
                    break;
                }
            }
         }

         if(maxmiss==2 && s.charAt(first)==goal.charAt(second) && s.charAt(second) == goal.charAt(first)){
            return true;
         }
         else{
            return false;
         }
        

    }

    }
