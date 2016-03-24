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
                                :   l0->l1->...
                                    H   T   NH
        tmp.next=head;          :   l0<->l1 ... 
                                    H   T   NH
        head.next=nextHead;     :   l0<-l1  ...
                                    L______^
                                    H   T   NH
        head=tmp;               :   l0<-l1  ...
                                    L______^
                                        H   NH
                
    */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode tmp = head.next, nextHead = tmp.next;
        nextHead=swapPairs(nextHead);
        tmp.next=head;
        head.next=nextHead;
        head=tmp;
        return head;
    }
}
