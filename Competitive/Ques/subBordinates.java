import java.util.*;

public class subBordinates {
    

    
    public static int dfs(ArrayList<ArrayList<Integer>> graph,int src,int[] sub){

        if(graph.get(src).size()==0) {
            sub[src] = 1;
            return 1;
        }


        int count = 0;
        for(int nbr : graph.get(src)){
           count+= dfs(graph, nbr,sub);
        }

        sub[src] = count+1;
        return count+1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=2;i<=n;i++){
            int p = scn.nextInt();

            graph.get(p).add(i);
        }

        int[] sub = new int[n+1];
        // List<Integer> ans = new ArrayList<>();
        int res = dfs(graph, 1,sub);
        for(int i=1;i<=n;i++){
            System.out.print(sub[i]-1+" ");
        }
        

        
    }
}
