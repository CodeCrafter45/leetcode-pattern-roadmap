/*
 * Problem: 4Sum
 * 
 * Approach:
 * This problem extends the logic of 3Sum by finding quadruplets that sum to a given target:
 * - First, sort the array to simplify duplicate handling and enable two-pointer traversal.
 * - Use two nested loops to fix the first two numbers (`nums[i]` and `nums[j]`).
 * - For each pair, apply the two-pointer technique (`left` and `right`) to find the remaining two numbers.
 * - Calculate the sum of the four numbers:
 *   - If the sum is less than the target, increment `left`.
 *   - If the sum is greater than the target, decrement `right`.
 *   - If the sum equals the target, add the quadruplet to a set to ensure uniqueness, then move both pointers inward.
 * - Finally, convert the set of unique quadruplets into a list and return it.
 * 
 * Complexity:
 * - Time Complexity: O(n^3) → Sorting takes O(n log n), and the nested loops with two-pointer search run in O(n^3).
 * - Space Complexity: O(n) → A set is used to store unique quadruplets before converting to a list.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }

            }
        }

        return new ArrayList<>(result);
    }
}