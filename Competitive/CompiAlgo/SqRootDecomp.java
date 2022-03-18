import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// square root decomposition

// when we are given multiple ranges and we have to perform some operation
// in the given range like find min,max,sum etc 

// ex arr =  [1,2,3,59,101,19,21,2,1]
// ranges : [[1,4],[3,7],[2,6]] operation : find max

// the above can be done by brute force using ranges*length 

// to solve such ques we use sqrootDecom

//ALGO  

// first we make an array of size of sq_root(n^1/2) of given arr

// ex in above case it will be of length 3

// sqarr = [_,_,_]

// we traverse the array once and store the minimum of first three numbers at 0
// next three at 1 index and next 3 at 2 index

// how to find the group that a particular number belong to 

// IMP A) index/length 

// Ex number at index 2 will belong to 2/3 = 0 i.e to 0 index block in sq_root arr

// how to check when does a new block start

// IMP B) index%length

// Ex 0%3 =0 3%3 =0 6%3 = 0 this means that a new block starts at index 0 ,3 and 6

// if we are calculating for a range l,r and 
// l%len!=0 
// the we have iterarte from l calculating the operationg until we reach the start of another box

//  l%len==0 
// then how to make sure than r in greater than than the length of that sq_root block

// IMP C) l+len-1<=r 
// that means we can easily find our result from preprocesses sq_root array without interating that part in O(1)

public class SqRootDecomp {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-interview-prep/range-queries/square-root-decomposition-official/ojquestion
    public static void main(String[] args) {

        FastReader scn = new FastReader();

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(arr.length);
        scn.nextLine();
        int q = scn.nextInt();
        System.out.println(q);
        int[][] query = new int[q][2];

        for (int i = 0; i < q; i++) {
            query[i][0] = scn.nextInt();
            query[i][1] = scn.nextInt();
        }

        int sqLen = (int) Math.ceil(Math.sqrt(n));

        int[] sqArr = new int[sqLen];
        Arrays.fill(sqArr, (int) 1e9);

        for (int i = 0; i < n; i++) {

            // A
            sqArr[i / sqLen] = Math.min(sqArr[i / sqLen], arr[i]);
        }

        for (int i = 0; i < q; i++) {
            int l = query[i][0];
            int r = query[i][1];
            int ans = (int) 1e9;
            while (l <= r) {

                // B and C
                if (l % sqLen == 0 && l + sqLen - 1 <= r) {
                    ans = Math.min(ans, sqArr[l / sqLen]);
                    l += sqLen;
                } else {
                    ans = Math.min(ans, arr[l]);
                    l++;
                }

            }
            System.out.println(ans);

        }

    }

}
