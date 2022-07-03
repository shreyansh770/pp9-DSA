public class q15 {
    static void linkdelete(Node head, int M, int N)
    {
        int count=0;
        Node node=new Node(-1);
        node.next=head;
	    Node temp=node;
	    Node connect=node;
	   while(temp!=null && temp.next!=null){
	       if(count==M){
	           
	           connect=temp;
	           int i=0;
	           while(i<=N){
	               connect=connect.next;
	               i++;
	           }
	           temp.next=connect;
	           count=0;
	       }
	       else{
	           count++;
	           temp=temp.next;
	   }
    }
}
