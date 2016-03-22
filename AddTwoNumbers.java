/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
 The most difficult part is that we should use a special head and return the head.next.
 */
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1=l1;
        ListNode c2=l2;
        ListNode resHead = new ListNode(0), iter = resHead;
        int carry=0;
        while(c1!=null||c2!=null){
            int res=0;
            if(c1!=null){
                res+=c1.val;
                c1=c1.next;
            }
            if(c2!=null){
                res+=c2.val;
                c2=c2.next;
            }
            iter.next = new ListNode((res+carry)%10);
            iter=iter.next;
            carry=(res+carry)/10;
        }
        if(carry!=0){
            iter.next=new ListNode(carry);
        }
        return resHead.next;
    }
}
