import java.util.*;

public class Noor_and_his_pond {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            List<int[]> fish = new ArrayList<>(); // fish[i][0] = S ; fish[i][1] = E

            for (int i = 0; i < n; i++) {
                int s = scn.nextInt();
                int e = scn.nextInt();
                fish.add(new int[]{s,-1});
                fish.add(new int[]{e,1});
            }

            // if s and e are equal first s should appear
            // ex : [2 ,1] [ 3 , 2] 
            Collections.sort(fish,(int[] a , int[] b)->{
                return a[0]!=b[0] ? a[0]-b[0]:a[1]-b[1];
            });

            int ans = 1;
            int csf = 0;

            for(int i=0;i<n;i++){

                if(fish.get(i)[1]==-1){
                    csf--;
                }else csf++;

                ans = Math.max(csf,ans);
            }

            System.out.println(ans);

        }
    }
}



// S E
// 4 1 ,  5 4 ,  7 3
// size1 > E2  && size2 > E1