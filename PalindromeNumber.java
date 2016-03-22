public class Solution {
    /**
        really tricky solution, use two pointer thinking, the first half is reversed.
        when number has odd digits, like 121, revhalf=12, shus revhalf/10
    */
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int slow=x, fast=x, revhalf=0;//
        while(fast!=0){
            revhalf=revhalf*10+slow%10;
            slow/=10;
            fast/=100;
        }
        return slow==revhalf||slow==revhalf/10;
    }
}
