/*
 * Problem: Trapping Rain Water
 * 
 * Approach:
 * The problem requires calculating the total water trapped between bars after rainfall:
 * - Precompute the maximum height to the left of each index (`leftmax`) and to the right (`rightmax`).
 * - For each position `i`, the water level is determined by the minimum of `leftmax[i]` and `rightmax[i]`.
 * - The trapped water at index `i` is `level - height[i]`, which is added to the total.
 * - This ensures that water is only counted where there is a boundary on both sides.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Three passes: one for `leftmax`, one for `rightmax`, and one to calculate water.
 * - Space Complexity: O(n) → Two auxiliary arrays are used to store left and right maximums.
 */

class Solution {
    public int trap(int[] height) {
        int leftmax[] = new int[height.length];
        int rightmax[] = new int[height.length];
        int water=0;
        leftmax[0] = height[0];
        rightmax[rightmax.length-1] = height[height.length-1];

        for(int i=1; i<height.length; i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }
        for(int i=height.length-2; i>=0; i--){
            rightmax[i] = Math.max(rightmax[i+1],height[i]);
        }

        for(int i=0; i<height.length; i++){
            int level = Math.min(leftmax[i],rightmax[i]);

            water+= level - height[i];
        }
            return water;

       
    }
}