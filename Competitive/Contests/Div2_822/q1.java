import java.util.*;

public class q1{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            int[] l = new int[n];

            for(int i=0;i<n;i++){
                l[i] = scn.nextInt();
            }

            Arrays.sort(l);

            long min = (long)1e9;

            for(int i=0;i<n;i++){

                int mid = i+1;
                int left = i;
                int right = i+2;

                if(mid<n && right<n){
                    long cost = l[mid] - l[left] + l[right]-l[mid];
                    min = Math.min(cost,min);
                }
            }

            System.out.println(min);
        }
    }
}