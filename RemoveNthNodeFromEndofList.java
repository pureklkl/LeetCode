    /**
     *  Add a special pointer to the start of the list, so that we can handle the case which we need delete the head
        two pointers, fast is alway n+1 forward than the slow, so that when the fast points to the end of the list, slow will point to the 
        node just behind the node need to be deleted
        so sad I don't realize it at first glance....
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start= new ListNode(0),//in case we need to delete the head 
                 fast = head,
                 slow = start;
        slow.next=head;
        for(int i=0;i<n&&fast!=null;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
    }
