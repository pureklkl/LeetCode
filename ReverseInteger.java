public class Solution {
    public int reverse(int x) {
        int res=0, minus=1;
        long maxVal=Integer.MAX_VALUE;
        if(x==Integer.MIN_VALUE)//if it equals to 2^-31, we cannot change it into positive
            return 0;
        if(x<0){
            x=-x;
            minus=-1;
            maxVal++;
        }
        while(x!=0){
            int a=x%10;
            if(res>maxVal-a)
                return 0;
            res+=a;
            x/=10;
            if(x==0)
                break;
            if(res>maxVal/10)
                return 0;
            res*=10;
        }
        return minus*res;
    }
}
