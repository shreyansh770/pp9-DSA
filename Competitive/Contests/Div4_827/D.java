import java.util.*;
import java.io.*;

public class D {
    public static int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {

            int n = scn.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
            }

            List<List<Integer>> list = new ArrayList<>();

            for(int i=0;i<1001;i++){
                list.add(new ArrayList<>());
            }

            for(int i=0;i<n;i++){
                list.get(a[i]).add(i); // duplicacy
            }

            int ans = -1;
            for(int i=1;i<1001;i++){

                int s1 = list.get(i).size();
                
                if(s1>0){

                    boolean flag = false;

                    int res = 0;

                    for(int j=1;j<1001;j++){

                        int s2 = list.get(j).size();
                        int g = gcd(i, j);
                        if(s2>0 && g==1){
                            flag = true;
                            // finding the last index
                            int lasti = list.get(i).get(s1-1)+1;
                            int lastj = list.get(j).get(s2-1)+1;
                            
                            res = Math.max(res , lasti+lastj);
                        }
                    }

                    if(flag) {
                        ans = Math.max(ans,res);
                    }
                }
            }

            System.out.println(ans);

        }
    }
}
