public class Solution {
    /**
    Brute force: if brute force, we will keep ai and then try all with [ai+1...an], but we don't necessary to do that.
    *
    * 
    Basic idea is: for height[] a1...an, if ai<aj s.t. i<j, then no other value in [ai+1...aj-1] combined with ai can make a bigger 
    * container than [ai,aj].
    * note that we calucate the area by min(ai, aj)*(j-i) which means other choices of aj won't change the first term and the scecond term
    * must be smaller than j-i.
    * As a reslut we have get the max area amoung all areas that begin at ai and end with [ai+1...aj], so we move to next which is ai+1.
    */
public int maxArea(int[] height) {
    int l=0, r=height.length-1, maxA=0;
    while(l<r){
        maxA=Math.max(maxA, (Math.min(height[l], height[r])*(r-l)));
        if(height[l]<height[r]){
            l++;
        }else{
            r--;
        }
    }
    return maxA;
}
