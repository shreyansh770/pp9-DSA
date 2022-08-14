
import java.util.*;;

public class B295 {

    public static void reverse(int[] a) {

        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        long[][] edges = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges[i][j] = scn.nextInt(); // weights
            }
        }

        int[] del_order = new int[n];

        for (int i = 0; i < n; i++) {
            del_order[i] = scn.nextInt();
        }

        reverse(del_order);

        // k == i including del_order[k]
        ArrayList<Long> res = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            int inc_ver = del_order[k];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    edges[i][j] = Math.min(edges[i][j], edges[i][inc_ver] + edges[inc_ver][j]);
                }
            }

            // now including vertex till del_order[k] we will have to find sum b/w all such
            // edges
            long sum = 0;
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= k; j++) {
                    sum += edges[del_order[i]][del_order[j]];
                }
            }

            res.add(sum);

        }

        Collections.reverse(res);

        for(long r : res){
            System.out.print(r+" ");
        }
    }
}
