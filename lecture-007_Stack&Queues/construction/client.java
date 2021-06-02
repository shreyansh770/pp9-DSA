public class client {

    public static void main(String[] args) throws Exception {
        // stack st = new stack();

        queue q = new queue(10);
        for (int i = 1; i <= 10; i++) {
            q.add(i * 10);
        }

       System.out.println(q);

    }
}
