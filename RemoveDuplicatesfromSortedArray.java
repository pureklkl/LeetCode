public class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            nums[j]=nums[i];
            if(i<nums.length-1&&nums[i]==nums[i+1]) continue;
            j++;
        }
        return j;
    }
}
