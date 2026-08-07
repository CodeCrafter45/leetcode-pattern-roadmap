/*
 * Problem: Boats to Save People
 * 
 * Approach:
 * The goal is to minimize the number of boats needed to rescue people, given each boat 
 * can carry at most two people with a weight limit:
 * - First, sort the array of people's weights.
 * - Use two pointers: `left` at the lightest person and `right` at the heaviest person.
 * - If the sum of `people[left] + people[right]` exceeds the limit, the heavier person 
 *   must go alone, so decrement `right` and increment boat count.
 * - Otherwise, pair them together, increment `left`, decrement `right`, and increment boat count.
 * - Continue until all people are assigned to boats.
 * 
 * Complexity:
 * - Time Complexity: O(n log n) → Sorting dominates the runtime.
 * - Space Complexity: O(1) → In-place two-pointer traversal after sorting.
 */

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int numberOfBoats=0;
        Arrays.sort(people);
        int left= 0;
        int right= people.length-1;

        while(left<=right){
            if(people[left]+people[right]>limit){
                numberOfBoats++;
                right--;
            }
            else{
                    numberOfBoats++;
                    left++;
                    right--;
            }
        }

    return numberOfBoats;
    }
}