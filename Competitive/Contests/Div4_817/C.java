import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, List<Integer>> m = new HashMap<>();
            HashSet<String> s = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    s.add(scn.next());
                }

                for (String u : s) {

                    map.put(u, map.getOrDefault(u, 0) + 1);

                    if (m.containsKey(u)) {
                        m.get(u).add(i);
                    } else {
                        m.put(u, new ArrayList<>());
                        m.get(u).add(i);
                    }
                }

                s.clear();
            }

            int[] points = new int[3];

            for (Map.Entry<String, Integer> a : map.entrySet()) {

                String str = a.getKey();
                int v = a.getValue();

                if (v == 3)
                    continue;

                for (int i : m.get(str)) {

                    points[i] += (v == 2 ? 1 : 3);

                }
            }

            for(int i : points){
                System.out.print(i+" ");
            }
        }
    }
}