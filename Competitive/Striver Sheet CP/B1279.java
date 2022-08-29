import java.util.*;

public class B1279 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();
            int s = scn.nextInt();

            int[] arr = new int[n];
            long sum = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return arr[b]-arr[a];
            });
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
                sum+=arr[i];
            }

            if(sum<=s) System.out.println(0);
            else {
                
                boolean took_out = false;
                int res = 0;
                long ssf = 0;
                for(int i = 0;i<n;i++){
                    ssf +=arr[i];
                    pq.add(i);
                    if(ssf>s){
                        if(took_out) break;
                        res = pq.remove();
                        ssf-=arr[res];
                        took_out = true;
                    }
                }

                System.out.println(res+1);
            }

        }
    }
}
