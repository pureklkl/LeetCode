public class Solution {
    /**
        1. find longest non-increasing suffix(may have only one character)
        2. exchange it with the pivot character with the smallest character that bigger than the advanced character
        3. reverse the suffix (restart from a non-decresing suffix)
        2341->2431->2413
    */
    public void swapAE(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==0)
            return;
        int i=nums.length-1;
        while(i>0&&nums[i-1]>=nums[i]){
            i--;
        }
        System.out.println(i);
        int j;
        if(i>0){
            int pivot=nums[i-1];//pivot is at i-1!
            j=nums.length-1;
            while(nums[j]<=pivot){
                j--;
            }
            swapAE(nums, i-1,j);
        }
        j=nums.length-1;
        while(i<j){
            swapAE(nums, i, j);
            i++;
            j--;
        }
    }
}
