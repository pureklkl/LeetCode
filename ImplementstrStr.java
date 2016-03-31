public class Solution {
    //try kmp next time...
    public int strStr(String haystack, String needle) {
        int len = haystack.length(), len2=needle.length();
        if(len==0)
            return len2==0?0:-1;
        if(len2==0)
            return 0;
        for(int i=0;i<len;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                boolean match=true;
                int j;
                for(j=0;j<len2&&(i+j<len);j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        match=false;
                        break;
                    }
                }
                if(match&&j==len2)
                    return i;
                if(i+j==len)
                    return -1;
            }
        }
        return -1;
    }
}
