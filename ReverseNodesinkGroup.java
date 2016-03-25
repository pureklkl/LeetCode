/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
        Be careful with the end condition it should be the next head that before reversed!
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        int count=k;
        ListNode knp1=head;
        while(count>0&&knp1!=null){
            knp1=knp1.next;
            count--;
        }
        if(count==0){//we find it and exchange
            ListNode end=knp1;//record the end!
            knp1=reverseKGroup(knp1, k);//reverse remain
            ListNode prev = knp1;//reverse the link list, just as we usually do
            while(head!=end){
                ListNode nextNode = head.next;
                head.next=prev;
                prev=head;
                head=nextNode;
            }
            return prev;
        }else{//exceed the list remain unchanged
            return head;
        }
    }
}
