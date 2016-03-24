/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0),
                 m=start,i2=l2;
        start.next=l1;
        while(i2!=null){
            if(m.next==null){
                m.next=i2;
                break;
            }else if(m.next.val>i2.val){
                ListNode tmp1 = m.next, tmp2 = i2.next;
                m.next=i2;
                i2.next=tmp1;
                i2=tmp2;
            }else{
                m=m.next;
            }
        }
        return start.next;
    }
}
