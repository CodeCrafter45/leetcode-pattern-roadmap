/*
 * Problem: Set Matrix Zeroes
 * 
 * Approach:
 * The challenge is to set entire rows and columns to zero if any element is zero, 
 * while optimizing space usage by modifying the matrix in-place.
 * - Use the first row and first column of the matrix as markers to indicate which 
 *   rows and columns should be zeroed.
 * - Track separately whether the first row and first column themselves need to be 
 *   zeroed using two boolean flags (`firstrowzero`, `firstcolszero`).
 * - Traverse the matrix (excluding the first row and column) and mark the corresponding 
 *   row and column headers when a zero is found.
 * - In a second pass, update the matrix cells based on these markers.
 * - Finally, handle the first row and first column separately if they were flagged.
 * 
 * Complexity:
 * - Time Complexity: O(m * n) → Each cell is visited a constant number of times.
 * - Space Complexity: O(1) → No extra memory used apart from a few boolean flags.
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0) {
            return;
        }
        boolean firstrowzero = false;
        boolean firstcolszero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstrowzero = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstcolszero = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstrowzero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstcolszero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}