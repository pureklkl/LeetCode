public class Solution {
    
    /**
     *  need know string buffer
        the string is actually organized like this:
        a g
        bfh
        cei
        d
    */
    
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuffer[] nr = new StringBuffer[numRows];
        for(int i=0;i<numRows;i++){
            nr[i]=new StringBuffer();
        }
        int ii=0;
        while(ii<len){
            for(int v=0;v<numRows&&ii<len;v++)
                nr[v].append(s.charAt(ii++));
            for(int v=numRows-2;v>=1&&ii<len;v--)
                nr[v].append(s.charAt(ii++));
        }
        
        StringBuffer res = new StringBuffer();
        for(int i=0;i<numRows;i++){
            res.append(nr[i]);
        }
        return res.toString();
    }
}
