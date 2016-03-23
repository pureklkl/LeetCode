/**
*easily expand from 3Sum
*/

public class Solution {
    public int twoSumCloset(int[] nums, int begin, int target){
        int i=begin,j=nums.length-1;
        int dff = Integer.MAX_VALUE, sum=0;
        while(i<j){//we cannot skip duplicate numbers there...
            int cursum = nums[i]+nums[j], curdff=Math.abs(target-cursum);
            if(curdff<dff){
                dff=curdff;
                sum=cursum;
            }
            if(sum==target){
                return sum;
            }else if(cursum<target){
                i++;
            }else{
                j--;
            }
        }
        return sum;
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
            return 0;
        Arrays.sort(nums);
        int dff = Integer.MAX_VALUE, sum=0;
        for(int i=0;i<nums.length-2;i++){
            int s2=twoSumCloset(nums, i+1, target-nums[i]);
            int cursum=s2+nums[i], curdff=Math.abs(target-cursum);
            if(curdff<dff){
                dff=curdff;
                sum=cursum;
            }
        }
        return sum;
    }
}
