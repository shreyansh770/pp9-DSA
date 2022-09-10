import java.util.*;

public class B475 {

    boolean[] vis;

    public void dfs1(int src,ArrayList<Integer>[] graph1){
        vis[src] = true;

        for(int nbr : graph1[src]){
            if(!vis[src]){
                
            }
        }
    }

    public void dfs2(int src,ArrayList<Integer>[] graph2){
        vis[src] = true;

        // for()
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        scn.nextLine();

        String hor = scn.next();
        String ver = scn.next();

        ArrayList<Integer>[] graph1 = new ArrayList[n];
        ArrayList<Integer>[] graph2 = new ArrayList[m];

        for (int i = 0; i < n; i++) {
            graph1[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            graph2[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            if (hor.charAt(i) == '>') {

                for (int j = 0; j < m - 1; j++) {
                    graph1[j].add(j + 1);
                    graph1[j + 1].add(j);
                }

            } else {

                for (int j = m - 1; j > 0; j--) {
                    graph1[j].add(j - 1);
                    graph1[j - 1].add(j);
                }

            }
        }

        for (int i = 0; i < m; i++) {
            if (ver.charAt(i) == '^') {

                for (int j = 0; j < n - 1; j++) {
                    graph2[j].add(j + 1);
                    graph2[j + 1].add(j);
                }

            } else {

                for (int j = n - 1; j > 0; j--) {
                    graph2[j].add(j - 1);
                    graph2[j - 1].add(j);
                }

            }
        }
    }

}
