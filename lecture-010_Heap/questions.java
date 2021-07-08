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

    public static void SortedArray(int[][] arr) {
        int n = arr.length, m = arr[0].length;

        // a , b me 2D array ke 1D indexes ayenge
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a / m, c1 = a % m, r2 = b / m, c2 = b % m;
            return arr[r1][c1] - arr[r2][c2];
        });

        for (int i = 0; i < n; i++) {
            pq.add(i * m + 0); // har row ke first ele ka index daal rahe hai
        }

        int[] ans = new int[n * m];

        int idx = 0;

        while (pq.size() != 0) {
            int encIdx = pq.remove();// min value hai uska index milega
            int r = encIdx / m, c = encIdx % m;
            ans[idx++] = arr[r][c];// 2D array se us index se value nikal ke ans me daal denge
            c++;
            if (c < m) {// agr kisi ek row ke liye columns khtm ho jayenge to hum next smallest element ko dekhnge
                pq.add(r * m + c);
            }

        }

        for (int ele : ans)
            System.out.println(ele + " ");

    }



    public static void main(String[] args) {

    }
}
