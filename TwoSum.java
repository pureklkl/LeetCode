public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        int[] resIndex = new int[2];
        for(int i=0; i<nums.length; i++){
            Integer res = index.get(target-nums[i]);
            if(res==null){
                index.put(nums[i], i);
            }else{
                resIndex[0]=res>i?i:res;
                resIndex[1]=res>i?res:i;
            }
        }
        return resIndex;
    }
}
