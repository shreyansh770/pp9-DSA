import java.util.*;

public class LC_1135 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int e = scn.nextInt();
        List<int[]> connections = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int c = scn.nextInt();
            connections.add(new int[] { u, v, c });
        }
    }
}
