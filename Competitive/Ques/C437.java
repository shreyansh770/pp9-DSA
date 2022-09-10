import java.util.*;

public class C437 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int e = scn.nextInt();

        int[] arr = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            pq.add(new int[]{arr[i],i});
        }

        List<List<Integer>> g = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;

            int w = Math.min(arr[u], arr[v]);

            g.get(u).add(v);
            g.get(v).add(u);

           
        }

        

        int idx = 0;
        boolean[] rem = new boolean[n];
        int sum = 0;
        while(pq.size()!=0 && idx<n){

            int[] top = pq.remove();

            int w = top[0];
            int s = top[1];

            rem[s] = true;
            for(int nbr : g.get(s)){
                if(!rem[nbr]){
                    sum += w;
                    // rem[nbr] = true;
                }
            }

            idx++;
        }

        System.out.println(sum);
    }
}
