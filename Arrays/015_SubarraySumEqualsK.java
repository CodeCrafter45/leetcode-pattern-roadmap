/*
 * Problem: Subarray Sum Equals K
 * * Approach:
 * Optimized using a Prefix Sum combined with a HashMap (Frequency Map).
 * The core concept relies on the mathematical identity: if the difference between the 
 * current cumulative sum (`prefixsum`) and the target value (`k`) has occurred previously 
 * in our array traversal, it implies that a contiguous subarray sums up exactly to `k`. 
 * We store the frequencies of all seen prefix sums in a HashMap. We initialize the map 
 * with `(0, 1)` to correctly account for subarrays that sum to `k` starting from index 0.
 * * Complexity:
 * - Time Complexity: O(n) - Single pass iteration through the array with O(1) average map operations.
 * - Space Complexity: O(n) - In the worst case, storing all unique prefix sums in the HashMap.
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

    Map<Integer, Integer> freq = new HashMap<>();

    int prefixsum=0;
    int count=0;
    freq.put(0,1);

    for(int i=0; i<nums.length; i++){
        prefixsum+= nums[i];

        if(freq.containsKey(prefixsum-k)){
            count+=freq.get(prefixsum-k);
        }

        freq.put(prefixsum,freq.getOrDefault(prefixsum,0)+1);
    }
    



        return count;


       
       
}
}