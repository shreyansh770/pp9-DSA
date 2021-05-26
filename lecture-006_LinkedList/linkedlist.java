
// static keyword -> create a ref of all the static functions in stack
public class linkedlist {

    private class Node {
        int data = 0;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head;
        while(curr!=null){
            sb.append(curr.data);
            if(curr.next!=null){
                sb.append(", ");
            }
            curr = curr.next;
        }

        sb.append("]");
        return sb.toString();
    }



    /********************************************************/


    private void addFirstNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        this.size++;

    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }


    /********************************************************/

    
    private void addLastNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }


    /********************************************************/


    private Node removeFirstNode()
    {
        Node node  = this.head;
        if(this.size == 1) this.head = this.tail = null;
        else{
           this.head = this.head.next;
           node.next = null;
        }
 
        this.size--;
        return node;
    }

    public int removeFirst(){
       if(this.size==0)
           return -1;
      
        Node node =  removeFirstNode();
       return node.data;
    }


    /********************************************************/


    private Node getFirstNode()
    {
        return this.head;
    }

    public int getFirst()
    {
        if(this.size == 0) return -1;

        return getFirstNode().data;
    }


    /********************************************************/


    private Node getLastNode()
    {
        return this.tail;
    }

    public int getLast()
    {
        if(this.size == 0) return -1;

        return getLastNode().data;
    }


    /********************************************************/


    private Node getNodeAt(int idx)
    {
        Node temp = this.head;

       while(idx-- > 0){
         temp = temp.next;
       }

       return temp;
    }

    public int getAt(int idx)
    {
       if(idx >= this.size || idx < 0) return -1;

       return getNodeAt(idx).data;
    }


    /********************************************************/


    private Node removeLastNode()
    {
        Node node = this.tail;
        if(this.size == 1) this.head = this.tail = null;
        else{
            Node secondLast = getNodeAt(this.size-2);
            secondLast.next = null;
            this.tail = secondLast;
        }

        this.size --;
        return node;
    }

    public int removeLast(){
        if(this.size == 0) return -1;
        
        Node node = removeLastNode();
        return node.data;
    }


    /*******************************************************/


    private Node removeNodeAt(int idx){
        
        if(idx==0) return removeFirstNode();
        else if(idx == this.size-1) return removeLastNode();
        else{
            Node prevNode = getNodeAt(idx-1);
            Node node  = getNodeAt(idx);

            prevNode.next = node.next;
            node.next = null;

            this.size -- ;

            return node;
        }
       
    }

    public int removeAt(int idx){
        if(idx<0 || idx>=this.size) return -1;

        return removeNodeAt(idx).data;
    }


    /*******************************************************/

    private void addNodeAt(Node node ,int idx)
    {
       if(idx==0) addFirstNode(node);
       else if (idx == this.size) addLastNode(node);
       else{
          Node prevNode = getNodeAt(idx-1);
          Node fwdNode = prevNode.next;
          prevNode.next = node;
          node.next = fwdNode;
          this.size ++;
       }
    }
    
    public void addAt(int idx , int data){

           if(idx < 0 || idx > this.size) return ;
        
           Node node  = new Node(data);
           addNodeAt(node, idx);
    }


    /******************************************************/

    public void oddEvenList()
    {
         Node even  = new Node(-1);//dummy Node
         Node ep = even;

         Node odd  = new Node(-1);
         Node op = odd;

         Node curr = this.head;

         while(curr!=null)
         {
             if(curr.data % 2 == 0)
             {
                 ep.next = curr;
                 ep = ep.next;
             }else{
                op.next = curr;
                op = op.next;
             }

             curr = curr.next;
         }

         op.next = even.next;

         ep.next = null;
         this.head = odd.next;
         
         if(even.next != null){
             this.tail = op;
         }else{
            this.tail = ep;
         }
    }

    /****************************************************/

    public void removeDuplicates(){
        Node temp1 = head;
        Node temp2 = head;
        
        while(temp2!=null)
        {
            if(temp1.data == temp2.data)
            {
                temp2 = temp2.next;
            }else{
                temp1.next = temp2;
                temp1 = temp2;
            }
        }
        
        temp1.next = temp2;
      }

}
