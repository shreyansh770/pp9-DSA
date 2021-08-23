public class doublyLinkedList {

    private class Node {
        int val = 0;
        Node next = null;
        Node prev = null;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /********************* EXCEPTIONS *******************/

    private void listIsEmptyException() throws Exception {

        if (this.size == 0) {
            throw new Exception("List Is empty");
        }
    }

    private void indexOutOfBounds(int idx) throws Exception {
        if (idx > this.size) {
            throw new Exception("Index out of bounds");
        }
    }

    /********************* BASIC FUNCTIONS *******************/

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void displayForw() {

        Node curr = this.head;
        System.out.print("[");
        while (curr != null) {
            if (curr.next != null) {
                System.out.print(curr.val + ", ");
            } else {
                System.out.print(curr.val);
            }

            curr = curr.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public void displayBack() {
        Node curr = this.tail;
        System.out.print("[");
        while (curr != null) {
            if (curr.prev != null) {
                System.out.print(curr.val + ", ");
            } else {
                System.out.print(curr.val);
            }
            curr = curr.prev;
        }
        System.out.print("]");
        System.out.println();
    }

    /********************* ADD FUNCTIONS *******************/

    private void addFirst(Node node) {

        if (this.size == 0) {
            this.head = node;
            this.tail = node;

        } else {
            node.next = head;
            this.head.prev = node;
            this.head = node;
        }

        this.size++;

    }

    public void addFirst(int val) {
        Node node = new Node(val);
        addFirst(node);
    }

    private void addLast(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    public void addLast(int val) {
        Node node = new Node(val);
        addLast(node);
    }

    private void addAt_(int idx, int val) {

        Node curr = this.head;
        Node node = new Node(val);

        if (idx == 0) {
            addFirst(val);
        } else if (idx == this.size) {
            addLast(val);
        } else {

            while (idx-- > 0) {
                curr = curr.next;
            }

            curr.prev.next = node;
            node.next = curr;
            node.prev = curr.prev;
            curr.prev = node;
            this.size++;

        }
    }

    public void addAt(int idx, int val) throws Exception {
        indexOutOfBounds(idx);
        addAt_(idx, val);

    }

    private void addBefore(Node refNode, int data) {

        Node node = new Node(data);
        Node prevRefNode = refNode.prev;
        if (prevRefNode == null) {
            node.next = refNode;
            refNode.prev = node;

            this.head = node;
        }

        else {

            prevRefNode.next = node;
            node.prev = prevRefNode;

            node.next = refNode;
            refNode.prev = node;

        }

        this.size++;
    }

    public void addBefore(int idx, int data) {
        Node node = getAt_(idx);
        addBefore(node, data);
    }

    private void addAfter(Node refNode, int data) {

        Node node = new Node(data);
        Node nextNode = refNode.next;

        if (nextNode == null) {
            node.prev = refNode;
            refNode.next = node;

            this.tail = node;
        } else {

            nextNode.prev = node;
            node.next = nextNode;

            refNode.next = node;
            node.prev = refNode;
        }

        this.size++;
    }

    public void addAfter(int idx, int data) {
        Node node = getAt_(idx);
        addAfter(node, data);
    }

    /********************* REMOVE FUNCTIONS *******************/

    private Node removeFirst_() {

        Node temp = head;

        if (this.size == 0)
            this.head = this.tail = null;
        else {
            this.head = head.next;
            temp.next = null;
        }

        this.size--;

        return temp;
    }

    public int removeFirst() throws Exception {
        listIsEmptyException();
        return removeFirst_().val;
    }

    private Node removeLast_() {
        Node temp = tail;

        if (this.size == 0)
            this.head = this.tail = null;
        else {

            tail = tail.prev;
            temp.prev = null;
            tail.next = null;
        }

        this.size--;
        return temp;

    }

    public int removeLast() throws Exception {
        listIsEmptyException();
        return removeLast_().val;
    }

    private Node removeAt_(int idx) {

        if (idx == 0) {
            return removeFirst_();
        } else if (idx == this.size - 1) {
            return removeLast_();
        } else {

            Node node = getAt_(idx);

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;

            this.size--;
            return node;
        }

    }

    public int removeAt(int idx) throws Exception {
        listIsEmptyException();
        indexOutOfBounds(idx);

        return removeAt_(idx).val;

    }

    private Node removeNode(Node refNode) {

        Node next = refNode.next;

        Node prev = refNode.prev;

        if (next == null) {

            this.tail = refNode.prev;
            refNode.prev = null;
            return refNode;
        } else if (prev == null) {
            this.head = refNode.next;
            refNode.next = null;
            return refNode;
        } else {

            refNode.prev.next = refNode.next;

            refNode.next.prev = refNode.prev;

            refNode.next = refNode.prev = null;

            return refNode;

        }

    }

    public int removeNode(int idx) {
        Node node = getAt_(idx);
        return removeNode(node).val;
    }

    private Node removeAfter(Node refNode) {
        Node remNext = refNode.next.next;
        Node rem = refNode.next;
        if (remNext == null) {
            refNode.next = null;
            rem.prev = null;
            this.tail = refNode;
        } else {

            remNext.prev = refNode;
            refNode.next = remNext;

            rem.prev = rem.next = null;

        }

        this.size--;

        return rem;
    }

    public int removeAfter(int idx) {
        Node node = getAt_(idx);
        return removeAfter(node).val;
    }

    private Node removeBefore(Node refNode) {
        Node remPrev = refNode.prev.prev;
        Node rem = refNode.prev;
        if (remPrev == null) {
            refNode.prev = null;
            rem.next = null;
            this.head = refNode;
        } else {

            remPrev.next = refNode;
            refNode.prev = remPrev;

            rem.prev = rem.next = null;

        }

        this.size--;

        return rem;
    }

    public int removeBefore(int idx) {
        Node node = getAt_(idx);
        return removeBefore(node).val;
    }

    /********************* GET FUNCTIONS *******************/

    public int getFirst() throws Exception {

        listIsEmptyException();

        return this.head.val;

    }

    public int getLast() throws Exception {

        listIsEmptyException();

        return this.tail.val;
    }

    private Node getAt_(int idx) {

        Node temp = this.head;

        while (idx-- > 0) {
            temp = temp.next;
        }

        return temp;
    }

    public int getAt(int idx) throws Exception {

        indexOutOfBounds(idx);

        return getAt_(idx).val;
    }

}
