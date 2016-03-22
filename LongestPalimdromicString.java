public class Solution {
    /**
    should use Manacher algorithm.
    it is a simple central detection.
    another should be the tire tree algorithm.
    */
    public int expand(String s, int c1, int c2){
        int l=c1, r=c2, len=s.length();
        while(l>=0&&r<len&&s.charAt(l)==s.charAt(r)){l--;r++;}
        return (r-1-(l+1))+1;
    }
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len==0)
            return "";
        int c=0, l=0;
        String res;
        for(int i=0;i<len-1;i++){
            int resV, resW;//V stand for abba whose central is between two characters, W for aba which centra is at a character.
            resV=expand(s, i,i+1);
            resW=expand(s, i,i);
            int ic, il;
            if(resV>resW){
                ic = -(i+1);//stand for center is between i and i+1. We choose the right one so that the index won't be equal to 0 which cannot judge it type
                il = resV;
            }else{
                ic = i;
                il = resW;
            }
            if(il>l){
                c=ic;
                l=il;
            }
        }
        if(c<0){
            c=-c;
            res=s.substring(c-l/2, c+l/2);
        }else{
            res=s.substring(c-l/2, c+l/2+1);
        }
        return res;
    }
}
