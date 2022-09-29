import java.util.*;

public class B505 {

    static List<List<int[]>> g;

    public static boolean dfs(int src, int dest, int ctype, boolean[] vis) {

        if (src == dest)
            return true;
        vis[src] = true;

        boolean res = false;
        for (int[] nbr : g.get(src)) {
            if (nbr[1] == ctype && !vis[nbr[0]]) {
                res = dfs(nbr[0], dest, ctype, vis);
                if(res) return true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        HashSet<Integer> color = new HashSet<>(); //
        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int c = scn.nextInt();

            color.add(c);
            g.get(u).add(new int[] { v, c }); // u ->[[v1,c1],[v2,c2]...]
            g.get(v).add(new int[] { u, c }); // u ->[[v1,c1],[v2,c2]...]
        }

        // for(int i=1;i<=n;i++){
        //     for(int[] nbr : g.get(i)){
        //         System.out.println(i+"->"+nbr[0]+","+nbr[1]);
        //     }
        // }
        int q = scn.nextInt();

        while (q-- > 0) {

            int u = scn.nextInt();
            int v = scn.nextInt();

            int count = 0;
            // loop through all possible colors
            for (int c : color) {

                // System.out.println("->"+c);
                boolean[] vis = new boolean[n+1]; // q*n

                boolean res = dfs(u, v, c, vis);
                if (res) {
                    count++;
                }

            }

            System.out.println(count);

        }

    }
}
