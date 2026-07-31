/*
 * Problem: 3Sum
 * 
 * Approach:
 * The solution extends the two-pointer technique used in the Two Sum problem:
 * - First, sort the array to simplify duplicate handling and enable two-pointer traversal.
 * - Iterate through the array, fixing one element (`nums[i]`) at a time.
 * - For each fixed element, use two pointers (`left` and `right`) to find pairs such that 
 *   `nums[i] + nums[left] + nums[right] == 0`.
 * - If the sum is zero, add the triplet to a set to ensure uniqueness, then move both pointers inward.
 * - If the sum is less than zero, increment `left` to increase the sum.
 * - If the sum is greater than zero, decrement `right` to decrease the sum.
 * - Finally, convert the set of unique triplets into a list and return it.
 * 
 * Complexity:
 * - Time Complexity: O(n^2) → Sorting takes O(n log n), and the two-pointer search runs in O(n^2).
 * - Space Complexity: O(n) → A set is used to store unique triplets before converting to a list.
 */


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null && nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);

    }

}