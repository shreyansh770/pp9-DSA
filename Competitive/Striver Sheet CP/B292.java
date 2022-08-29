import java.util.Scanner;

public class B292 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] indeg = new int[n+1];
        // int[] outdeg = new int[n];
        for(int i=0;i<m;i++){
            int u  =scn.nextInt();
            int v  =scn.nextInt();

            indeg[v]++;
            indeg[u]++;
        }

        int oc = 0;
        int tc = 0;
        int sc = 0;
        for(int i : indeg){
            if(i==1){
                oc++;
            }else if(i==2){
                tc++;
            }else if(i==n-1){
                sc++;
            }
        }

        if(sc==1 && oc==n-1){
            System.out.println("star topology");
        }else if(tc==n){
            System.out.println("ring topology");
        }else if(oc==2 && tc==n-2){
            System.out.println("bus topology");
        }else{
            System.out.println("unknown topology");
        }
    }
}
