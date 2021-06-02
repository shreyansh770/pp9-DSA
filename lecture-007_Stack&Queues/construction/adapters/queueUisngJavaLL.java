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

        public static void main(String[] args) {
            queue q = new queue();
            for (int i = 1; i <= 10; i++) {
                q.add(i * 10);
            }

        }
    }
}
