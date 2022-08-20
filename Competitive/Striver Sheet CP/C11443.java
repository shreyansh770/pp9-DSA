import java.util.*;

public class C11443 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            long[][] a = new long[n][2];

            for (int i = 0; i < n; i++) {
                a[i][0] = scn.nextLong(); // a
            }

            for (int i = 0; i < n; i++) {
                a[i][1] = scn.nextLong(); // b
            }

            Arrays.sort(a, (x, y) -> {
                return Long.compare(x[0], y[0]); // sorting on the basis of del time
            });


            long[] suff = new long[n+1];
            suff[0] = a[0][1];

            for(int i=n-1;i>=0;i--){
                suff[i] = suff[i+1] + a[i][1];
            }

            long min = (long)1e9;

            

            for(int i=n-1;i>=0;i--){
                // min = Math.min(min , Math.min(a[i][0] , pre[i]));
                min = Math.min(min , Math.max(a[i][0] , suff[i+1])); // 0 to i all del , i+1 to end all pickup
            }

            if(suff[0]<min){
                System.out.println(suff[0]);
            }else{
                System.out.println(min);
            }

            
        }
    }
}
