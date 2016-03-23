public class Solution {
    /**
        backtracing
    */
    String[] nums2letter={"",//0
                      "",//1
                      "abc",//2
                      "def",//3
                      "ghi",//4
                      "jkl",//5
                      "mno",//6
                      "pqrs",//7
                      "tuv",//8
                      "wxyz",//9
                      };
    List<String> res = new LinkedList<String>();
    public void backtrace(int ni, String stmp, String digits){
        if(ni==digits.length()){
            res.add(stmp);
            return;
        }
        else{
            String s = nums2letter[digits.charAt(ni)-'0'];
            int sl=s.length();
            for(int i=0;i<sl;i++){
                backtrace(ni+1, stmp+s.charAt(i), digits);
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        return res;
        backtrace(0, "",digits);
        return res;
    }
}
