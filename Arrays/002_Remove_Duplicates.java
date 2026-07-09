//problem : Remove Duplicates from Sorted Array 
class Solution {
    public int removeDuplicates(int[] nums) {
        int s=1;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]!=nums[i+1]){
                nums[s]=nums[i+1];
                s++;
            }
        }

        return s;

}
}