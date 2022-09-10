import java.util.*;

public class C1430{

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return b-a;
            });

            for(int i=1;i<=n;i++){
                pq.add(i);
            }

            ArrayList<int[]> list = new ArrayList<>();

            while(pq.size()>1){
                int no1 = pq.remove();
                int no2 = pq.remove();

                list.add(new int[]{no1,no2});

                int avg = (no1+no2+1)/2;
                pq.add(avg);
            }

            System.out.println(pq.peek());

            for(int i=0;i<list.size();i++){
                int x1 = list.get(i)[0];
                int x2 = list.get(i)[1];
                System.out.println(x1+" "+x2);
            }

        }
    }
}