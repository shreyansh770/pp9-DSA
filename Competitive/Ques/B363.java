import java.util.*;

public class B363 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        int[] parr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        parr[0] = arr[0];

        for (int i = 1; i < n; i++) {
            parr[i] = parr[i - 1] + arr[i];
        }

        int si = 0;
        int ei = k - 1;
        int maxSum = (int)1e9;
        int ans = si;
        while (ei < n) {

            int sum = 0;
            if(si>0) sum = parr[ei] - parr[si-1];
            else sum = parr[ei];
            
            if(sum<maxSum){
                maxSum = sum;
                ans = si;
            }

            si++;
            ei++;
        }

        System.out.println(ans+1);
    }
}
