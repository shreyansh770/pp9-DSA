import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class q4 {

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

        while(t-->0){
            int N = fs.nextInt();

            int[] arr = new int[N];

            for(int i=0;i<N;i++){
                arr[i] = fs.nextInt();
            }

            HashMap<Integer,Integer> map = new HashMap<>();

            int maxRes = 0;

            int ans = N;

            int prev = N-1;

            boolean flag =false;

            int finals = ans;

            for(int i=0;i<N;++i){

                prev = N-i-1;

                finals = ans;


                
                if(map.containsKey(arr[i])){

                    maxRes  = Math.max(map.get(arr[i]),maxRes);

                }else{

                    maxRes = Math.max(maxRes,0);
                }

                // System.out.print(maxRes+" ");

                map.put(arr[i],1+i);

                int toadd = maxRes+prev;

                int minPPos = Math.min(maxRes,prev) +toadd;

                flag = false;
                

                ans = Math.min(ans,minPPos);

                finals = Math.min(ans,finals);

                flag = true;
                
            }

            System.out.println(ans);

        }

    }
}
