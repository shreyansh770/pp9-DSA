public class l001 {

    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
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
            if (c1.val != c2.val) {
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

        while (c != null) {
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;

            c = c.next;
            if (c != null)
                c = c.next;
        }

        c1.next = null;
        ListNode rhead = reverse(d2.next);
        c1.next = rhead;

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

    public static ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(-1);// dummy Node
        ListNode ep = even;

        ListNode odd = new ListNode(-1);
        ListNode op = odd;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val % 2 == 0) {
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

        if (head == null || head.next == null)
            return head;

        ListNode zero = new ListNode(-1);
        ListNode zp = zero;

        ListNode ones = new ListNode(-1);
        ListNode op = ones;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else {

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
        if (head == null || head.next == null)
            return null;

        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);

        ListNode zp = zero;
        ListNode op = one;
        ListNode tp = two;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                zp.next = curr;
                zp = zp.next;
            } else if (curr.val == 1) {
                op.next = curr;
                op = op.next;
            } else {
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

    /* Merge Sort Linked List */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = middleNode(head);

        ListNode nhead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nhead);

        return mergeTwoLists(left, right);

    }

    /* Merge K sorted List */

    public static ListNode mergeKsortedLL(ListNode[] lists, int si, int ei) {
        if (si == ei)
            return lists[si];

        int mid = (si + ei) / 2;

        ListNode left = mergeKsortedLL(lists, si, mid);
        ListNode right = mergeKsortedLL(lists, mid + 1, ei);

        return mergeTwoLists(left, right);
    }

    public static ListNode mergeKsortedLL(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKsortedLL(lists, 0, lists.length - 1);
    }

    /* Reverse in k Groups */

    private static ListNode th = null, tt = null;

    private static void addFirstNode(ListNode node) {
        if (th == null) {
            th = tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int length(ListNode head) {
        if (head == null)
            return 0;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        int len = length(head);
        ListNode curr = head, oh = null, ot = null;
        while (len >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            th = tt = null;
            len -= k;
        }

        ot.next = curr;
        return oh;
    }

    /* Reverse in Range */

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        if (head == null || head.next == null)
            return head;

        if (n == m)
            return head;

        ListNode curr1 = head;
        ListNode curr2 = head;
        ListNode prev = curr1;
        ListNode ahead = curr2.next;

        while (--n > 0) {
            prev = curr1;
            curr1 = curr1.next;
        }

        while (--m > 0) {
            curr2 = curr2.next;
            ahead = curr2.next;
        }

        curr2.next = null;
        if (prev != curr1)
            prev.next = null;

        ListNode temp = reverse(curr1);

        if (prev != curr1)
            prev.next = temp;

        curr1.next = ahead;

        if (head != curr1) {
            return head;
        } else {
            return temp;
        }

    }

    public static ListNode reverseInRange_02(ListNode head, int n, int m) {

        if (head == null || head.next == null)
            return head;

        if (n == m)
            return head;

        ListNode dummy = new ListNode(-1), prev = dummy, curr = head;
        prev.next = head;
        int i = 1;

        while (i <= m) {

            while (i >= n && i <= m) {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }

            if (i > m) {
                prev.next = th;
                tt.next = curr;
                break;
            }

            i++;

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;

    }

    /* Remove duplicates */

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode trav = head.next;

        while (trav.next != null) {

            if (trav.val != curr.val) {
                curr.next = trav;
                curr = trav;
            }

            trav = trav.next;
        }

        if (trav.next == null && trav.val == curr.val)
            curr.next = null;

        return head;
    }

    /* Remove all duplicates */

    public static ListNode removeAllDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode fwrd = head.next;

        while (fwrd != null) {

            boolean isCycle = false;
            while (fwrd != null && prev.next.val == fwrd.val) {
                fwrd = fwrd.next;
                isCycle = true;
            }

            if (isCycle) {
                prev.next = fwrd;
            } else {
                prev = prev.next;
            }

            if (fwrd != null)
                fwrd = fwrd.next;

        }

        return dummy.next;
    }

    /* Add two linkedlist */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = new ListNode(-1); // dummy.
        ListNode itr = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            carry = sum / 10;
            sum = sum % 10;

            itr.next = new ListNode(sum);
            itr = itr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return reverse(head.next);
    }

    /* Subtract two linkedlist */

    public static int getLength(ListNode head) {
        if (head == null)
            return 0;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public static boolean isBiggerList(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        if (len1 > len2)
            return true;
        else if (len1 < len2)
            return false;

        ListNode c1 = l1, c2 = l2;
        while (c1 != null) {
            if (c1.val > c2.val)
                return true;
            else if (c1.val < c2.val)
                return false;

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = null, c2 = null;
        if (isBiggerList(l1, l2)) {
            c1 = reverse(l1);
            c2 = reverse(l2);
        } else {
            c1 = reverse(l2);
            c2 = reverse(l1);
        }

        ListNode dummy = new ListNode(-1), prev = dummy;
        int borrow = 0;
        while (c1 != null || c2 != null) {
            int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
            if (diff < 0) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }

            prev.next = new ListNode(diff);
            prev = prev.next;

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        ListNode ans = reverse(dummy.next);
        prev = dummy;
        prev.next = null;
        ListNode c = ans;
        while (c != null) {
            if (c.val != 0) {
                prev.next = c;
                break;
            }

            ListNode forw = c.next;
            c.next = null;
            c = forw;
        }

        return dummy.next != null ? dummy.next : new ListNode(0);
    }

    /* Multiply two linked lists */

    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode forw = curr.next; // backup.

            curr.next = prev; // connection

            prev = curr; // move forw.
            curr = forw;
        }

        return prev;
    }

    public static void addTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode prev = l1;
        int carry = 0;
        while (l2 != null || carry != 0) {
            int sum = carry + (prev.next != null ? prev.next.val : 0) + (l2 != null ? l2.val : 0);

            carry = sum / 10;
            sum %= 10;

            if (prev.next != null)
                prev.next.val = sum;
            else
                prev.next = new ListNode(sum);

            if (l2 != null)
                l2 = l2.next;
            prev = prev.next;
        }
    }

    public static ListNode multiplyLinkedListWithDigit(ListNode l1, int digit) {
        ListNode dummy = new ListNode(-1); // dummy.
        ListNode prev = dummy;
        ListNode curr = l1;

        int carry = 0;
        while (curr != null || carry != 0) {
            int sum = carry + (curr != null ? (curr.val * digit) : 0);

            carry = sum / 10;
            sum = sum % 10;

            prev.next = new ListNode(sum);
            prev = prev.next;

            if (curr != null)
                curr = curr.next;

        }

        return dummy.next;
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode ans = new ListNode(-1); // dummy.
        ListNode ans_itr = ans;
        ListNode l2_itr = l2;

        while (l2_itr != null) {
            ListNode head = multiplyLinkedListWithDigit(l1, l2_itr.val);
            l2_itr = l2_itr.next;
            addTwoLinkedList(ans_itr, head);
            ans_itr = ans_itr.next;
        }

        ans = ans.next;
        return reverseList(ans);
    }

    /* Copy Linkedlist With Random Pointers */

    // a->a->b->b->c->c
    public static void copyList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            ListNode fwrd = curr.next;
            ListNode node = new ListNode(curr.val);
            curr.next = node;
            node.next = fwrd;
            curr = fwrd;
        }
    }

    public static void copyRandoms(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }
    }

    public static ListNode extractList(ListNode head){

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr!=null){
            ListNode fwrd = curr.next.next;//backup

            prev.next = curr.next;//links
            curr.next = fwrd;

            curr = fwrd;//mmove
            prev = prev.next;

        }

        return dummy.next;
    }
   

    public static ListNode copyRandomList(ListNode head) {

        copyList(head);
        copyRandoms(head);

        return extractList(head);


    }

    public static void main(String[] args) {

    }
}
