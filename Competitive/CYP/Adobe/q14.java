import java.util.*;

public class q14 {
	static int[] findSmallestRange(int[][] arr, int n, int k) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			int r1 = a[0];
			int c1 = a[1];

			int r2 = b[0];
			int c2 = b[1];

			return Integer.compare(arr[r1][c1], arr[r2][c2]);
		});

		int maxno = 0;
		for (int i = 0; i < arr.length; i++) {
			pq.add(new int[] { i, 0 });
			maxno = Math.max(maxno, arr[i][0]);
		}

		int sr = -1;
		int er = -1;
		int range = (int) 1e9;
		while (pq.size() == k) {

			int[] top = pq.remove();

			int r = top[0];
			int c = top[1];
			int v = arr[r][c];
			if (maxno - v < range) {
				range = maxno - v;
				sr = v;
				er = maxno;
			}

			c++;

			if(c<arr[c].length){
               pq.add(new int[]{r,c});
			   maxno = Math.max(maxno, arr[r][c]);
			}

		}

		return new int[]{sr,er};

	}
}
