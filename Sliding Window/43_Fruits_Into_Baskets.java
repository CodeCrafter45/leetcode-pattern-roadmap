/*
 * Problem: Fruits Into Baskets
 * 
 * Approach:
 * The problem requires finding the length of the longest subarray containing at most two distinct types of fruits:
 * - Use a sliding window with two pointers (`left` and `right`) and a HashMap to track the count of each fruit type in the current window.
 * - Traverse the array with `right`:
 *   - Add the current fruit to the HashMap and update its count.
 *   - If the HashMap size exceeds 2 (more than two distinct fruits), shrink the window from the left:
 *     - Decrease the count of the fruit at `left`.
 *     - If its count becomes zero, remove it from the HashMap.
 *     - Move `left` forward until only two fruit types remain.
 * - At each step, calculate the window size (`right - left + 1`) and update the maximum length.
 * - Return the maximum length found.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each fruit is processed at most twice (once by `right`, once by `left`).
 * - Space Complexity: O(2) → The HashMap stores at most two fruit types at any time.
 */

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxfruits = 0;
        int right = 0;
        for (right = 0; right < fruits.length; right++) {
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);

                if (fruitCount == 1) {
                    basket.remove(fruits[left]);
                } else {
                    basket.put(fruits[left], fruitCount - 1);

                }
                left++;
            }
            maxfruits = Math.max(maxfruits, right - left + 1);
        }
        return maxfruits;
    }
}