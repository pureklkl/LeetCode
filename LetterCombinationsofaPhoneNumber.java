public class Solution {
    /**
        BFS like straight forward...
    */
    public List<String> letterCombinations(String digits) {
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
        int len=digits.length();
        List<String> res = new LinkedList<String>();
        for(int i=0;i<len;i++){
            String s = nums2letter[digits.charAt(i)-'0'];
            int sl = s.length();
            List<String> newRes = new LinkedList<String>();
            for(int i1=0;i1<sl;i1++){//pick each letter for number
                int resl = res.size();
                if(resl!=0){
                    for(int i2=0; i2<resl; i2++){//pick previous combination result, and combine with the new letter
                        newRes.add(res.get(i2)+s.charAt(i1));
                    }
                }else{
                    newRes.add(Character.toString(s.charAt(i1)));
                }
            }
            res=newRes;
        }
        return res;
    }
}
