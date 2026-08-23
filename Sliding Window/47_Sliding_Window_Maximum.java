/*
 * Problem: Sliding Window Maximum
 * 
 * Approach:
 * The task is to find the maximum value in each sliding window of size `k`:
 * - Use a double-ended queue (Deque) to store indices of elements in the current window.
 * - For each index `i`:
 *   - Remove indices from the front if they are outside the current window (`i - k + 1`).
 *   - Remove indices from the back while the corresponding element is less than or equal to `nums[i]`,
 *     ensuring the deque always stores indices of elements in decreasing order.
 *   - Add the current index `i` to the deque.
 *   - Once the first window is formed (`i >= k - 1`), the maximum element is at the front of the deque.
 *     Store it in the result array.
 * - Continue until all windows are processed.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is added and removed from the deque at most once.
 * - Space Complexity: O(k) → The deque stores indices of elements in the current window.
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {

                result[index] = nums[deque.peekFirst()];
                index++;
            }

        }

        return result;

    }
}