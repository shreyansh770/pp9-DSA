import java.util.*;

public class D {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            String s = scn.next();

            char[] ch = new char[n];
            for(int i=0;i<n;i++){

                ch[i] = s.charAt(i);
            }
            int[] lsum = new int[n];
            int[] rsum = new int[n];
            long ssf = 0;
            for(int i=0;i<n;i++){
                lsum[i] = i;
                // System.out.print(lsum[i]+" ");
                
            }

            // System.out.println();
            for(int i=0;i<n;i++){
                rsum[i] = n-1-i;
                // System.out.print(rsum[i]+" ");
                
            }

            for(int i=0;i<n;i++){
                if(ch[i]=='L'){
                    // System.out.println(i);
                    ssf+=lsum[i];
                }else{
                    ssf+=rsum[i];
                }
            }

            // System.out.println(ssf);
            // int mid = (0 + n) / 2;
            // for (int i = 0; i < n; i++) {

            //     int lp =-1;
            //     // finding extreme L till mid
            //     for (int l = 0; l <= mid; l++) {
            //          if(ch[l]=='L') {lp=l;break;}
            //     }

            //     int rp = -1;
            //     // finding extreme R from mid+1 to right
            //     for (int r = n-1; r >= mid; r--) {
            //          if(ch[r]=='R') {rp=r;break;}
            //     }

            //     long lans = lp > -1 ? ssf - psum[lp] + (n-1-lp):-(long)1e9;
            //     long rans = rp>-1 ? ssf - psum[rp] + rp : -(long)1e9;

            //     // System.out.println(lans+" "+rans);

            //     if(lans==-(long)1e9 && rans==-(long)1e9 || ssf >lans && ssf>rans) {System.out.print(ssf+" "); continue;}
            //     if(lans!=-(long)1e9 && lans>=rans) {ch[lp]='R'; ssf = lans;}
            //     else if(rans!=-(long)1e9 ) {ch[rp] = 'L';ssf = rans;}

            //     System.out.print(ssf+" ");
                
            // }

            // int lp = 0;
            // int rp = n-1;
            // while(n-->0){

            //     while(lp<=rp){

            //         if(ch[lp]=='L' && ch[rp]=='L'){
            //             ch[lp] = 'R';
            //             ssf-=lsum[lp];
            //             ssf+=rsum[lp];
            //             break;
            //         }

            //         if(ch[lp]=='R' && ch[rp]=='R'){
            //             ch[rp] = 'L';
            //             ssf-=rsum[rp];
            //             ssf+=lsum[rp];
            //             break;
            //         }

            //         if(ch[lp]=='L' && ch[rp]=='R'){
            //             ch[lp] = 'R';
            //             ssf-=lsum[lp];
            //             ssf+=rsum[lp];
            //             break;
            //         }

            //         lp++;
            //         rp--;

            //     }

            //     System.out.print(ssf+" ");


            // }

            System.out.println();
        }
    }
}