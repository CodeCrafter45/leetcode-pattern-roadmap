/*
 * Problem: Partition Labels
 * 
 * Approach:
 * The goal is to partition the string into as many parts as possible such that 
 * each letter appears in at most one part:
 * - First, record the last occurrence index of each character in the string 
 *   using a HashMap.
 * - Traverse the string with two pointers: `start` (beginning of the current partition) 
 *   and `end` (the farthest last occurrence seen so far).
 * - For each character, update `end` to the maximum of its last occurrence.
 * - When the current index `i` equals `end`, it means the partition can end here. 
 *   Add the partition size (`end - start + 1`) to the result list and move `start` 
 *   to `end + 1`.
 * - Continue until the entire string is processed.
 * 
 * Complexity:
 * - Time Complexity: O(n) → One pass to record last occurrences and one pass to partition.
 * - Space Complexity: O(1) → At most 26 entries in the HashMap for lowercase letters.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
       HashMap<Character,Integer> last = new HashMap<>();
       List<Integer> answer = new ArrayList<>();
        int start=0;
        int end=0;
    for(int i=s.length()-1; i>=0; i--){
        if(!last.containsKey(s.charAt(i))){
            last.put(s.charAt(i),i);
        }
    }

        for(int i=0; i<s.length(); i++){
            end = Math.max(end,last.get(s.charAt(i)));

            if(i==end){
                answer.add(end-start+1);
                start= end+1;
            }
        }
            return answer;
           
        }
    }
