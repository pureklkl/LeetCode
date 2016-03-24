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
        improtant: recursive merge list, use vector to merge k list
    */
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwo(l1.next, l2);
            return l1;
        }else{
            l2.next=mergeTwo(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        LinkedList<ListNode> nr = new LinkedList<ListNode>();//next round
        //first round
        int len = lists.length-lists.length%2;
        for(int i=0;i<len;i+=2){
            nr.add(mergeTwo(lists[i],lists[i+1]));
        }
        if(lists.length%2==1)
            nr.add(lists[lists.length-1]);
        //next round
        while(nr.size()>1){
            nr.add(mergeTwo(nr.get(0),nr.get(1)));
            nr.remove(0);
            nr.remove(0);
        }
        return nr.get(0);
    }
}
