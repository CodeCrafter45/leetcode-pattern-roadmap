/*
 * Problem: Range Sum Query - Immutable
 * * Approach:
 * Implemented using the Prefix Sum technique to optimize query time. 
 * During initialization, we precompute a running sum array (`prefix`) where `prefix[i]` 
 * stores the cumulative sum of elements from index 0 to `i`. 
 * This design allows the `sumRange(left, right)` method to fetch the sum of any sub-segment 
 * in constant time using the formula: `prefix[right] - prefix[left - 1]`. A boundary check 
 * handles cases where `left == 0`.
 * * Complexity:
 * - Constructor: 
 * - Time Complexity: O(n) - Single pass to precompute the prefix array.
 * - Space Complexity: O(n) - To store the cumulative sums.
 * - sumRange Query:
 * - Time Complexity: O(1) - Constant time lookup per query.
 * - Space Complexity: O(1) - No extra auxiliary space used during queries.
 */
class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        if (left == 0) {
            return prefix[right];
        }

        int sum = prefix[right] - prefix[left - 1];

        return sum;

    }

}