import java.util.*;

public class questions {

    // Nlog(k)
    public static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : arr) {
            pq.add(e);
            if (pq.size() > k)
                pq.remove();
        }

        return pq.peek();// kth largest
    }

    // Nlog(k)
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int e : arr) {
            pq.add(e);
            if (pq.size() > k)
                pq.remove();
        }

        return pq.peek();// kth smallest

    }

    public static void SortedArray() {

    }

    public static void main(String[] args) {

    }
}
