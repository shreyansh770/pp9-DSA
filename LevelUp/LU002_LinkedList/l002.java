public class l002 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }

        return false;

    }

    // this find the starting of cycle
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (slow != fast)
            return null;

        slow = head;

        // i have the mathematical proof
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // (B+C)
    public int getCycleLen(ListNode mp){

        ListNode curr = mp.next;
        int cycleLen = 1;

        while(curr!=mp){
            curr = curr.next;
            cycleLen++;
        }

        return cycleLen;
    }

    // A  = C + (B+C)(m-1);
    public ListNode cycleVariables(ListNode head){
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (slow != fast)
            return null;

        slow = head;
        ListNode mp = fast; // meeting point
        int cycleCount=0;//(m-1)
        int A = 0;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

            if(mp == fast) {
                
                cycleCount++; //  this is after cycle has been detected
            }   

            A++;
        }

        int cycleLen = getCycleLen(mp); // (B+C)
        int m =0; // no of rotation before meeting point( slow and fast)
        int C = 0;
        int B = 0;

        if(A!=0 && A % cycleLen==0){

             // if A is  a multiple of cycleLen
            m = cycleCount - 1; //  slow pointer cycle ke enter he nhi hua
            B = cycleLen;
        }else{
           
            m = cycleCount +1; 
            C = A - (cycleLen) * (cycleCount);
            B = cycleLen - C;
        }



        return slow;
    }

}
