import java.util.LinkedList;

public class queueUisngJavaLL {
    public static class queue {
        private LinkedList<Integer> ll = new LinkedList<>();

        public int size() {
            return this.ll.size();
        }

        public boolean isEmpty() {
            return ll.isEmpty();
        }

        public void add(int data) {
            ll.addLast(data);
        }

        public int peek() {
            return ll.getFirst();
        }

        public int remove() {
            return ll.removeFirst();
        }

    }

    public static void main(String[] args) {
        queue q = new queue();

        q.add(10);
        q.add(20);
        q.remove();
        q.add(30);
        q.remove();
        q.add(40);
        q.add(50);
        q.add(60);

        while (q.size() != 0) {
            System.out.println(q.remove());
        }
    }
}
