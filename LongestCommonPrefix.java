public class Solution {
    /**
    * straight forward..., if we use indexof , it will be much easier...
    *
    */
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        String res="";
        if(strs.length==0)
            return res;
        while(true){
            if(i>=strs[0].length())
                return res;
            char b = strs[0].charAt(i);
            for(int sn=1;sn<strs.length;sn++){
                if(i>=strs[sn].length()||b!=strs[sn].charAt(i)){
                    return res;
                }
            }
            res=res+b;
            i++;
        }
    }
}
