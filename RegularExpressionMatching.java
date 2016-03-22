public class Solution {
    /**
    dp solution:
    https://leetcode.com/discuss/93024/easy-dp-java-solution-with-detailed-explanation
    */
    public boolean match(String s, String p, int i, int j){
            //final check if matching
            if(j==p.length()) return i==s.length();
            //if the final character is *, p may be shorter by not repeating
            if(i==s.length()&&(j==(p.length()-1)||p.charAt(j+1)!='*')) return j==p.length();
                                                                                                        
            if(j==(p.length()-1)||p.charAt(j+1)!='*'){//next char is not *
               if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')//corresponding char is matched
                    return match(s, p, i+1, j+1);
                else
                    return false; //not matching
            }
            else{
                //if not match at beginning, we directly go to next
                while(i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
                    //we try every possible repeating times, if true we return, if wrong we try other, until we reach the end of string
                    if(match(s, p, i, j+2)) return true;
                    i++;                                
                }
                return match(s, p, i, j+2);//if not matching at beginning, i won't move
            }
    }
    
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);
    }
}
