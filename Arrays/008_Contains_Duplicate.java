/*
 * Problem: Contains Duplicate
 * * * Approach: 
 * Utilized a `HashSet` to keep track of elements we've seen so far. Since sets 
 * do not allow duplicate elements, the `.add()` method returns `false` if the 
 * element already exists in the set, signaling a duplicate instantly.
 * * * Complexity:
 * - Time Complexity: O(n) - Single pass through the array.
 * - Space Complexity: O(n) - In the worst case, storing all unique elements in the set.
 * * * Alternative Considerations:
 * Brute force takes O(n²). Sorting the array first takes O(n log n) time and O(1) auxiliary 
 * space, but the HashSet approach optimizes for time at the cost of space.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hashset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashset.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}