import java.util.*;

public class F1144 {

    // important points
    // 1) if a graph is not bipartite in can't be directed bcoz we wont be able to
    // handle odd cycles
    // 2) a node can either have incoming edges or outgoing edges not both because it
    // would lead to a graph with length greater than 1
    // 3) 

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<int[]>[] g = new ArrayList[(int)2e5+5];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            g[i] = new ArrayList<>();
        }

        
        for (int i = 0; i < m; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
            g[i].add(new int[]{u,v});
        }

        int[] colors = new int[n+1];
        Arrays.fill(colors,-1);
        int c = 0 ;// blue

        LinkedList<Integer> q = new LinkedList<>();

        q.add(1);

        while(q.size()!=0){

            int s = q.size();

            while(s-->0){
                int top = q.removeFirst();

                if(colors[top]!=-1){
                    if(colors[top]!=c){
                        System.out.println("NO");
                        return;
                    }

                    continue;
                }

                colors[top] = c;

                for(int nbr : graph.get(top)){
                    if(colors[nbr]==-1){
                        q.addLast(nbr);
                    }
                }
            }

            c = (c+1)%2;
        }

        System.out.println("YES");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int[] a = g[i].get(0); 
            if(colors[a[0]]==0){
               sb.append('0');
            }else{
                sb.append('1');
            }      
        }

        System.out.println(sb.toString());

    }
}