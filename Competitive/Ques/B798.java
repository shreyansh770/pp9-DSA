import java.util.*;

public class B798 {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] s =new String[n];
        String[] d =new String[n];

        for(int i=0;i<n;i++){s[i] = scn.next();d[i]=s[i]+s[i];}

        int res = (int)1e9;
        for(int i=0;i<n;i++){

            String str = s[i];

            int cost = 0;
            for(int j=0;j<n;j++){

                int idx = d[j].indexOf(str); // cost to convert d[j] -> str // O(n)

                if(idx==-1){
                    System.out.println(-1);
                    return;
                }else{
                    cost+=idx;
                }
            }

            res = Math.min(cost,res);
        }

        System.out.println(res);
    }
}
