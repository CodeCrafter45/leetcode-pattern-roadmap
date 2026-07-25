/*
 * Problem: Game of Life
 * 
 * Approach:
 * The solution simulates the next state of Conway's Game of Life in-place by 
 * encoding transitional states directly within the board:
 * - Use direction arrays (`rowDir`, `colDir`) to traverse all 8 neighbors of each cell.
 * - Count live neighbors by checking if a cell is currently alive (1) or marked as 
 *   "was alive but will die" (2).
 * - Apply the rules:
 *   - Live cell with fewer than 2 or more than 3 neighbors → mark as 2 (dies).
 *   - Dead cell with exactly 3 neighbors → mark as 3 (becomes alive).
 * - After the first pass, update the board:
 *   - Convert 2 → 0 (dead).
 *   - Convert 3 → 1 (alive).
 * - This encoding ensures the board is updated in-place without extra memory.
 * 
 * Complexity:
 * - Time Complexity: O(m * n) → Each cell and its 8 neighbors are checked once.
 * - Space Complexity: O(1) → In-place updates using encoded states, no extra arrays.
 */

class Solution {
    public void gameOfLife(int[][] board) {
        
      int rowDir[] = {-1,1,0,0,-1,-1,1,1};
      int colDir[] = {0,0,-1,1,-1,1,-1,1};
      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            int liveNeighbours=0;

            for(int k=0; k<8; k++){
                int newrow = i + rowDir[k];
                int newcol = j + colDir[k];

                if(newrow>=0 && newrow<board.length && newcol>=0 && newcol<board[0].length){
                    if(board[newrow][newcol]==1 || board[newrow][newcol]==2){
                        liveNeighbours++;
                    }
                }
            }

            if(board[i][j]==1){
                if(liveNeighbours<2 || liveNeighbours>3){
                    board[i][j]=2;
                }
            }
            else{
                if(liveNeighbours==3){
                    board[i][j]=3;
                }
            }
        }
      }

      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            if(board[i][j]==2){
                board[i][j]=0;
            }
            if(board[i][j]==3){
                board[i][j]=1;
            }
        }
      }
      

     
        
    }
}