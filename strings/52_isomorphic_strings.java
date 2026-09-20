/*
 * Problem: Isomorphic Strings
 * 
 * Approach:
 * The task is to determine if two strings `s` and `t` are isomorphic (characters in `s` can be 
 * replaced to get `t` with a one-to-one mapping):
 * - First, check if the lengths of `s` and `t` are different. If so, return false immediately.
 * - Use two HashMaps:
 *   - `smap` maps characters from `s` to `t`.
 *   - `tmap` maps characters from `t` to `s`.
 * - Traverse both strings simultaneously:
 *   - If `smap` already maps `ch1` to a different character than `ch2`, return false.
 *   - If `tmap` already maps `ch2` to a different character than `ch1`, return false.
 *   - Otherwise, update both maps with the current mapping.
 * - If traversal completes without conflicts, return true.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed once.
 * - Space Complexity: O(n) → HashMaps store mappings for characters encountered.
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
         if(s.length()!=t.length()){
            return false;
         }

         HashMap<Character, Character > smap = new HashMap<>();
         HashMap<Character, Character > tmap = new HashMap<>();

         for(int i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(smap.containsKey(ch1) && smap.get(ch1)!=ch2) return false;
            if(tmap.containsKey(ch2) && tmap.get(ch2)!=ch1) return false;

            smap.put(ch1,ch2);
            tmap.put(ch2,ch1);
         }

      

       

     return true;
      
    }
}
     
