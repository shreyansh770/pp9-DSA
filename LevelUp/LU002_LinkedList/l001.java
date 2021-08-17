public class l001 {

    public static class ListNode {
        int data = 0;
        ListNode next = null;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static ListNode midNode(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            if (fast != null)
                fast = fast.next;
        }

        return prev;
    }

    public static ListNode reverse_recu(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = reverse_recu(head.next);

        ListNode tail = head.next;
        tail.next = head;

        head.next = null;

        return temp;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode middle = midNode(head);
        ListNode nhead = middle.next;
        middle.next = null;

        nhead = reverse(nhead);

        ListNode c1 = head;
        ListNode c2 = nhead;

        boolean flag = true;
        while (c1 != null && c2 != null) {
            if (c1.data != c2.data) {
                flag = false;
                break;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        nhead = reverse(nhead);
        middle.next = nhead;

        return flag;
    }

    public static void foldOfLinkedList(ListNode head) {
        if (head.next == null || head.next == null)
            return;

        ListNode temp = head; // 1-2-3-4-5-6-7-null
        ListNode mid = midNode(temp); //

        ListNode midNext = mid.next;
        mid.next = null; // 1-2-3-4 5-6-7

        midNext = reverse(midNext); // 7-6-5;

        ListNode c1 = temp;
        ListNode f1 = temp.next;

        ListNode c2 = midNext;
        ListNode f2 = midNext.next;

        while (c1 != null && c2 != null) {
            c1.next = c2;
            c1 = f1;
            if (f1 != null)
                f1 = f1.next;

            c2.next = c1;
            c2 = f2;
            if (f2 != null)
                f2 = f2.next;

        }

    }

    public static void unFoldOfLinkedList(ListNode head) {

        if (head == null || head.next == null)
            return;
        ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), c1 = d1, c2 = d2, c = head;

        while (c != null && c.next != null) {
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;

            c = c.next;
            if (c != null)
                c = c.next;
        }

        ListNode revHead = reverse(d2.next);

        c1.next = revHead;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) {
            ListNode rnode = head;
            head = head.next;
            slow.next = rnode.next;
            rnode.next = null;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode rnode = slow.next;
        slow.next = rnode.next;
        rnode.next = null;

        return head;

    }

    public static  ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(-1);// dummy Node
        ListNode ep = even;

        ListNode odd = new ListNode(-1);
        ListNode op = odd;

        ListNode curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }

            curr = curr.next;
        }

        ep.next = odd.next;

        op.next = null;
        head = even.next;
        return head;

    }

    public static ListNode segregate01(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode zero = new ListNode(-1);
        ListNode zp = zero;

        ListNode ones = new ListNode(-1);
        ListNode op = ones;

        ListNode curr = head;

        while(curr!=null){

            if(curr.data == 1){
              op.next = curr;
              op = op.next;
            }else{
  
                zp.next = curr;
                zp = zp.next;

            }

            curr = curr.next;
        }

        zp.next = ones.next;
        op.next = null;

        head = zero.next;

        return head;
    }

    public static ListNode segregate012(ListNode head) {
        if(head==null||head.next==null) return null;

        ListNode zero = new ListNode(-1);
        ListNode one  = new ListNode(-1);
        ListNode two = new ListNode(-1);

        ListNode zp = zero;
        ListNode op = one;
        ListNode tp = two;

        ListNode curr = head;

        while(curr!=null){
            if(curr.data == 0){
              zp.next = curr;
              zp = zp.next;
            }else if(curr.data == 1){
                op.next = curr;
                op = op.next;
            }else{
                tp.next = curr;
                tp = tp.next;
            }

            curr = curr.next;
        }

         op.next = two.next;
         zp.next = one.next;
          tp.next = null;
        head = zero.next;


        return head;
    }

    public static void main(String[] args) {

    }
}
