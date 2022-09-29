import java.util.*;
public class q1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();
            int c = scn.nextInt();

            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i=0;i<n;i++){
                int o =scn.nextInt();
                map.put(o,map.getOrDefault(o, 0)+1);
            }

            int cost = 0;

            for(Map.Entry<Integer,Integer> e : map.entrySet()){

                int v = e.getValue();
                cost += Math.min(v,c);
            }

            System.out.println(cost);
        }
    }
}