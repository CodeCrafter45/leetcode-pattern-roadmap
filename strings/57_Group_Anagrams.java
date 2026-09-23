/*
 * Problem: Group Anagrams
 * 
 * Approach:
 * The task is to group strings that are anagrams of each other:
 * - Use a HashMap where the key is the sorted version of a string, and the value is a list of strings 
 *   that share the same sorted key.
 * - For each string in the input array:
 *   - Convert it to a character array and sort the characters.
 *   - Convert the sorted array back into a string to form the key.
 *   - Insert the original string into the list corresponding to this key in the map.
 * - After processing all strings, return the values of the map as the grouped anagrams.
 * 
 * Complexity:
 * - Time Complexity: O(n * m log m) → For each of the `n` strings, sorting takes O(m log m), 
 *   where `m` is the length of the string.
 * - Space Complexity: O(n * m) → The HashMap stores all strings grouped by their sorted keys.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char [] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            if(!map.containsKey(sortedKey)){
                map.put(sortedKey,new ArrayList<>());
            }
            map.get(sortedKey).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
       
     
   