import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {

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

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] arr = new int[n];

            LinkedList<Integer> st = new LinkedList<>();

            int onC = 0;
            int monC = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();

                if(arr[i]==1){
                    onC++;
                }else{
                    monC++;
                }
            }

            int diff = Math.abs(monC - onC);

            if(diff%2==0){
                System.out.println(diff/2);
            }else{
                System.out.println(-1);
            }

            Arrays.sort(arr);

            for(int i=0;i<n;i++){
                
                if(arr[i]==1){

                    if(st.size()!=0 && st.getFirst()==-1){
                        st.removeFirst();
                    }else{
                        st.addFirst(1);
                    }
                }else{
                    st.addFirst(arr[i]);
                }

            }


            // if()

        

        }

    }
}
