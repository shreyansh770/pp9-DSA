public class questions {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // leetcode 876
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //leetcode 19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(n-- >0)
        {
            fast = fast.next;
        }
        
        if(fast == null) return head.next;
        
         while(fast.next!=null){
             slow = slow.next;
             fast = fast.next;
         }
        
        
        slow.next = slow.next.next;
    
        return head;
        
        
    }


    //206
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null) return head;
        
        ListNode p = null;
        ListNode c = head;
        
        
        while(c!=null)
        {
            
            ListNode f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        
        return p;
        
    }


    //21 

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null) return l1!=null ?l1:l2;

        ListNode dummy  = new ListNode(-1);
        ListNode prev = dummy ,c1 = l1 ,c2 = l2;
        
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;
        }
        
        prev.next = c1!=null ? c1 : c2;
        
        return dummy.next;
    }

}
