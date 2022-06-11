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

        public static void main(String[] args) {
            FastReader fs = new FastReader();

            int t = fs.nextInt();

            while(t-->0){


                int n = fs.nextInt();

                int[] arr = new int[n];

                for(int i=0;i<n;i++){
                    arr[i] = fs.nextInt();
                }

                int left_ans = arr[0];

                int right_ans = arr[0];

                int ex = 1;

                boolean keepcheck = false;
                for(int i=1;i<n;i++){

                    if(left_ans <= arr[i]){
                        left_ans = arr[i];
                        keepcheck = true;
                    }else if(right_ans>= arr[i]){
                        right_ans = arr[i];
                    }else{
                        System.out.println("NO");
                        break;
                    }

                    if(keepcheck==true){
                        keepcheck = false;
                    }else{
                        keepcheck = true;
                    }

                    ex++;
                }


                if(ex==n){
                    System.out.println("YES");
                }
            }
        }
}
