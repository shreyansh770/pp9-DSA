import java.util.*;
import java.io.*;
public class E {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();
                int q = scn.nextInt();

                int[] a = new int[n];

                long[] sum = new long[n];
                // long[] diff = new long[n];
                for(int i=0;i<n;i++){
                    a[i] = scn.nextInt();
                }

                sum[0] = a[0];

                // diff[0] = a[0];
                for(int i=1;i<n;i++){
                    sum[i] = sum[i-1] + a[i];
                    // diff[i] = Math.abs(a[i-1] - a[i]);
                }

                long[] sum2 = new long[n];

                sum2[0] = a[0];

                // diff[0] = a[0];
                for(int i=1;i<n;i++){
                    sum2[i] = sum2[i-1] + a[i];
                    // diff[i] = Math.abs(a[i-1] - a[i]);
                }


                while(q-->0){

                    int h = scn.nextInt();

                    long si = 0;
                    long ei = n-1;

                    long res = 0;
                    while(si<=ei){

                        long mid = (si+ei);

                        long hr = sum2[(int)mid];
                        // long d = diff[(int)mid];
                        long ha = mid== 0? h : (mid+1)*h;

                        if(ha>=hr){
                            res = a[(int)mid];
                            si=mid+1;
                        }else{
                            ei = mid-1;
                        }
                    }

                    System.out.print(res+" ");
                }

                System.out.println();
            }
    }
}
