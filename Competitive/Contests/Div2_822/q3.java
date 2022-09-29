import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while(t-->0){

            int n = scn.nextInt();

            String c = scn.next();

            boolean[] rem = new boolean[n];

            long ans = 0;
            for(int i=1;i<=n;i++){
                if(c.charAt(i-1)=='0'){
                    for(int j=i;j<=n;j+=i){

                        if(c.charAt(j-1)=='1') break;
                        if(!rem[j-1]){
                            rem[j-1] = true;
                            ans+=i;
                        }
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
