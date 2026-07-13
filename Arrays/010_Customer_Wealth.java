/*
 * Problem: Richest Customer Wealth
 * * Approach:
 * Solved using a nested loop to traverse the 2D matrix. The outer loop iterates 
 * through each individual customer (row), and the inner loop sums up their wealth 
 * across different bank accounts (columns). We maintain a running maximum (`maxWealth`) 
 * to track the highest total wealth encountered.
 * * Complexity:
 * - Time Complexity: O(m × n) - Where 'm' is the number of customers and 'n' is the number of banks. 
 * We must visit every element in the grid exactly once.
 * - Space Complexity: O(1) - Constant auxiliary space used.
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth=0;

        for(int i=0; i<accounts.length; i++){
            int currentwealth=0;
            for(int j=0; j<accounts[i].length; j++){
                currentwealth+= accounts[i][j] ;
               
            }

             if(currentwealth>maxwealth){
                maxwealth= currentwealth;
        }
        }

       

        return maxwealth;

    }

}