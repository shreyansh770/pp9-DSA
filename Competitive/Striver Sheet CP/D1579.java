import java.util.*;

public class D1579 {

    public static class talk {

        int no;
        int soc;

        talk(int no, int soc) {
            this.no = no;
            this.soc = soc;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            int[] s = new int[n];
            PriorityQueue<talk> pq = new PriorityQueue<>((a, b) -> {
                return b.soc - a.soc;
            });
            for (int i = 0; i < n; i++) {
                s[i] = scn.nextInt();
                if(s[i]>0)
                   pq.add(new talk(i + 1, s[i]));
            }

            int k = 0;
            List<int[]> pair = new ArrayList<>();
            while (pq.size() > 1) {

                talk p1 = pq.poll();
                if (pq.size() == 0)
                    continue;
                talk p2 = pq.poll();

                k++;

                pair.add(new int[] { p1.no, p2.no });

                int t1 = p1.soc - 1;

                int t2 = p2.soc - 1;

                if (t1 > 0)
                    pq.add(new talk(p1.no, t1));
                if (t2 > 0)
                    pq.add(new talk(p2.no, t2));
            }

            System.out.println(k);
            for (int[] i : pair) {
                System.out.print(i[0] + " " + i[1]);
                System.out.println();
            }

        }
    }
}
