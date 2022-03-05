import java.util.*;

public class B1469 {
    
    // we are adding the max prefix sum of red array and blue array
    // coz to restore the array with max f(a) w/o chainging the pos
    // of the way elements in red and blue sequence are appearing
    // 

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();

            int[] red = new int[n];

            int redmax = 0;
            int sum=0;
            for(int i=0;i<n;i++){
                red[i] = scn.nextInt();
                sum+=red[i];
                redmax = Math.max(redmax,sum);
            }

            int m = scn.nextInt();

            int[] blue = new int[m];
            int bluemax =0;
            sum=0;

            for(int i=0;i<m;i++){
                blue[i] = scn.nextInt();

                sum+=blue[i];
                bluemax = Math.max(bluemax,sum);
            }

            System.out.println(redmax+bluemax);
        }
    }
}
