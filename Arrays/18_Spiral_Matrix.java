
/*
 * Problem: Spiral Matrix
 * 
 * Approach:
 * The solution simulates the traversal of the matrix in spiral order by 
 * maintaining four boundaries: `top`, `bottom`, `left`, and `right`.
 * - Start by traversing from left to right across the top boundary, then 
 *   increment `top` to move inward.
 * - Traverse from top to bottom along the right boundary, then decrement `right`.
 * - If still within bounds, traverse from right to left across the bottom boundary, 
 *   then decrement `bottom`.
 * - If still within bounds, traverse from bottom to top along the left boundary, 
 *   then increment `left`.
 * - Repeat this process until all elements are visited.
 * - The conditions `top <= bottom` and `left <= right` ensure that traversal 
 *   stops when boundaries overlap.
 * 
 * Complexity:
 * - Time Complexity: O(m * n) → Each element of the matrix is visited exactly once.
 * - Space Complexity: O(1) → Aside from the output list, only boundary variables are used.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     
     List<Integer> spiral = new ArrayList<>();
     int top=0;
     int left=0;
     int right = matrix[0].length-1;
     int bottom = matrix.length-1;

     while(left<=right && top<=bottom){
        for(int i=left; i<=right; i++){
            spiral.add(matrix[top][i]);
        }
        top++;
        for(int i=top; i<=bottom; i++){
            spiral.add(matrix[i][right]);
        }
        right--;
        
        if(top<=bottom){
        for(int i=right; i>=left; i--){
            spiral.add(matrix[bottom][i]);
        }
        bottom--;
        }
        if(left<=right){
        for(int i=bottom; i>=top; i--){
            spiral.add(matrix[i][left]);
        }
        left++;
        }
     }

        return spiral;
       
       
       
    }
}