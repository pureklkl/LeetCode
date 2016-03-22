public class Solution {
    /**
    *   find the kth element in the merged array.
    *   k represent the kth element in the merged array, which index should be k-1.
    *   
    *   
    */
    
    public double findK(int[] a, int as, int al, int[] b, int bs, int bl, int k){
        if(al>bl)
            return findK(b, bs, bl, a, as, al, k);
        if(al==0)
            return b[bs+k-1];
        if(k==1)
            return Math.min(b[bs],a[as]);
   
        int ia=Math.min(k/2, al), ib=k-ia;
        if(a[as+ia-1]>b[bs+ib-1]){
            return findK(a, as, al, b, bs+ib, bl-ib, k-ib);
        }else if(a[as+ia-1]<b[bs+ib-1]){
            return findK(a, as+ia, al-ia, b, bs, bl, k-ia);
        }else{
            return a[as+ia-1];
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        if(total%2==1){
            return findK(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2+1);
        }else{
            return (findK(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2)+findK(nums1, 0, nums1.length, nums2, 0, nums2.length, total/2+1))/2;
        }
    }
}
