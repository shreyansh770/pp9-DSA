import java.util.*;;

public class q3 {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {

        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return arr[b] - arr[a];
        });
        int si = 0;
        int ei = 0;

        while (ei < n) {

            pq.add(ei);

            if (ei - si + 1 < k) {
                ei++;
            } else {

                res.add(arr[pq.peek()]);

                si++;
                ei++;
                while (pq.size() != 0 && pq.peek() < si) {
                    pq.remove();
                }
            }
        }

        return res;

    }

}
