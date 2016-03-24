/**
  Straight forward from 2 sum to k sum
*/

public class Solution {
    public List<List<Integer>> sumTwo(int[] nums, int begin,int target){
        int i=begin, j=nums.length-1;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        while(i<j){
            if(i>begin&&nums[i]==nums[i-1]){i++;continue;}
            if(j<nums.length-1&&nums[j]==nums[j+1]){j--;continue;}
            
            int sum=nums[i]+nums[j];
            if(sum==target){
                List<Integer> pair =new LinkedList<Integer>();
                pair.add(nums[i]);pair.add(nums[j]);
                res.add(pair);
                i++;j--;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
    
    public List<List<Integer>> kSum(int[] nums, int begin,int target, int k){
        if(k==2)
            return sumTwo(nums, begin, target);
        else{
            List<List<Integer>> res = new LinkedList<List<Integer>>();
            for(int i=begin;i<nums.length-1;i++){
                if(i>begin&&nums[i]==nums[i-1]){continue;}
                int p = nums[i];
                List<List<Integer>> k_1sum=kSum(nums, i+1, target-p, k-1);
                int k1sl=k_1sum.size();
                for(int i1=0;i1<k1sl;i1++){
                    k_1sum.get(i1).add(0, p);
                    res.add(k_1sum.get(i1));
                    
                }
            }
            return res;
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return new LinkedList<List<Integer>>();
        }
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
}
