import java.util.*;

public class D1555 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        String s = scn.next();

        // baacb -> aa -> babcb -> cabcb

        // abbcaad -> cacad -> s(i) == s(n-1) && s(i+1)=>s(n-2)
        
        // abc and its permutation 

        int[][] dp = new int[6][n];

        String[] check = {"abc","acb","bac","bca","cab","cba"};

        for(int i=0;i<6;i++){
            for(int j=0;j<n;j++){

                if(j==0){
                    if(s.charAt(j)!=check[i].charAt(j%3)){

                        dp[i][j]=1;
                    }

                    continue;
                }
                if(s.charAt(j)==check[i].charAt(j%3)){
                    dp[i][j] = (j>0 ? dp[i][j-1] : 0);
                }else{
                    dp[i][j] = (j>0  ? dp[i][j-1]+1 : 0);
                }
            }
        }


        // for(int i=0;i<6;i++){
        //     for(int j=0;j<n;j++){

        //         System.out.print(dp[i][j]+" ");
        //     }

        //     System.out.println();
        // }

        while(m-->0){
            int l = scn.nextInt()-1;
            int r = scn.nextInt()-1;

            int res = (int)1e9;

            for(int i=0;i<6;i++){
                int v1 = dp[i][r];
                int v2 = (l>0 ? dp[i][l-1] : 0);
               res = Math.min(res , v1-v2);
            }

            System.out.println(res);
        }
    }
}
