public class Solution {
    /**
    * easily expand from twoSum.
    **/
    public List<List<Integer>> twoSum(int[] nums, int target, int begin){
        int i=begin, j=nums.length-1;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        while(i<j){
            if(i>begin&&nums[i]==nums[i-1]) {i++;continue;}//skip all duplicate numbers
            if(j<nums.length-1&&nums[j]==nums[j+1]){j--;continue;}
            int sum = nums[i]+nums[j];
            if(sum==target){
                List<Integer> pair = new LinkedList<Integer>();
                pair.add(nums[i]);pair.add(nums[j]);
                res.add(pair);
                i++;j--;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> s3res = new LinkedList<List<Integer>>();
        if(nums.length<3){
            return s3res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;//skip all duplicate numbers
            List<List<Integer>> s2res = twoSum(nums, -nums[i], i+1);
            int resLen = s2res.size();
            for(int r=0;r<resLen;r++){
                List<Integer> s3=s2res.get(r);
                s3.add(0, nums[i]);
                s3res.add(s3);
            }
        }
        return s3res;
    }
}
