/*
 * Problem: Majority Element
 * * Approach: 
 * Utilized Boyer-Moore's Voting Algorithm. The core intuition is that if an element 
 * appears more than n/2 times, it will always survive the cancellation process against 
 * other distinct elements. We maintain a `candidate` and a `count`, adjusting the vote 
 * dynamically as we traverse the array.
 * * Complexity:
 * - Time Complexity: O(n) - Single pass through the array.
 * - Space Complexity: O(1) - Constant auxiliary space.
 * * Alternative Considerations:
 * Sorting the array takes O(n log n) time, where the majority element would always 
 * occupy the middle index `nums[n/2]`. Boyer-Moore optimizes this to linear time.
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}