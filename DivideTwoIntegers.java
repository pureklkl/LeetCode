public class Solution {
    //binary division
    public int divide(int dividend, int divisor) {
        long res=0;
        long dd=Math.abs((long)dividend),
             dr=Math.abs((long)divisor);
        boolean flag = ((dividend^divisor)&0x80000000)==0;//if the result is positive
        long maxVal=flag?(long)Integer.MAX_VALUE:-((long)Integer.MIN_VALUE);
        while(dd>=dr){
            long m=1, multmp=dr;
            while((multmp<<1)<dd){multmp<<=1;m<<=1;}
            dd-=multmp;
            if(res>maxVal-m){
                return Integer.MAX_VALUE;
            }
            res+=m;
        }
        if(flag)
            return (int)res;
        else
            return (int)-res;
    }
}
