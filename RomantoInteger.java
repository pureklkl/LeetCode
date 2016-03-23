public class Solution {
    /**
    straight forward method from reverse string
    there is a more clear solution which used IV means V-I 
    thus res=res+(cur>=pre?cur:-cur);
    */
    public int romanToInt(String s) {
        int len = s.length(), res=0, i=0;
        s=new StringBuilder(s).reverse().toString();
        while(i<len){
            switch(s.charAt(i)){
                case 'I': res++;break;
                case 'V': if(i<len-1&&s.charAt(i+1)=='I') {res+=4;i++;}else{res+=5;}break;
                case 'X': if(i<len-1&&s.charAt(i+1)=='I') {res+=9;i++;}else{res+=10;}break;
                case 'L': if(i<len-1&&s.charAt(i+1)=='X') {res+=40;i++;}else{res+=50;}break;
                case 'C': if(i<len-1&&s.charAt(i+1)=='X') {res+=90;i++;}else{res+=100;}break;
                case 'D': if(i<len-1&&s.charAt(i+1)=='C') {res+=400;i++;}else{res+=500;}break;
                case 'M': if(i<len-1&&s.charAt(i+1)=='C') {res+=900;i++;}else{res+=1000;}break;
            }
            i++;
        }
        return res;
    }
}
