import java.util.*;

public class C276{

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int q = scn.nextInt();

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }

        int[] c = new int[n];
        while(q-->0){

            int l = scn.nextInt()-1;
            int r = scn.nextInt()-1;

            c[l]++;
            if(r+1<n) c[r+1]--;

        }

        for(int i=1;i<n;i++){
            c[i]  +=c[i-1];
        }

        Arrays.sort(arr);
        Arrays.sort(c);

        long ans = 0;
        for(int i=0;i<n;i++){
            ans = ans + arr[i]*c[i];
        }

        System.out.println(ans);
    }
}