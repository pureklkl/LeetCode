public class Solution {
    /**
        Straight forward recursion
    */
    List<String> res = new LinkedList<String>();
    public void backTrace(String stmp, int remain, int count){
        if(remain==1){
            if(count==1){
                res.add(stmp+')');
            }
            return;
        }else{
            if(remain>count){
                backTrace(stmp+'(', remain-1, count+1);
            }
            if(count>0){
                backTrace(stmp+')', remain-1, count-1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return res;
        String stmp="(";
        backTrace(stmp, n*2-1, 1);
        return res;
    }
}
