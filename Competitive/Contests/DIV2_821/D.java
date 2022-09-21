import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();
            int k = scn.nextInt();

            int[] arr = new int[n];

            int[] max = new int[105];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
                max[i%k] = Math.max(max[i%k],arr[i]);
            }
            long sum = 0;

            for(int i=0;i<k;i++){
                sum+=max[i];
            }
            
            System.out.println(sum);
        }
    }
}
