public class queueUsingSelfLinkedList {

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private void addFirst(int data){
        Node node =  new Node(data);
        if(this.size==0){
            this.head = this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }



    private Node removeFirst(){
        
    }

    public static class queue {
        

        public int size() {
            return 
        }

        public boolean isEmpty() {
            return 
        }

        public void add(int data) {
           addLast(data);
        }

        public int peek() {
            return getFirst();
        }

        public int remove() {
            return removeFirst();
        }

        public static void main(String[] args) {
            queue q = new queue();
            for (int i = 1; i <= 10; i++) {
                q.add(i * 10);
            }

        }
    }
}
