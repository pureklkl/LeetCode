public class Solution {
    /**
     * longest record longest valid parentheses end at this point
     * all '(' is zero, no valid parenthese end at '('
     * then if we don't consider corner cases...
     * if(s.charAt(i-1)=='(')-> ...() longest[i] =  longest[i-2] + 2
     * else if(s.charAt(i-1-longest[i-1])=='(')-> ((...))  longest[i] =  longest[i-1] + 2 + longest[i-1-longest[i-1]-1]
    */
    public int longestValidParentheses(String s) {
        int[] longest = new int[s.length()];
        int len = s.length(), maxL=0;
        for(int i=1;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    longest[i] = i >= 2 ? longest[i-2] + 2 : 2;
                    maxL=Math.max(maxL, longest[i]);
                }else {
                    int lastVP = i-longest[i-1]-1;//cache up to speed up
                    int lastVPL = longest[i-1];
                    if(lastVP>=0 && s.charAt(lastVP)=='('){
                        longest[i] = lastVPL+2+(i-lastVPL-2>=0?longest[i-lastVPL-2]:0);
                        maxL=Math.max(maxL, longest[i]);
                    }
                }
            }
        }
        return maxL;
    }
}
