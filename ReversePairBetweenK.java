/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**I misunderstand the question, this code just reverse i and k+i node*/
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        int count=k;
        ListNode kns1=head;
        while(count-2>0&&kns1!=null){
            kns1=kns1.next;
            count--;
        }
        if(kns1!=null&&count-2==0){//we find it and exchange
            ListNode kn=kns1.next;
            if(kn==null)
                return head;
            ListNode headp1 = head.next, nextHead=kn.next;
            head.next=reverseKGroup(nextHead, k);
            if(kns1!=head){//k>=3, we need futher change two pointers
                kns1.next=head;
                kn.next=headp1;
            }else{//k==2, we need futher change one pointer
                kn.next=head;
            }
            return kn;
        }else{//
            return head;
        }
    }
}
