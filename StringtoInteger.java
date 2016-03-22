public class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        if(str.length()==0)
            return 0;
        int index=0, sign=1;
        long maxVal=Integer.MAX_VALUE;
        if(str.charAt(0)=='+')
            index++;
        if(str.charAt(0)=='-'){
            sign=-1;
            index++;
            maxVal++;
        }
        
        int len = str.length();
        long res=0;
        for(int i=index;i<len&&Character.isDigit(str.charAt(i));i++){
            res*=10;
            res+=str.charAt(i)-'0';
            if(res>maxVal)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return sign*((int)res);
    }
}
