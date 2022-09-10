import java.util.*;

public class A940 {
    

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int d = scn.nextInt();

        int[] points = new int[n];

        for(int i=0;i<points.length;i++){
            points[i] = scn.nextInt();
        }

        Arrays.sort(points);

        // finding the longest possible series from ith pos

        int res = (int)1e9;
        for(int i=0;i<n;i++){
            int len = 0;

            for(int j=i;j<n;j++){
                if(points[j]-points[i]<=d) len++;
                else break;
            }

            res = Math.min(res , n-len);

        }

        System.out.println(res);
    }
}
