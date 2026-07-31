/*
 * Problem: Container With Most Water
 * 
 * Approach:
 * The solution uses a two-pointer technique to maximize the area formed between two lines:
 * - Initialize `left` at the start and `right` at the end of the array.
 * - Compute the area as the product of the width (`right - left`) and the minimum height 
 *   between `height[left]` and `height[right]`.
 * - Update the maximum area found so far.
 * - Move the pointer pointing to the shorter line inward, since moving the taller line 
 *   cannot increase the area (width decreases and height is limited by the shorter line).
 * - Continue until the pointers meet.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each element is considered at most once.
 * - Space Complexity: O(1) → Only two pointers and a few variables are used.
 */

class Solution {
    public int maxArea(int[] height) {
     int max=0;
     int left=0;
     int right=height.length-1;
     while(left<right){
        int width = right-left;
        int hei = Math.min(height[left],height[right]);
        int area = width * hei;
        max = Math.max(area,max);

        if(height[left]<height[right]){
            left++;
        }
        else{
            right--;
        }

        
     }

     return max;
    

        
 

       
    }
}