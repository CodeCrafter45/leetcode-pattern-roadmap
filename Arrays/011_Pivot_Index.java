/*
 * Problem: Find Pivot Index
 * * Approach:
 * Solved using the Prefix Sum concept. First, we compute the `totalsum` of the entire array. 
 * As we iterate through the array a second time, we maintain a running `leftsum`. The 
 * `rightsum` at any index `j` can be dynamically derived in O(1) time using the mathematical 
 * relationship: `rightsum = totalsum - leftsum - nums[j]`. A pivot index is found the moment 
 * `leftsum == rightsum`.
 * * Complexity:
 * - Time Complexity: O(n) - Two sequential linear scans through the array (one to sum, one to find the pivot).
 * - Space Complexity: O(1) - Only a few primitive variables used, requiring constant auxiliary space.
 */
class Solution {
    public int pivotIndex(int[] nums) {
        
        int leftsum=0;
        int totalsum=0;

        for(int i=0; i<nums.length; i++){
            totalsum+=nums[i];
        }

        for(int j=0; j<nums.length; j++){
            int rightsum= totalsum - leftsum- nums[j];
            if(leftsum==rightsum){
                return j;
            }
            
            leftsum+=nums[j];
            
        }
     return -1;

    
    }
}