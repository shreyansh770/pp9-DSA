import java.util.*;

public class C779 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
           b[i]  =scn.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((i,j)->{
            int diff1 = a[i]-b[i] ;
            int diff2 = a[j]-b[j];

            return diff1 - diff2;
        });

        int ans = 0;
        for(int i=0;i<n;i++) pq.add(i);
        for(int i=0;i<k;i++) ans+= a[pq.poll()];

        while(pq.size()!=0){
            int idx  = pq.poll();
            ans+= Math.min(a[idx],b[idx]);
        }

        System.out.println(ans);

        
    }
}
