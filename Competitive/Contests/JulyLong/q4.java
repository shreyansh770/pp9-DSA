import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

public class q4 {
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

    public static int rec(int num, int maxn, int ssf, int sumn, int t, int ans) {

        if (t == 0 || ssf >= sumn)
            return (ssf <= sumn ? ans : -(int) 1e9);

    
        int res = 0;
        for (int i = maxn; i >=1; i--) {

            res = Math.max(res, rec(i, maxn, ssf + i, sumn, t - 1, ans + i * i));
        }

        return res;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {
            int maxt = fs.nextInt();
            int maxn = fs.nextInt();
            int sumn = fs.nextInt();

            // System.out.println(rec(1, maxn, 0, sumn, maxt, 0));

            int[] res = new int[1];
            int startN = 0;
            boolean flag = true;

            for(int i=0;i<3;i++){
                flag = true;
            }

            // for(int i=1;i<=maxt;i++){

            //     if(!flag) break;

            //     int ssf = startN + maxn;

            //     boolean flag1 = true;

            //     if(ssf<=sumn && flag1){

            //         res[0] = res[0] + (int)Math.pow(maxn, 2) ;
            //         startN = startN + maxn;
            //     }else{

            //         if(startN != maxn){

            //             int sumso = sumn - startN;
            //             int add = (int)Math.pow(sumso, 2);
            //             res[0] = res[0] + add;
            //         }

            //         flag =false;
            //     }
            // }

            if(maxt*maxn<sumn){
                int ans = maxt*maxn*maxn;
                boolean f1 = true;
                int[] arr = new int[2];
                System.out.println(ans);
            }else{
                int floor = (int)Math.floor(sumn/maxn);
                int ans = floor * maxn*maxn + (sumn-floor*maxn)*(sumn-floor*maxn);
                boolean f1 = true;
                System.out.println(ans);
            }

            // System.out.println(res[0]);
        }

    }
}
