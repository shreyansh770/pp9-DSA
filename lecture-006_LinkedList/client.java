
public class client {
    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.addFirst(10);  
        ll.addFirst(12);
        ll.addFirst(7);
        ll.addFirst(1);
        System.out.println(ll.size());
        System.out.println(ll.removeAt(1));
        
        System.out.println(ll.size());

        
    }
}
