// problem :Remove Element  
class Solution {
    public int removeElement(int[] nums, int val) {
        
       int read=0;
       int write=0;

       for(int i=0; i<nums.length; i++){
        if(nums[read]!=val){
            nums[write]=nums[read];
            write++;
        }
        read++;
       }

       return write;
        
    }
}