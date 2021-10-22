public class heapSort {

    // Time -> n + nlog(n)
    // Space ->O(1)

    public static boolean compareTo(int[] arr, int x, int y, boolean isIncreasing) {
        if (isIncreasing)
            return arr[x] > arr[y];
        return arr[y] > arr[x];
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void downHeapify(int[] arr, int pi, int li, boolean isInc) {
        int lci = 2 * pi + 1;

        int rci = 2 * pi + 2;
        int mi = pi;

        if (lci <= li && compareTo(arr, lci, mi, isInc)) {

            mi = lci;
        }

        if (rci <= li && compareTo(arr, rci, mi, isInc)) {
            mi = rci;
        }

        if (pi != mi) {
            swap(arr, mi, pi);
            downHeapify(arr, mi, li, isInc);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13, 14 };

        int li = arr.length - 1;
        boolean isInc = true;

        // creating a heap
        for (int i = li; i >= 0; i--) {
            downHeapify(arr, i, li, isInc);
        }

        // sort heap
        while (li > 0) {
            swap(arr, 0, li--);
            downHeapify(arr, 0, li, isInc);
        }

        for (int ele : arr)
            System.out.print(ele + " ");
    }
}
