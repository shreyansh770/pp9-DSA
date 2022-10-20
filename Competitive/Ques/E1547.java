import java.util.*;
import java.io.*;
public class E1547 {
    
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int q = scn.nextInt();
            while(q-->0){

                int n = scn.nextInt();
                int k = scn.nextInt();

                long[] res = new long[n];
                Arrays.fill(res,(long)1e18);
                long[] a = new long[k];
                for(int i=0;i<k;i++){
                    a[i] = scn.nextLong()-1; // a[i] = pos of ac
                }

                long[] t = new long[n];
                for(int i=0;i<k;i++){
                    
                    t[(int)a[i]] = scn.nextLong(); // t[i] = temp at pos of ac
                }

                PriorityQueue<Long> pq = new PriorityQueue<>();

                for(int i=0;i<n;i++){
                    if(t[i]>0) pq.add(t[i]-i);
                    if(pq.size()>0){
                        long top = pq.peek();
                        top+=i;
                        // System.out.println(top);
                        res[i] = Math.min(res[i],top);
                    }
                }

                pq = new PriorityQueue<>();
                for(int i=n-1;i>=0;i--){
                    if(t[i]>0) pq.add(t[i]+i);
                    if(pq.size()>0){
                        long top = pq.peek();
                        top-=i;
                        res[i] = Math.min(res[i],top);
                    }
                }

                for(long i : res){
                    System.out.print(i+" ");
                }

                System.out.println();

            }
    }
}
